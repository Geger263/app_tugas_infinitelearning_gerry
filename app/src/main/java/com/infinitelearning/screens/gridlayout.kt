package com.infinitelearning.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.infinitelearning.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun gridlayout(
    imageId: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
){
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Lihat Lebih",
                    modifier = Modifier
                        .padding(start = 90.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
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

            LazyVerticalGrid(
                modifier = Modifier
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                columns = GridCells.Fixed(2) ) {
                val itemCount = imageId.size
                items(itemCount) {
                    griditem(
                        painter = imageId,
                        titel = names,
                        ingredients = ingredients,
                        itemIndex = it,
                        navController = navController
                    )
                }
            }

        }
    )
}

@Composable
fun griditem(
    painter: Array<Int>,
    titel: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int,
    navController: NavController,
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "DetailScreen/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ){
        Column(
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = titel[itemIndex],
                Modifier.size(140.dp)
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = titel[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp)
                Text(
                    text = ingredients[itemIndex!!],
                    fontSize = 18.sp)
            }
        }
    }
}
@Composable
@Preview
fun GridLayoutPreview() {
    val imageIds = arrayOf(R.drawable.bakso, R.drawable.martabak, R.drawable.nasikuning)
    val names = arrayOf("Name 1", "Name 2", "Name 3")
    val ingredients = arrayOf("Komposisi 1", "Komposisis 2", "Komposisi 3")
    val navController = rememberNavController()


    gridlayout(
        imageId = imageIds,
        names = names,
        ingredients = ingredients,
        navController = navController
    )
}