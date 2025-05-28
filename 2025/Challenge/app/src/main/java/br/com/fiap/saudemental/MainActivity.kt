package br.com.fiap.saudemental

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.saudemental.database.repository.RepositorioDadosRoom
import br.com.fiap.saudemental.ui.screens.*
import br.com.fiap.saudemental.ui.theme.SaudeMentalTheme
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SaudeMentalTheme {
                // Obtém a altura da barra de status
                val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()

                // Aplica o padding em toda a aplicação
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = statusBarHeight), // Adiciona padding no topo
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Seu AppNavigation ou conteúdo principal aqui
                    AppNavigation(RepositorioDadosRoom(LocalContext.current))
                }
            }
        }
    }
}


@Composable
fun AppNavigation(repositorio: RepositorioDadosRoom) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "bem_estar") {
        composable("bem_estar") {
            TelaBemEstar(
                repositorio = repositorio,
                onNavigateToAvaliacao = { navController.navigate("avaliacao") },
                onNavigateToRecursos = { navController.navigate("recursos") },
                onNavigateToVisualizacao = { navController.navigate("visualizacao") },
                onNavigateToLembretes = { navController.navigate("lembretes") }
            )
        }
        
        composable("avaliacao") {
            TelaAvaliacao(
                repositorio = repositorio,
                onAvaliacaoConcluida = { navController.navigate("bem_estar") }
            )
        }
        
        composable("recursos") {
            TelaRecursos(
                repositorio = repositorio,
                onVoltar = { navController.navigateUp() }
            )
        }
        
        composable("visualizacao") {
            TelaVisualizacao(
                repositorio = repositorio,
                onVoltar = { navController.navigateUp() }
            )
        }
        
        composable("lembretes") {
            TelaLembretes(
                repositorio = repositorio,
                onVoltar = { navController.navigateUp() }
            )
        }
    }
}
