package com.infinitelearning.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun aboutme(
    navController: NavController

    ) {
    Scaffold(topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "About Developer",
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
                        painter = painterResource(id = R.drawable.mypp),
                        contentDescription = "Gerry Bagus Sadewo",
                        Modifier.size(200.dp)
                    )
                }
                Text(
                    text = "Gerry Bagus Sadewo",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                        .fillMaxWidth(),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Email : bagussadewogerry@gmail.com",
                    fontSize = 18.sp
                )
                Text(
                    text = "Universitas : Budi Luhur",
                    fontSize = 18.sp
                )
                Text(
                    text = "Jurusan : Sistem Informasi",
                    fontSize = 18.sp
                )
            }
        },

    )
}

@Preview(showSystemUi = true)
@Composable
private fun InfiniteAppScreenPreview() {
    val navController = rememberNavController() // Buat NavController
    App_tugas_infinitelearning_gerryTheme {
        aboutme(navController) // Pass NavController sebagai parameter
    }
}