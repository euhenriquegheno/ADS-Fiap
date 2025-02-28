package br.com.fiap.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(color = Color(0xffaaaaaa))
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
            ) {
                Text(
                text = "FIAP",
                fontSize = 32.sp
            )

            Button(onClick = {}) {
                Text(
                  text = "Clique aqui",
                  fontSize = 38.sp
                )
            }
        }
    }

    Column() {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("O que você está procurando?") },
            trailingIcon = {
                Icon(
                    painter = painterResource(),
                    contentDescription = ""
                )
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen();
}