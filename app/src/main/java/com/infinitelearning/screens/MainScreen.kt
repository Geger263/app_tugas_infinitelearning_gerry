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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.infinitelearning.R



@Composable
fun MainScreen(
    imageId: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {

                LazyRow {
                    val itemCount = imageId.size
                    items(itemCount) {
                        HorizontalListItem(
                            modifier,
                            painter = imageId,
                            titel = names,
                            ingredients = ingredients,
                            itemIndex = it,
                            navController = navController
                        )
                    }
                }
                LazyColumn(contentPadding = PaddingValues(16.dp)) {
                    val itemCount = imageId.size
                    items(itemCount) {
                        ColumnItem(
                            modifier,
                            painter = imageId,
                            titel = names,
                            ingredients = ingredients,
                            itemIndex = it,
                            navController = navController
                        )
                    }
                }
            }
        }

//ini untuk row
@Composable
fun HorizontalListItem(
    modifier: Modifier,
    painter: Array<Int>,
    titel: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int,
    navController: NavController,

    )
{
    Card(
        modifier = modifier
            .padding(5.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "DetailScreen/$itemIndex")
            }
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = titel[itemIndex],
                Modifier.size(70.dp)
            )
            Column {
                Text(
                    text = titel[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

            }

        }
    }
}


@Composable
fun ColumnItem(
    modifier: Modifier,
    painter: Array<Int>,
    titel: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int,
    navController: NavController,
) {
    Card(
        modifier
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
        Row(modifier.fillMaxSize(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = titel[itemIndex],
                Modifier.size(140.dp)
            )
            Column(modifier.padding(12.dp)) {
                Text(text = titel[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp)
            }

        }
    }
}
@Preview
@Composable
fun MainScreenPreview() {
    val imageIds = arrayOf(R.drawable.bakso, R.drawable.martabak, R.drawable.nasikuning)
    val names = arrayOf("Name 1", "Name 2", "Name 3")
    val ingredients = arrayOf("Ingredient 1", "Ingredient 2", "Ingredient 3")
    val navController = rememberNavController()
    MainScreen(
        imageId = imageIds,
        names = names,
        ingredients = ingredients,
        navController = navController,
        modifier = Modifier.fillMaxSize()
    )
}
