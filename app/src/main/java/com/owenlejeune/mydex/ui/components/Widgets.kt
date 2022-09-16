package com.owenlejeune.mydex.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.owenlejeune.mydex.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester = remember { FocusRequester() },
    requestFocus: Boolean = false,
    placeHolder: String = "",
    placeHolderTextColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    textColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    cursorColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = RoundedCornerShape(25.dp)
) {
    Surface(
        modifier = modifier
            .clip(shape),
        shape = shape,
        color = backgroundColor
    ) {
        Row(Modifier.padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (leadingIcon != null) {
                leadingIcon()
            }
            Box(modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxHeight()
                .weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                if (value.isEmpty() && placeHolder.isNotEmpty()) {
                    Text(
                        text = placeHolder,
                        style = textStyle,
                        color = placeHolderTextColor,
                        fontSize = 14.sp
                    )
                }
                val bringIntoViewRequester = remember { BringIntoViewRequester() }
                val coroutineScope = rememberCoroutineScope()
                BasicTextField(
                    modifier = Modifier
                        .focusRequester(focusRequester)
                        .fillMaxWidth()
                        .bringIntoViewRequester(bringIntoViewRequester)
                        .onFocusEvent {
                            if (it.isFocused) {
                                coroutineScope.launch {
                                    delay(200)
                                    bringIntoViewRequester.bringIntoView()
                                }
                            }
                        },
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = singleLine,
                    textStyle = textStyle.copy(color = textColor),
                    cursorBrush = SolidColor(cursorColor),
                    maxLines = maxLines,
                    enabled = enabled,
                    readOnly = readOnly,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                )
            }
            if (trailingIcon != null) {
                trailingIcon()
            }
        }
    }

    if (requestFocus) {
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}

@Composable
fun SearchBar(
    placeholder: String,
    onClick: () -> Unit
) {
    RoundedTextField(
        modifier = Modifier
            .height(55.dp)
            .clickable(
                onClick = onClick
            ),
        value = "",
        enabled = false,
        onValueChange = {  },
        placeHolder = placeholder,
        leadingIcon = {
            Image(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuItemButton(
    modifier: Modifier,
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(80.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = R.drawable.pokeball_s,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .offset(x = 20.dp, y = 0.dp)
                    .size(width = 96.dp, height = 96.dp),
                colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.15f))
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp),
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonTypeLabel(
    type: String
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0x38FFFFFF))
    ) {
        Text(
            text = type,
            modifier = Modifier
                .padding(vertical = 3.dp, horizontal = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}