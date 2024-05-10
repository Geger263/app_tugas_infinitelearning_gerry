package com.infinitelearning.screens

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.infinitelearning.R
import com.infinitelearning.ui.theme.App_tugas_infinitelearning_gerryTheme
import kotlinx.coroutines.flow.callbackFlow



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    photos: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int?,
    navController: NavController

) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detail Makanan",
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .padding(start = 55.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                            .fillMaxWidth(),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp()}) { // Tombol back
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(25.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = photos[itemIndex!!]),
                        contentDescription = names[itemIndex],
                        Modifier.size(300.dp)
                    )
                }
                Text(
                    text = names[itemIndex!!],
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = ingredients[itemIndex!!],
                    fontSize = 18.sp
                )
                Button(onClick = { navController.navigate("gridlayout") }) {
                    Text(text = "Lihat Semua")
                    
                }
            }
        },

        bottomBar = {
            Button(
                onClick = {navController.navigate("aboutme")

                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "ABOUT ME",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
            }
        }

    )
}

@Preview(showSystemUi = true)
@Composable
private fun InfiniteAppScreenPreview() {
    val navController = rememberNavController() // Inisialisasi NavController
    val photos = arrayOf(R.drawable.bakso) // Menambahkan gambar placeholder untuk preview
    val names = arrayOf("Nama Makanan")
    val ingredients = arrayOf("Bahan Makanan")

    App_tugas_infinitelearning_gerryTheme {
        DetailScreen(
            photos = photos,
            names = names,
            ingredients = ingredients,
            itemIndex = 0,
            navController = navController
        )
    }
}


