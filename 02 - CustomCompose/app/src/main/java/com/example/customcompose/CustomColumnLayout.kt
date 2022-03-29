package com.example.customcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.customcompose.ui.theme.CustomComposeTheme

@Composable
fun CustomColumnLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, contraints ->

        val placeable = measurables.map { measurable ->
            measurable.measure(contraints)
        }

        var yPosition = 0

        layout(contraints.maxWidth, contraints.maxHeight) {
            placeable.forEach { placeable ->
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height
            }
        }
    }
}

@Preview
@Composable
fun CustomMyColumn() {
    CustomComposeTheme {
        CustomColumnLayout(modifier = Modifier.padding(8.dp)) {
            Text("Hi There")
            Text("This is Android")
            Text("And I'm Toufeeq")
        }
    }
}

