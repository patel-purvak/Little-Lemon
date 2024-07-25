package com.purvak.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemon.LowerPanel
import com.example.littlelemon.LowerPanelPreview
import com.example.littlelemon.UpperPanel
import com.example.littlelemon.UpperPanelPreview
import com.purvak.littlelemon.ui.theme.LittleLemonTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    UpperPanel()
                    LowerPanel()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LittleLemonTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            UpperPanel()
            LowerPanel()
        }
    }
}