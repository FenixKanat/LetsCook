package com.example.lab1p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1p2.ui.theme.Lab1P2Theme
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf

/*
TODO:
1.Add background pic

2.Resize the images, make them bigger. and maybe add two more recipes.

3. See if you can make the UI scrollable when content is shown.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1P2Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    var (isMantiVisible, setMantiVisible) = remember { mutableStateOf(false) }
                    var (isCigköfteVisible, setCigköfteVisible) = remember { mutableStateOf(false) }

                    if (!isMantiVisible && !isCigköfteVisible) {
                        cigkRecipe(onClick = {
                            setCigköfteVisible(true)
                            setMantiVisible(false)
                        })

                        mantiRecipe(onClick = {
                            setMantiVisible(true)
                            setCigköfteVisible(false)
                        })
                    }

                    if (isCigköfteVisible) {
                        Header("Cig Köfte")
                        cigkofteIngredients()
                        cigkofteHowto()

                        backButton {
                            setCigköfteVisible(false)
                        }

                    }

                    if (isMantiVisible) {
                        Header("Manti")
                        mantiIngredients()
                        mantiHowto()

                        backButton {
                            setMantiVisible(false)
                        }



                    }
                }
            }
        }
    }
}


@Composable
fun backButton(onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(16.dp)) {
        Text("Back")
    }
}

@Composable
fun cigkRecipe(onClick: () -> Unit, modifier: Modifier = Modifier) {
    val magentaColor = Color(0xFF00FF)

Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(magentaColor),
    modifier = Modifier
        .width(300.dp)
        .height(300.dp)
        .padding(16.dp),

            contentPadding= PaddingValues(8.dp)


){
   Image(
       painter = painterResource(id = R.drawable.cigk),
       contentDescription = null,
       modifier = Modifier
           .fillMaxSize()
   )
}
}


@Composable
fun mantiRecipe(onClick: () -> Unit, modifier: Modifier = Modifier) {
    val magentaColor = Color(0xFF00FF)

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(magentaColor),
        modifier = Modifier
            .width(300.dp)
            .height(300.dp)
            .padding(16.dp),

        contentPadding= PaddingValues(8.dp)


    ){
        Image(
            painter = painterResource(id = R.drawable.manti),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
@Composable
fun Header(text: String, modifier: Modifier = Modifier){

    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
fun mantiHowto(modifier: Modifier = Modifier){

    val customViolet = Color(0xFFE1A0F9)

    Text(
        text = " Prepare Dough: Mix flour and salt. Add egg and water. Knead into a dough. Let it rest for 30 minutes.\n" +
                "Prepare Filling: Mix ground beef, chopped onion, salt, and pepper.\n" +
                "Roll Dough: Roll the dough thin and cut into small squares.\n" +
                "Assemble Manti: Place a teaspoon of filling in the center of each square. Fold and pinch to close.\n" +
                "Cook: Boil the Manti in salted water until they float to the top, about 20 minutes.\n" +
                "Prepare Sauce: Mix yogurt and minced garlic.\n" +
                "Serve: Place cooked Manti on a plate, and spoon yogurt sauce over the top.",
        modifier = modifier
            .background(Color.Transparent)
            .padding(16.dp)
            .fillMaxWidth(),
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        color = customViolet,
        fontSize = 20.sp
    )
}
@Composable
fun mantiIngredients(modifier :Modifier = Modifier){

    val customViolet = Color(0xFFE1A0F9)

    Text(
        text = "Ingredients:\n" +
                "Dough:\n" +
                "2 cups all-purpose flour\n" +
                "1/2 teaspoon salt\n" +
                "1 egg\n" +
                "Water, as needed\n" +
                "Filling:\n" +
                "1/2 pound ground beef\n" +
                "1 small onion, finely chopped\n" +
                "Salt and pepper to taste\n" +
                "Sauce:\n" +
                "1 cup plain yogurt\n" +
                "1 clove garlic, minced\n",
        modifier = modifier
            .background(Color.Transparent)
            .padding(16.dp)
            .fillMaxWidth(),
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        color = customViolet,
        fontSize = 20.sp )

}
@Composable
fun cigkofteIngredients(modifier : Modifier = Modifier ){
    val customViolet = Color(0xFFE1A0F9)

    Text(
        text = "sikkafa",

                modifier = modifier
                    .background(Color.Transparent)
                    .padding(16.dp)
                    .fillMaxWidth(),
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        color = customViolet,
        fontSize = 20.sp )

}

@Composable
fun cigkofteHowto( modifier: Modifier = Modifier){

    val customViolet = Color(0xFFE1A0F9)

    Text(text = "sikkafa",

        modifier = modifier
            .background(Color.Transparent)
            .padding(16.dp)
            .fillMaxWidth(),
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        color = customViolet,
        fontSize = 20.sp )
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
