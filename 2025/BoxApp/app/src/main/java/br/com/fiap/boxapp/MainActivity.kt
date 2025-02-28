package br.com.fiap.boxapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.boxapp.ui.theme.BoxAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxAppTheme {
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    BoxScreen()
                }
            }
        }
    }
}

@Composable
fun BoxScreen(){
    Box (
        contentAlignment = Alignment.TopEnd
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text(text = "Clique aqui")
        }
        Text(
            text = "FIAP",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 150.dp, y = 120.dp)
        ) {
            Text(text = "Outro botão")
        }
    }
}