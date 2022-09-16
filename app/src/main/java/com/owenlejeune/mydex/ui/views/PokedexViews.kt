package com.owenlejeune.mydex.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
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
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.owenlejeune.mydex.R
import com.owenlejeune.mydex.api.pokeapi.v2.PokemonService
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonSpecies
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonType
import com.owenlejeune.mydex.api.pokeapi.v2.viewmodel.PokemonViewModel
import com.owenlejeune.mydex.extensions.getIdFromUrl
import com.owenlejeune.mydex.extensions.getNameForLanguage
import com.owenlejeune.mydex.extensions.header
import com.owenlejeune.mydex.extensions.lazyPagingItems
import com.owenlejeune.mydex.ui.components.PokemonTypeLabel
import com.owenlejeune.mydex.ui.navigation.MainNavItem
import com.owenlejeune.mydex.utils.AppCache
import com.owenlejeune.mydex.utils.ColorUtils
import org.koin.java.KoinJavaComponent.get

@Composable
fun PokedexView(
    appNavController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        val tint = MaterialTheme.colorScheme.secondaryContainer
        AsyncImage(
            model = R.drawable.pokeball,
            contentDescription = null,
            modifier = Modifier
                .offset(x = 90.dp, y = (-40).dp)
                .size(width = 240.dp, height = 240.dp)
                .align(Alignment.TopEnd),
            colorFilter = ColorFilter.tint(tint)
        )

        val lazyPokemon = PokemonViewModel().pokemon.collectAsLazyPagingItems()

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .fillMaxSize()
        ) {
            header {
                Column {
                    Spacer(modifier = Modifier.height(160.dp))

                    Text(
                        text = stringResource(id = R.string.pokedex_nav_title),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        ),
                        modifier = Modifier.padding(bottom = 50.dp)
                    )
                }
            }

            lazyPagingItems(lazyPokemon) { item ->
                item?.let {
                    PokedexCard(appNavController = appNavController, nameAndUrl = item)
                }
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
                    containerColor = Color.Transparent.copy(alpha = 0.4f)
                )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexCard(
    appNavController: NavController,
    nameAndUrl: NameAndUrl,
    service: PokemonService = get(PokemonService::class.java)
) {
    val pokemonId = nameAndUrl.url.getIdFromUrl()

    val pokemon = remember { mutableStateOf<Pokemon?>(AppCache.cachedPokemon[pokemonId]) }
    LaunchedEffect(key1 = pokemon.value) {
        fetchPokemon(nameAndUrl, service, pokemon)
    }

    val species = remember { mutableStateOf<PokemonSpecies?>(AppCache.cachedSpecies[pokemonId]) }
    LaunchedEffect(key1 = pokemon.value) {
        fetchPokemonSpecies(pokemon, species, service)
    }

    val defBg = ColorUtils.pokeColorToComposeColor(color = "")
    val bgColor = remember { mutableStateOf(defBg) }
    Card(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor.value),
        onClick = {
            pokemon.value?.let {
                appNavController.navigate("${MainNavItem.PokemonDetailView.route}/${it.id}")
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = R.drawable.pokeball_s,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = 20.dp, y = 20.dp)
                    .size(width = 96.dp, height = 96.dp),
                colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.15f))
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 12.dp)
            ) {
                species.value?.let { species ->
                    bgColor.value = ColorUtils.pokeColorToComposeColor(color = species.color.name)

                    val name = species.names.getNameForLanguage() ?: species.name
                    val dexNumber = pokemon.value!!.id.toString().padStart(3, '0')

                    Text(
                        modifier = Modifier
                            .align(Alignment.TopStart),
                        text = name,
                        style = MaterialTheme.typography.bodyLarge.copy(color = Color.White, fontWeight = FontWeight.Bold)
                    )

                    Column(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(top = 35.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        pokemon.value?.types?.forEach { type ->
                            val id = type.type.url.getIdFromUrl()
                            val pokemonType = remember { mutableStateOf<PokemonType?>(AppCache.cachedTypes[id]) }
                            LaunchedEffect(key1 = pokemonType.value) {
                                fetchPokemonType(id, pokemonType, service)
                            }

                            pokemonType.value?.let { t ->
                                val typeName = t.names.getNameForLanguage() ?: ""//type.type.name
                                PokemonTypeLabel(type = typeName)
                            }
                        }
                    }

                    Text(
                        modifier = Modifier
                            .align(Alignment.TopEnd),
                        text = "#${dexNumber}",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color.Unspecified.copy(alpha = 0.3f)
                    )

                    AsyncImage(
                        model = pokemon.value?.sprites?.frontDefault,
                        contentDescription = name,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(70.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }
    }
}

private suspend fun fetchPokemon(
    nameAndUrl: NameAndUrl,
    service: PokemonService,
    pokemon: MutableState<Pokemon?>
) {
    if (pokemon.value == null) {
        val id = nameAndUrl.url.getIdFromUrl()
        service.getPokemon(id).apply {
            if (isSuccessful) {
                body()?.let {
                    pokemon.value = it
                    AppCache.cachedPokemon.put(it.id, it)
                }
            }
        }
    }
}

private suspend fun fetchPokemonSpecies(
    pokemon: MutableState<Pokemon?>,
    species: MutableState<PokemonSpecies?>,
    service: PokemonService
) {
    if (species.value == null && pokemon.value != null) {
        service.getPokemonSpecies(pokemon.value!!.id).apply {
            if (isSuccessful) {
                body()?.let {
                    species.value = it
                    AppCache.cachedSpecies.put(it.id, it)
                }
            }
        }
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
