package com.infinitelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.infinitelearning.screens.DetailScreen
import com.infinitelearning.screens.MainScreen
import com.infinitelearning.screens.aboutme
import com.infinitelearning.screens.gridlayout
import com.infinitelearning.ui.theme.App_tugas_infinitelearning_gerryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_tugas_infinitelearning_gerryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageId = arrayOf(
                        R.drawable.bakso,
                        R.drawable.pempek,
                        R.drawable.sate,
                        R.drawable.martabak,
                        R.drawable.nasikuning,
                        R.drawable.cireng,
                        R.drawable.migoreng,
                        R.drawable.tempe,
                        R.drawable.mendoan,
                        R.drawable.kolak
                    )

                    val names = arrayOf(
                        "Bakso",
                        "Pempek",
                        "Sate",
                        "Martabak",
                        "Nasi Kuning",
                        "Cireng",
                        "Mie Goreng",
                        "Tempe Goreng",
                        "Mendoan",
                        "Kolak"
                    )

                    val ingredients = arrayOf(
                        "terbuat dari daging sapi dan campuran tepung tapioka",
                        "terbuat dari daging ikan tenggiri dan tepung tapioka",
                        "terbuat dari daging ayam yang dibakar dan saus kacang",
                        "terbuat dari adonan tepung terigu dan telur yang di taburi mesis",
                        "terbuat dari nasi yang dimasak dengan bumbu dan kunyit untuk pewarnanya",
                        "terbuat dari tepung kanji/tapioka",
                        "terbuat dari mie telur yang dimasak tanpa kuah",
                        "terbuat dari kacang kedelai yang di fermentasi",
                        "terbuat dari tempe yang digoreng dengan tepung",
                        "terbuat dari pisang dan kuah santan yang diberi gula"

                    )

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable(route = "MainScreen")
                        {
                            MainScreen(imageId, names, ingredients, navController)
                        }
                        composable(route = "DetailScreen/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )

                        )


                        { backStackEntry ->
                            DetailScreen(
                                photos = imageId,
                                names = names,
                                ingredients = ingredients,
                                itemIndex = backStackEntry.arguments?.getInt("index") ?: 0,
                                navController = navController


                            )

                        }
                        composable(route = "gridlayout") {
                            gridlayout(
                                imageId = imageId,
                                names = names,
                                ingredients = ingredients,
                                navController = navController
                            )
                        }
                        composable(route = "aboutme") {
                            aboutme(navController)
                        }

                    }
                }
            }
        }
    }}

