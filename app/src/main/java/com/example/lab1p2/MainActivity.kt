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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1p2.ui.theme.Lab1P2Theme
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf

/*
TODO:
1.
/ When clicked on one button the content of that button should be visible
Then when clicked on the other button the content of the first button will be hidden
and the content of the second button will be shown.

2.Resize the images, make them bigger. and maybe add two more recipes.

3. See if you can make the UI scrollable when content is shown.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1P2Theme {
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.TopStart

                    ) {
                        val (isMantiVisible, setMantiVisible) = remember { mutableStateOf(false) }
                        val (isCigköfteVisible, setCigköfteVisible) = remember {
                            mutableStateOf(
                                false
                            )
                        }


                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        )
                        {
                            if (isMantiVisible) {
                                Header("Manti")
                                mantiIngredients()
                                mantiHowto()
                            }
                        }
                        firstRecipe(onClick = { setMantiVisible(!isMantiVisible) })
                        setCigköfteVisible(false)




                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.TopEnd
                        ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            )
                            {
                                if (isCigköfteVisible) {
                                    Header("Cigköfte")
                                    cigkofteIngredients()
                                    cigkofteHowto()

                                }
                            }
                            secondRecipe(onClick = {
                                setCigköfteVisible(!isCigköfteVisible)
                                setMantiVisible(false)
                            })

                        }
                    }
                }
            }
        }
        }
    }



@Composable
fun firstRecipe(onClick: () -> Unit, modifier: Modifier = Modifier) {
    val magentaColor = Color(0xFF00FF)

Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(magentaColor),
    modifier = Modifier
        .width(150.dp)
        .height(150.dp)
        .padding(16.dp),

            contentPadding= PaddingValues(8.dp)


){
   Image(
       painter = painterResource(id = R.drawable.recipeone),
       contentDescription = null,
       modifier = Modifier
           .fillMaxSize()
   )
}
}


@Composable
fun secondRecipe(onClick: () -> Unit, modifier: Modifier = Modifier) {
    val magentaColor = Color(0xFF00FF)

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(magentaColor),
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .padding(16.dp),

        contentPadding= PaddingValues(8.dp)


    ){
        Image(
            painter = painterResource(id = R.drawable.recipetwo),
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
        text = " Make dough: Combine flour and salt in a large bowl. Add eggs and water, mixing well with your hands. Add more water, if needed, to form a soft dough. Cover and set aside for at least 30 minutes.\n" +
                "\n" +
                "Make filling: Shred onions and place them in a colander or sieve set over a bowl; drain and discard juice. Combine drained onion, ground beef, salt, and pepper in a medium bowl; mix well with a spoon until mashed. Set filling aside.\n" +
                "\n" +
                "Lightly flour a work surface and a large plate.\n" +
                "\n" +
                "Divide dough in half. Working with one piece at a time, roll dough on the floured surface into a rectangle as thin as possible. Cut into 2-inch squares using a knife or pastry wheel.\n" +
                "\n" +
                "Place about 2 teaspoons filling in the center of each square. Gather the edges of dough and pinch them together at the top to form a bundle. Transfer manti to the prepared plate; sprinkle more flour on top to prevent sticking.\n" +
                "\n" +
                "Make oil: Heat oil and red pepper flakes in a small skillet over low heat just until pepper flakes begin to color oil. Remove from heat and keep warm.\n" +
                "\n" +
                "Make sauce: Stir together yogurt and garlic in a small bowl; set aside.\n" +
                "\n" +
                "Bring a large pot of salted water to a boil over medium-high heat. Cook manti in boiling water until filling is no longer pink and dough is tender, 20 to 25 minutes. Drain well.\n" +
                "\n" +
                "Divide manti onto 4 plates. Spoon yogurt sauce over manti and drizzle with pepper oil.",
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
        text = "Dough:\n" +
                "\n" +
                "2 cups all-purpose flour, plus more for dusting\n" +
                "\n" +
                "½ teaspoon salt\n" +
                "\n" +
                "2 large eggs\n" +
                "\n" +
                "½ teaspoon water, or as needed\n" +
                "\n" +
                "Filling:\n" +
                "\n" +
                "2 onions, peeled\n" +
                "\n" +
                "½ pound ground beef\n" +
                "\n" +
                "salt and pepper to taste\n" +
                "\n" +
                "Red Pepper Oil:\n" +
                "\n" +
                "3 tablespoons vegetable oil\n" +
                "\n" +
                "1 tablespoon red pepper flakes\n" +
                "\n" +
                "Yogurt Sauce:\n" +
                "\n" +
                "1 (8 ounce) container plain yogurt\n" +
                "\n" +
                "1 tablespoon minced garlic",
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
        text = "5 large ripe tomatoes\n" +
                "2 cups fine bulgur\n" +
                "2 medium onions\n" +
                "5 cloves garlic\n" +
                "2 slices stale bread\n" +
                "1 cup walnut halves\n" +
                "1/2 cup olive oil\n" +
                "1/2 cup pomegranate concentrate\n" +
                "1/4 cup Turkish isot biber\n" +
                "1 tablespoon tomato paste\n" +
                "1 tablespoon red pepper paste\n" +
                "1 teaspoon ground cumin\n" +
                "1 teaspoon salt\n" +
                "Finely chopped fresh parsley, for garnish\n" +
                "Finely chopped green onion, for garnish\n" +
                "Romain lettuce leaves, for serving\n" +
                "Lemon wedges, for serving",

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

    Text(text = "Gather the ingredients. Wash the tomatoes and peel them using a small, sharp knife.\n"+" Place the peeled tomatoes in a food processor and puree them, or finely grate them using a hand grater.\n" +
            "Rinse the bulgur under cold water in a wire strainer for a few minutes. Drain it and put it in a large mixing bowl along with the tomato puree. Mix together well, cover the bowl, and set it aside for about 1 hour until the bulgur is softened.\n"
            +"Peel and coarsely chop the onions and garlic and put them in the food processor along with the stale bread and the walnut halves. Pulverize on high speed until you have a fine powder.\n" +
            "\n"+"Add this mixture to the tomato and bulgur along with the pomegranate concentrate, isot biber, tomato paste, red pepper paste, cumin, and salt. Wearing rubber gloves, knead the mixture until all the ingredients are well combined. \n"
            +"Divide the mixture into portions small enough to fit inside the food processor. Process each portion on medium speed until smooth. Combine all the processed portions together in a large bowl and continue to knead until it has a smooth consistency.\n"+"Place in a bowl and cover with an airtight seal; set aside for at least 5 hours or overnight.\n" +
            "\n" + "The next morning, break off bite-sized pieces of the mixture and shape them into fingerprint shapes. Arrange them on a serving plate with parsley, green onion, leaves of Romaine lettuce, and slivers of fresh lemon for squeezing.\n" +
            "\n",

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
