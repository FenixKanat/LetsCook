package com.example.lab1p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab1p2.ui.theme.Lab1P2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1P2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun NextButton(text: String, onClick:() -> Unit, modifier: Modifier = Modifier){

}

@Composable
fun firstRecipe(text: String, onClick:() -> Unit, modifier: Modifier = Modifier){

}

fun secondRecipe(text: String, onClick:() -> Unit, modifier: Modifier = Modifier){

}

fun thirdRecipe(text: String, onClick:() -> Unit, modifier: Modifier = Modifier){

}

fun fourthRecipe(text: String, onClick:() -> Unit, modifier: Modifier = Modifier){

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab1P2Theme {
        Greeting("Android")
    }
}