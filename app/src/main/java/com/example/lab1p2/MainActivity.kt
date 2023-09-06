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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1P2Theme {
                val (isMantiVisible, setMantiVisible) = remember { mutableStateOf(false) }
                val (isCigköfteVisible, setCigköfteVisible) = remember { mutableStateOf(false) }

                Column(
                    modifier = if (!isMantiVisible && !isCigköfteVisible) {
                        Modifier
                            .fillMaxSize()
                            .background(Color.Yellow)
                            .verticalScroll(rememberScrollState())
                    } else {
                        Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                )  {

                    if (!isMantiVisible && !isCigköfteVisible) {

                        Header("Choose a dish")

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
                        Box(modifier = Modifier.background(Color.Magenta)) {

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Header("Cig Köfte")
                                cigkofteIngredients()
                                cigkofteHowto()

                                backButton {
                                    setCigköfteVisible(false)
                                }
                            }
                        }
                    }

                    if (isMantiVisible) {
                        Box(modifier = Modifier.background(Color.Magenta)) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ) {
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
    val magentaColor = Color(0xFF4B0082)

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
    val darkPurple = Color(0xFF3D0E5F)

    Text(
        text = text,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge,
        color = darkPurple
    )
}

@Composable
fun mantiHowto(modifier: Modifier = Modifier){

    val customPurple = Color(0xFF4B0082)

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
        color = customPurple,
        fontSize = 20.sp
    )
}

@Composable
fun mantiIngredients(modifier :Modifier = Modifier){

    val customPurple = Color(0xFF4B0082)

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
        color = customPurple,
        fontSize = 20.sp )

}

@Composable
fun cigkofteIngredients(modifier : Modifier = Modifier ){
    val customPurple = Color(0xFF4B0082)

    Text(
        text = "Ingredients:\n" +
                "500g ground beef (lean)\n" +
                "2 cups fine bulgur\n" +
                "1 onion, finely grated\n" +
                "2 tbsp tomato paste\n" +
                "1 tbsp chili pepper flakes\n" +
                "Salt to taste\n" +
                "Juice of 1 lemon\n" +
                "A handful of parsley, finely chopped",

                modifier = modifier
                    .background(Color.Transparent)
                    .padding(16.dp)
                    .fillMaxWidth(),
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        color = customPurple,
        fontSize = 20.sp )

}

@Composable
fun cigkofteHowto( modifier: Modifier = Modifier){

    val customPurple = Color(0xFF4B0082)

    Text(text = "Steps:\n" +
            "Mix Ingredients: In a large bowl, mix bulgur, ground beef, grated onion, and tomato paste.\n" +
            "\n" +
            "Season: Add chili pepper flakes and salt.\n" +
            "\n" +
            "Knead: Knead the mixture well until it starts to hold together.\n" +
            "\n" +
            "Lemon and Parsley: Add lemon juice and chopped parsley to the mixture. Knead for a couple more minutes.\n" +
            "\n" +
            "Shape: Take small portions of the mixture and shape them into small, oblong balls.\n" +
            "\n" +
            "Serve: Serve immediately with lettuce leaves, or store in the refrigerator for later use.",

        modifier = modifier
            .background(Color.Transparent)
            .padding(16.dp)
            .fillMaxWidth(),
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        color = customPurple,
        fontSize = 20.sp )
}