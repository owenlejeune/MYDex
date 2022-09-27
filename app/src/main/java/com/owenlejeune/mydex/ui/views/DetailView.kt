package com.owenlejeune.mydex.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.owenlejeune.mydex.R
import com.owenlejeune.mydex.api.pokeapi.v2.PokemonService
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonSpecies
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonStat
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonType
import com.owenlejeune.mydex.extensions.adjustBy
import com.owenlejeune.mydex.extensions.getIdFromUrl
import com.owenlejeune.mydex.extensions.getNameForLanguage
import com.owenlejeune.mydex.ui.components.PokemonTypeLabel
import com.owenlejeune.mydex.ui.components.SmallTabIndicator
import com.owenlejeune.mydex.utils.*
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.get

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailView(
    pokemonId: Int,
    appNavController: NavController
) {
    val pokemonSpecies = AppCache.cachedSpecies[pokemonId]
    val pokemon = AppCache.cachedPokemon[pokemonId]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorUtils.pokeColorToComposeColor(color = pokemonSpecies.color.name))
    ) {
        AsyncImage(
            model = R.drawable.pokeball,
            contentDescription = null,
            modifier = Modifier
                .offset(y = 200.dp)
                .rotate(65f)
                .size(240.dp)
                .align(Alignment.TopCenter),
            colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.25f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            Header(pokemonSpecies = pokemonSpecies, modifier = Modifier.padding(horizontal = 36.dp))

            Box {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 150.dp),
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
                ) {
                    Details(pokemon = pokemon, pokemonSpecies = pokemonSpecies)
                }

                AsyncImage(
                    model = PokeUtils.spriteFromId(pokemonId),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.TopCenter)
                )
            }
        }

        SmallTopAppBar(
            modifier = Modifier
                .statusBarsPadding(),
            navigationIcon = {
                IconButton(onClick = { appNavController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            },
            title = {},
            colors = TopAppBarDefaults
                .smallTopAppBarColors(
                    containerColor = Color.Transparent
                )
        )
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    pokemonSpecies: PokemonSpecies,
    service: PokemonService = get(PokemonService::class.java)
) {
    val pokemon = AppCache.cachedPokemon.get(pokemonSpecies.id)

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val pokemonName = pokemonSpecies.names.getNameForLanguage() ?: pokemonSpecies.name
            Text(
                text = pokemonName,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                pokemon.types.forEach { type ->
                    val id = type.type.url.getIdFromUrl()
                    val pokemonType = remember { mutableStateOf<PokemonType?>(AppCache.cachedTypes[id]) }
                    LaunchedEffect(key1 = pokemonType.value) {
                        fetchPokemonType(id, pokemonType, service)
                    }

                    pokemonType.value?.let { t ->
                        val typeName = t.names.getNameForLanguage() ?: ""
                        PokemonTypeLabel(type = typeName)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val dexNumber = pokemon.id.toString().padStart(3, '0')
            Text(
                modifier = Modifier.align(Alignment.End),
                text = "#${dexNumber}",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )

            val genus = pokemonSpecies.genera.find { it.language.name == Locale.current.language }?.genus ?: ""
            Text(
                text = genus,
                modifier = Modifier.align(Alignment.End),
                style = TextStyle(
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun ColumnScope.Details(
    pokemon: Pokemon,
    pokemonSpecies: PokemonSpecies,
    service: PokemonService = get(PokemonService::class.java)
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    Spacer(modifier = Modifier.height(50.dp))

    val tabs = DetailTab.Items
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        divider = {}
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch { pagerState.animateScrollToPage(index) }
                }
            ) {
                Spacer(modifier = Modifier.height(18.dp))
                Text(text = tab.name, color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier.height(18.dp))
            }
        }
    }
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].screen(pokemon, pokemonSpecies, service)
    }
}

@Composable
private fun AboutView(
    pokemon: Pokemon,
    pokemonSpecies: PokemonSpecies,
    service: PokemonService
) {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(all = 24.dp)
            .verticalScroll(state = scrollState)
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BaseStatsView(
    pokemon: Pokemon,
    pokemonSpecies: PokemonSpecies,
    service: PokemonService
) {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(all = 24.dp)
            .verticalScroll(state = scrollState)
    ) {
        pokemon.stats.forEach { stat ->
            val statId = stat.stat.url.getIdFromUrl()

            val fullStat = remember { mutableStateOf<PokemonStat?>(null) }

            LaunchedEffect(key1 = fullStat.value) {
                fetchPokemonStat(statId, fullStat, service)
            }
            fullStat.value?.let {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = it.names.getNameForLanguage() ?: stat.stat.name,
                        modifier = Modifier.fillMaxWidth(.2f)
                    )
                    Text(
                        text = stat.baseStat.toString(),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    LinearProgressIndicator(
                        progress = (stat.baseStat.toFloat() / 255f),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(5.dp))
                    )
                }
            }
        }

        val doubleDamageRelations = remember { mutableSetOf<String>() }
        val halfDamageRelations = remember { mutableSetOf<String>() }
        val noDamageRelations = remember { mutableSetOf<String>() }

        val common = doubleDamageRelations.intersect(halfDamageRelations)
        val common2 = doubleDamageRelations.intersect(noDamageRelations)
        doubleDamageRelations.removeAll { it in common || it in common2 }
        halfDamageRelations.removeAll { it in common || it in common2 }
        noDamageRelations.removeAll { it in common || it in common2 }

        if (doubleDamageRelations.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.type_weaknesses_title),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(text = stringResource(R.string.type_weaknesses_description))
        }

        FlowRow(
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp
        ) {
            if (doubleDamageRelations.isEmpty()) {
                pokemon.types.forEach { t ->
                    val typeId = t.type.url.getIdFromUrl()
                    DataManager.getTypeById(typeId) { type ->
                        type.damageRelations.doubleDamageFrom.forEach {
                            val id = it.url.getIdFromUrl()
                            DataManager.getTypeById(id) { t ->
                                doubleDamageRelations.add(t.names.getNameForLanguage() ?: it.name)
                            }
                        }
                    }
                }
            }
            doubleDamageRelations.forEach { tr ->
                TypeRelationChip(type = tr)
            }
        }

        if (halfDamageRelations.isNotEmpty() || noDamageRelations.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.type_defences_title),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        if (halfDamageRelations.isNotEmpty()) {
            Text(text = stringResource(R.string.type_defences_half_description))
        }

        FlowRow(
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp
        ) {
            if (halfDamageRelations.isEmpty()) {
                pokemon.types.forEach { t ->
                    val typeId = t.type.url.getIdFromUrl()
                    DataManager.getTypeById(typeId) { type ->
                        type.damageRelations.halfDamageFrom.forEach {
                            val id = it.url.getIdFromUrl()
                            DataManager.getTypeById(id) { t ->
                                halfDamageRelations.add(t.names.getNameForLanguage() ?: it.name)
                            }
                        }
                    }
                }
            }
            halfDamageRelations.forEach { tr ->
                TypeRelationChip(type = tr)
            }
        }

        if (noDamageRelations.isNotEmpty()) {
            Text(text = stringResource(R.string.type_defences_no_description))
        }

        FlowRow(
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp
        ) {
            if (noDamageRelations.isEmpty()) {
                pokemon.types.forEach { t ->
                    val typeId = t.type.url.getIdFromUrl()
                    DataManager.getTypeById(typeId) { type ->
                        type.damageRelations.noDamageFrom.forEach {
                            val id = it.url.getIdFromUrl()
                            DataManager.getTypeById(id) { t ->
                                noDamageRelations.add(t.names.getNameForLanguage() ?: it.name)
                            }
                        }
                    }
                }
            }
            noDamageRelations.forEach { tr ->
                TypeRelationChip(type = tr)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TypeRelationChip (
    type: String
) {
    val color = ColorUtils.pokeTypeNameToComposeColor(type)
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp)),
        colors = CardDefaults.cardColors(
            containerColor = color
        )
    ) {
        Text(
            text = type,
            color = color.adjustBy(-.4f),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

private suspend fun fetchPokemonType(
    id: Int,
    pokemonType: MutableState<PokemonType?>,
    service: PokemonService
) {
    if (pokemonType.value == null) {
        service.getPokemonType(id).apply {
            if (isSuccessful) {
                body()?.let {
                    pokemonType.value = it
                    AppCache.cachedTypes.put(it.id, it)
                }
            }
        }
    }
}

private suspend fun fetchPokemonStat(
    statId: Int,
    pokemonStat: MutableState<PokemonStat?>,
    service: PokemonService
) {
    if (pokemonStat.value == null) {
        service.getPokemonStat(statId).apply {
            if (isSuccessful) {
                body()?.let {
                    pokemonStat.value = it
                    AppCache.cachedStats.put(it.id, it)
                }
            }
        }
    }
}

private sealed class DetailTab(
    stringRes: Int,
    route: String,
    val screen: @Composable (Pokemon, PokemonSpecies, PokemonService) -> Unit
): KoinComponent {

    companion object {
        val Items by lazy { listOf(About, BaseStats, Evolution, Moves) }
    }

    private val resourceUtils: ResourceUtils by inject()

    val name: String = resourceUtils.getString(stringRes)

    object About: DetailTab(
        stringRes = R.string.about_tab_title,
        route = "about_tab",
        screen = @Composable { pokemon, pokemonSpecies, service ->

        }
    )

    object BaseStats: DetailTab(
        stringRes = R.string.base_stats_tab_title,
        route = "base_stats_tab",
        screen = @Composable { p, ps, s -> BaseStatsView(p, ps, s) }
    )

    object Evolution: DetailTab(
        stringRes = R.string.evolution_tab_title,
        route = "evolution_tab",
        screen = @Composable { pokemon, pokemonSpecies, service ->

        }
    )

    object Moves: DetailTab(
        stringRes = R.string.moves_tab_title,
        route = "moves_tab",
        screen = @Composable { pokemon, pokemonSpecies, service ->

        }
    )

}