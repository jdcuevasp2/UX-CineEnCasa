package com.cineencasa.mobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.cineencasa.mobile.ui.theme.Outline
import com.cineencasa.mobile.ui.theme.PlaceholderTertiary
import com.cineencasa.mobile.ui.theme.Surface as SurfaceColor

/**
 * Matches Figma's "Text field" component: the label always sits floated on
 * the border (never inline as a large placeholder), with a separate
 * placeholder hint always visible inside — unlike stock M3 OutlinedTextField,
 * whose label only floats once focused or filled. We draw the label
 * ourselves and pass `label = null` to the field so its placeholder shows
 * regardless of focus.
 */
@Composable
fun CineEnCasaTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = true
) {
    Box(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder, color = PlaceholderTertiary) },
            singleLine = singleLine,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = SurfaceColor,
                unfocusedContainerColor = SurfaceColor,
                focusedBorderColor = Outline,
                unfocusedBorderColor = Outline,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = PlaceholderTertiary,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 12.dp, y = (-8).dp)
                .background(SurfaceColor)
                .padding(horizontal = 4.dp)
        )
    }
}
