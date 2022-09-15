package com.owenlejeune.mydex.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.owenlejeune.mydex.R
import com.owenlejeune.mydex.api.pokeapi.v2.PokemonService
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import com.owenlejeune.mydex.api.pokeapi.v2.viewmodel.PokemonViewModel
import com.owenlejeune.mydex.extensions.charAtFromEnd
import com.owenlejeune.mydex.extensions.header
import com.owenlejeune.mydex.extensions.lazyPagingItems
import kotlinx.coroutines.launch
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

        SmallTopAppBar(
            modifier = Modifier
                .statusBarsPadding()
                .blur(radius = 10.dp),
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

        val scrollState = rememberScrollState()

        val lazyPokemon = PokemonViewModel().pokemon.collectAsLazyPagingItems()

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(start = 36.dp, end = 36.dp, top = 160.dp)
                .fillMaxSize()
        ) {
            header {
                Text(
                    text = stringResource(id = R.string.main_screen_title),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                    modifier = Modifier.padding(bottom = 50.dp)
                )
            }

            lazyPagingItems(lazyPokemon) { item ->
                item?.let {
                    PokedexCard(pokemon = item)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexCard(
    pokemon: Pokemon
) {
    Card(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = R.drawable.pokeball_s,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = 20.dp, y = 0.dp)
                    .size(width = 96.dp, height = 96.dp),
                colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.15f))
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp),
                text = pokemon.name,
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
            )
        }
    }
}
