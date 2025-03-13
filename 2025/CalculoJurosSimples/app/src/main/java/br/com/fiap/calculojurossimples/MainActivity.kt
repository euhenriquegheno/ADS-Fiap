package br.com.fiap.calculojurossimples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.fiap.calculojurossimples.juros.JurosScreen
import br.com.fiap.calculojurossimples.juros.JurosScreenViewModel
import br.com.fiap.calculojurossimples.ui.theme.CalculoJurosSimplesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculoJurosSimplesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JurosScreen(JurosScreenViewModel());
                }
            }
        }
    }
}