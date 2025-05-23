package br.com.fiap.saudemental

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.saudemental.model.Recurso
import br.com.fiap.saudemental.ui.screens.TelaAvaliacao
import br.com.fiap.saudemental.ui.screens.TelaBemEstar
import br.com.fiap.saudemental.ui.screens.TelaDetalhesRecurso
import br.com.fiap.saudemental.ui.screens.TelaLembretes
import br.com.fiap.saudemental.ui.screens.TelaRecursos
import br.com.fiap.saudemental.ui.screens.TelaVisualizacao
import br.com.fiap.saudemental.ui.theme.SaudeMentalTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SaudeMentalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppPrincipal()
                }
            }
        }
    }
}

/**
 * Tela principal do aplicativo com navegação entre as funcionalidades.
 */
@Composable
fun AppPrincipal() {
    var telaAtual by remember { mutableStateOf(TelaApp.BEM_ESTAR) }
    var recursoSelecionado by remember { mutableStateOf<Recurso?>(null) }

    Scaffold(
        bottomBar = {
            BarraNavegacao(
                telaAtual = telaAtual,
                onTelaSelecionada = { telaAtual = it }
            )
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .windowInsetsPadding(WindowInsets.safeDrawing) // Respeita áreas seguras
        ) {
            when {
                recursoSelecionado != null -> {
                    TelaDetalhesRecurso(
                        recurso = recursoSelecionado!!,
                        onVoltar = { recursoSelecionado = null }
                    )
                }

                else -> {
                    when (telaAtual) {
                        TelaApp.BEM_ESTAR -> TelaBemEstar(
                            onRegistroSalvo = { /* Implementar lógica de salvamento */ }
                        )

                        TelaApp.AVALIACAO -> TelaAvaliacao(
                            onAvaliacaoConcluida = { /* Implementar lógica de conclusão */ }
                        )

                        TelaApp.RECURSOS -> TelaRecursos(
                            onRecursoSelecionado = { recursoSelecionado = it }
                        )

                        TelaApp.VISUALIZACAO -> TelaVisualizacao()
                        TelaApp.LEMBRETES -> TelaLembretes()
                    }
                }
            }
        }
    }
}

/**
 * Barra de navegação inferior do aplicativo.
 */
@Composable
fun BarraNavegacao(
    telaAtual: TelaApp,
    onTelaSelecionada: (TelaApp) -> Unit
) {
    NavigationBar {
        TelaApp.values().forEach { tela ->
            NavigationBarItem(
                icon = { Icon(tela.icone, contentDescription = tela.titulo) },
                label = { Text(tela.titulo) },
                selected = telaAtual == tela,
                onClick = { onTelaSelecionada(tela) }
            )
        }
    }
}

/**
 * Enum que representa as telas principais do aplicativo.
 */
enum class TelaApp(val titulo: String, val icone: ImageVector) {
    BEM_ESTAR("Bem-estar", Icons.Default.Favorite),
    AVALIACAO("Avaliação", Icons.Default.Check),
    RECURSOS("Recursos", Icons.Default.Info),
    VISUALIZACAO("Visualização", Icons.Default.Search),
    LEMBRETES("Lembretes", Icons.Default.Notifications)
}

@Preview(showBackground = true)
@Composable
fun AppPrincipalPreview() {
    SaudeMentalTheme {
        AppPrincipal()
    }
}
