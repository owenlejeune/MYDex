package com.owenlejeune.mydex.ui.views

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.owenlejeune.mydex.extensions.WindowSizeClass
import com.owenlejeune.mydex.extensions.rememberWindowSizeClass
import com.owenlejeune.mydex.preferences.AppPreferences
import com.owenlejeune.mydex.ui.MainActivity
import com.owenlejeune.mydex.ui.components.MenuItemButton
import com.owenlejeune.mydex.ui.components.SearchBar
import com.owenlejeune.mydex.ui.navigation.DataNavItem
import org.koin.java.KoinJavaComponent
import kotlin.math.ceil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActivity.AppScaffold(
    appNavController: NavHostController,
    preferences: AppPreferences = KoinJavaComponent.get(AppPreferences::class.java)
) {
    val windowSize = rememberWindowSizeClass()

    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val topAppBarScrollState = rememberTopAppBarScrollState()
    val scrollBehavior = remember(decayAnimationSpec) {
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec, topAppBarScrollState)
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {

        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
        ) {
            MainContent(
                windowSize = windowSize,
                appNavController = appNavController,
                topBarScrollBehaviour = scrollBehavior
            )
        }
    }
}

@Composable
private fun BoxScope.MainContent(
    windowSize: WindowSizeClass,
    appNavController: NavHostController,
    topBarScrollBehaviour: TopAppBarScrollBehavior
) {
    if (windowSize != WindowSizeClass.Expanded) {
        SingleColumnMainContent(
            appNavController = appNavController
        )
    }
}

@Composable
private fun BoxScope.SingleColumnMainContent(appNavController: NavHostController) {
    val tint = MaterialTheme.colorScheme.secondaryContainer
    AsyncImage(
        model = com.owenlejeune.mydex.R.drawable.pokeball,
        contentDescription = null,
        modifier = Modifier
            .offset(x = 90.dp, y = (-40).dp)
            .size(width = 240.dp, height = 240.dp)
            .align(Alignment.TopEnd),
        colorFilter = ColorFilter.tint(tint)
    )

    Column(
        modifier = Modifier.padding(all = 36.dp)
    ) {
        Spacer(modifier = Modifier.height(120.dp))

        Text(
            text = stringResource(id = com.owenlejeune.mydex.R.string.main_screen_title),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        )

        Spacer(modifier = Modifier.height(50.dp))

        SearchBar(placeholder = stringResource(id = com.owenlejeune.mydex.R.string.main_search_placeholder)) {}

        Spacer(modifier = Modifier.height(32.dp))

        val cols = 2
        val rows = ceil(DataNavItem.Pages.size.toFloat()/cols.toFloat()).toInt()
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (i in 0 until rows) {
                val first = DataNavItem.Pages[2*i]
                val second = if (2*i+1 < DataNavItem.Pages.size) {
                    DataNavItem.Pages[2*i+1]
                } else {
                    null
                }
                MenuItemRow(appNavController = appNavController, first = first, second = second)
            }
        }
    }
}

@Composable
private fun MenuItemRow(
    appNavController: NavHostController,
    first: DataNavItem,
    second: DataNavItem?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MenuItemButton(
            modifier = Modifier.weight(1f),
            text = first.title,
            color = first.color,
            onClick = {
                appNavController.navigate(first.route)
            }
        )
        second?.let {
            MenuItemButton(
                modifier = Modifier.weight(1f),
                text = second.title,
                color = second.color,
                onClick = {
                    appNavController.navigate(second.route)
                }
            )
        }
    }
}