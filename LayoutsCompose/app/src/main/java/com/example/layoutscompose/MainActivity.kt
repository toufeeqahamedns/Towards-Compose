package com.example.layoutscompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutscompose.ui.theme.ComposeLayoutsTheme
import com.google.accompanist.coil.rememberCoilPainter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotographerCard()
        }
    }
}

@Composable
fun PhotographerCard() {

    val listSize = 100
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        // topBar is slot in Scaffold
        topBar = {
            TopAppBar(
                // these are slots in TopAppBar
                title = {
                    Text(text = "Compose Layouts")
                },
                actions = {
                    IconButton(onClick = {
                        // click handling goes here
                    }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column {
            Row {
                Button(onClick = {
                    coroutineScope.launch {
                        // 0 is the first item index
                        scrollState.animateScrollToItem(0)
                    }
                }) {
                    Text("Scroll to the top")
                }

                Button(onClick = {
                    coroutineScope.launch {
                        // listSize - 1 is the last index of the list
                        scrollState.animateScrollToItem(listSize - 1)
                    }
                }) {
                    Text("Scroll to the end")
                }
            }
            LazyColumn(state = scrollState) {
                items(100) {
                    BodyContent(Modifier.padding(innerPadding), it)
                }
            }
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            // The order in which modifiers appended will make the UI behave differently
            .padding(6.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable(onClick = {})
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here
            Image(
                painter = rememberCoilPainter(request = "https://developer.android.com/images/brand/Android_Robot.png"),
                contentDescription = "Android Logo",
                modifier = Modifier.size(50.dp)
            )
        }
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    ComposeLayoutsTheme {
        PhotographerCard()
    }
}