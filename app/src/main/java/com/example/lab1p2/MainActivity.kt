package com.example.lab1p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1p2.ui.theme.Lab1P2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1P2Theme {
                Surface(
                  
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    firstRecipe(onIconClick = { /*TODO*/ })
                }
            }
        }
    }
}

@Composable
fun firstRecipe(onIconClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(
        onClick = onIconClick,
        modifier = Modifier.padding(16.dp)
    ) {
        val iconResName = "recipeone"
        val iconResId = R.mipmap.recipeone
        if (iconResId != 0) {
            val iconPainter: Painter = painterResource(id = iconResId)
            Icon(
                painter = iconPainter,
                contentDescription = null
            )
        }
    }
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
