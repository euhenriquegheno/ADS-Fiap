package br.com.fiap.saudemental.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.saudemental.data.RepositorioDados
import br.com.fiap.saudemental.model.RegistroHumor
import java.text.SimpleDateFormat
import java.util.*

/**
 * Tela de visualização de dados consolidados.
 * Permite ao usuário visualizar gráficos e estatísticas sobre seu bem-estar emocional.
 */
@Composable
fun TelaVisualizacao() {
    val historicoHumor = remember { RepositorioDados.obterHistoricoHumor() }
    var periodoSelecionado by remember { mutableStateOf("7 dias") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Visualização de Dados",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = "Acompanhe a evolução do seu bem-estar emocional ao longo do tempo.",
            style = MaterialTheme.typography.bodyLarge
        )
        
        // Seletor de período
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("7 dias", "30 dias", "3 meses").forEach { periodo ->
                FilterChip(
                    selected = periodoSelecionado == periodo,
                    onClick = { periodoSelecionado = periodo },
                    label = { Text(periodo) }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Resumo do humor
        ResumoHumor(historicoHumor)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Gráfico de humor (simulado com barras coloridas)
        GraficoHumor(historicoHumor)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Tendência de estresse
        TendenciaEstresse(historicoHumor)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Recomendações baseadas nos dados
        RecomendacoesBaseadasEmDados(historicoHumor)
    }
}

/**
 * Componente que exibe um resumo do humor do usuário.
 */
@Composable
fun ResumoHumor(historicoHumor: List<RegistroHumor>) {
    val humorFrequente = historicoHumor
        .groupBy { it.humor }
        .maxByOrNull { it.value.size }
        ?.key
    
    val estresseMedio = historicoHumor
        .map { it.nivelEstresse }
        .average()
        .toInt()
    
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Resumo do Período",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            
            Divider()
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Humor mais frequente:",
                    style = MaterialTheme.typography.bodyLarge
                )
                
                if (humorFrequente != null) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = humorFrequente.emoji,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                        
                        Text(
                            text = humorFrequente.descricao,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Nível médio de estresse:",
                    style = MaterialTheme.typography.bodyLarge
                )
                
                Text(
                    text = "$estresseMedio/10",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Registros no período:",
                    style = MaterialTheme.typography.bodyLarge
                )
                
                Text(
                    text = "${historicoHumor.size}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

/**
 * Componente que exibe um gráfico de humor simulado.
 */
@Composable
fun GraficoHumor(historicoHumor: List<RegistroHumor>) {
    val dateFormat = SimpleDateFormat("dd/MM", Locale("pt", "BR"))
    
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Evolução do Humor",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Simulação de gráfico com barras coloridas
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                historicoHumor.takeLast(7).forEach { registro ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        // Barra representando o nível de estresse
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height((registro.nivelEstresse * 15).dp)
                                .background(
                                    color = when {
                                        registro.nivelEstresse >= 7 -> Color(0xFFE57373) // Vermelho claro
                                        registro.nivelEstresse >= 4 -> Color(0xFFFFD54F) // Amarelo
                                        else -> Color(0xFF81C784) // Verde claro
                                    }
                                )
                        )
                        
                        Spacer(modifier = Modifier.height(4.dp))
                        
                        // Emoji do humor
                        Text(
                            text = registro.humor.emoji,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        
                        // Data
                        Text(
                            text = dateFormat.format(Date(registro.dataHora)),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

/**
 * Componente que exibe a tendência de estresse.
 */
@Composable
fun TendenciaEstresse(historicoHumor: List<RegistroHumor>) {
    val niveis = historicoHumor.map { it.nivelEstresse }
    val tendencia = if (niveis.size >= 2) {
        val primeiro = niveis.take(niveis.size / 2).average()
        val segundo = niveis.takeLast(niveis.size / 2).average()
        segundo - primeiro
    } else {
        0.0
    }
    
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Tendência de Estresse",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            
            Divider()
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = when {
                        tendencia > 0.5 -> "Em alta ↗️"
                        tendencia < -0.5 -> "Em queda ↘️"
                        else -> "Estável ↔️"
                    },
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = when {
                        tendencia > 0.5 -> Color(0xFFE57373) // Vermelho claro
                        tendencia < -0.5 -> Color(0xFF81C784) // Verde claro
                        else -> Color(0xFFFFD54F) // Amarelo
                    }
                )
                
                Text(
                    text = when {
                        tendencia > 0.5 -> "Aumento de estresse"
                        tendencia < -0.5 -> "Redução de estresse"
                        else -> "Nível de estresse estável"
                    },
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            
            Text(
                text = when {
                    tendencia > 0.5 -> "Considere implementar técnicas de redução de estresse."
                    tendencia < -0.5 -> "Continue com as práticas atuais, estão funcionando bem."
                    else -> "Mantenha o equilíbrio atual e observe mudanças."
                },
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * Componente que exibe recomendações baseadas nos dados.
 */
@Composable
fun RecomendacoesBaseadasEmDados(historicoHumor: List<RegistroHumor>) {
    val dicas = RepositorioDados.obterDicasPersonalizadas(historicoHumor)
    
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Recomendações Personalizadas",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            
            Divider()
            
            dicas.forEach { dica ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "•",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(end = 8.dp, top = 2.dp)
                    )
                    
                    Text(
                        text = dica,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}
