package com.purvak.littlelemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.purvak.littlelemon.ui.theme.LittleLemonTheme

class CommonComposeComponentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ClickableModifier(){
    val counter = remember { mutableStateOf(0) }

    Text(text = "Clicks: " + counter.value.toString(),
        modifier = Modifier.clickable { counter.value += 1 })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CombineClickableModifier(){
    val normalClicks = remember { mutableStateOf(0) }
    val longClicks = remember { mutableStateOf(0) }

// content that you want to make clickable
    Text(text = "Normal: " + normalClicks.value.toString() + " Long: " + longClicks.value.toString(),
        modifier = Modifier.combinedClickable ( onClick = { normalClicks.value += 1 }, onLongClick = { longClicks.value += 1 } ))
}

@Composable
fun DraggableModifier(){
    val state = rememberDraggableState{ Log.d("Box", "Drag Amount: $it") }

    Box(modifier = Modifier.draggable(
        state = state,
        orientation = Orientation.Vertical,
        onDragStarted = { Log.d("Box", "Starting Drag") },
        onDragStopped = { Log.d("Box", "Finishing Drag") }
    ))
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LittleLemonTheme {
        Column {
            Greeting2("Android")
            ClickableModifier()
            CombineClickableModifier()
        }
    }
}