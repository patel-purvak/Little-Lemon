package com.purvak.littlelemon

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.purvak.littlelemon.ui.theme.LittleLemonTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var username by remember {
            mutableStateOf(TextFieldValue(""))
        }
    var password by remember {
            mutableStateOf(TextFieldValue(""))
        }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.littlelemonlogo),
            contentDescription = "Logo Image"
        )
        TextField(value = username, onValueChange = { username = it }, label = { Text(text = "Username") })
        TextField(value = password, onValueChange = { password = it }, label = { Text(text = "Password") })
        Button(onClick = {
            // Handle login button click
            if (username.text == "admin" && password.text == "password") {
                // Login successful
                // Navigate to the main activity
                Toast.makeText(context,
                    "Welcome to Little Lemon!",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                // Login failed
                // Show error message
                Toast.makeText(context,
                    "Invalid credentials."
                            + "Please try again.",
                    Toast.LENGTH_LONG
                ).show()
            }
         }
            , colors = ButtonDefaults.buttonColors(
                Color(0xFF495E57))
            ) {
            Text(text = "Login",
                color = Color(0xFFEDEFEE)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LittleLemonTheme {
        LoginScreen()
    }
}