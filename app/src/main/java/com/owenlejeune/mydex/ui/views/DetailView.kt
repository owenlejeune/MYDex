package com.owenlejeune.mydex.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.owenlejeune.mydex.R
import com.owenlejeune.mydex.api.pokeapi.v2.PokemonService
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonSpecies
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonType
import com.owenlejeune.mydex.extensions.getIdFromUrl
import com.owenlejeune.mydex.extensions.getNameForLanguage
import com.owenlejeune.mydex.ui.components.PokemonTypeLabel
import com.owenlejeune.mydex.utils.AppCache
import com.owenlejeune.mydex.utils.ColorUtils
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
                        .padding(top = 140.dp),
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
                ) {

                }

                AsyncImage(
                    model = pokemon.sprites.frontDefault,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(250.dp)
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
                    containerColor = Color.Transparent//.copy(alpha = 0.4f)
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