package br.com.fiap.saudemental.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.saudemental.database.repository.RepositorioDadosRoom
import br.com.fiap.saudemental.model.TipoHumor
import java.text.SimpleDateFormat
import java.util.*

/**
 * Tela de visualização de dados históricos de humor e avaliações.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaVisualizacao(
    repositorio: RepositorioDadosRoom,
    onVoltar: () -> Unit
) {
    val historicoHumor = remember { repositorio.obterHistoricoHumor() }
    val avaliacoes = remember { repositorio.listarAvaliacoes() }

    var tipoVisualizacao by remember { mutableStateOf("humor") }
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Visualização de Dados")
                },
                navigationIcon = {
                    IconButton(onClick = onVoltar) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Seleção de tipo de visualização
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { tipoVisualizacao = "humor" },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (tipoVisualizacao == "humor") 
                            MaterialTheme.colorScheme.primary 
                        else 
                            MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Text("Histórico de Humor")
                }
                
                Button(
                    onClick = { tipoVisualizacao = "avaliacao" },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (tipoVisualizacao == "avaliacao") 
                            MaterialTheme.colorScheme.primary 
                        else 
                            MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Text("Avaliações de Risco")
                }
            }
            
            // Conteúdo baseado na seleção
            when (tipoVisualizacao) {
                "humor" -> HistoricoHumorContent(historicoHumor)
                "avaliacao" -> AvaliacoesContent(avaliacoes)
            }
        }
    }
}

@Composable
fun HistoricoHumorContent(historicoHumor: List<br.com.fiap.saudemental.model.RegistroHumor>) {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    
    if (historicoHumor.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Nenhum registro de humor encontrado",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(historicoHumor.sortedByDescending { it.dataHora }) { registro ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = dateFormat.format(Date(registro.dataHora)),
                                style = MaterialTheme.typography.titleMedium
                            )
                            
                            Text(
                                text = "${registro.humor.emoji} ${registro.humor.descricao}",
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                        
                        LinearProgressIndicator(
                            progress = registro.nivelEstresse / 10f,
                            modifier = Modifier.fillMaxWidth(),
                            color = when {
                                registro.nivelEstresse <= 3 -> MaterialTheme.colorScheme.primary
                                registro.nivelEstresse <= 6 -> MaterialTheme.colorScheme.tertiary
                                else -> MaterialTheme.colorScheme.error
                            }
                        )
                        
                        Text(
                            text = "Nível de Estresse: ${registro.nivelEstresse}/10",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        
                        if (registro.observacoes.isNotEmpty()) {
                            Text(
                                text = "Observações: ${registro.observacoes}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AvaliacoesContent(avaliacoes: List<br.com.fiap.saudemental.model.Avaliacao>) {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    
    if (avaliacoes.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Nenhuma avaliação de risco encontrada",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(avaliacoes.sortedByDescending { it.dataHora }) { avaliacao ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = when (avaliacao.nivelRisco) {
                            br.com.fiap.saudemental.model.NivelRisco.NEUTRO -> MaterialTheme.colorScheme.primaryContainer
                            br.com.fiap.saudemental.model.NivelRisco.LEVE -> MaterialTheme.colorScheme.secondaryContainer
                            br.com.fiap.saudemental.model.NivelRisco.MODERADO -> MaterialTheme.colorScheme.tertiaryContainer
                            br.com.fiap.saudemental.model.NivelRisco.AGUDO -> MaterialTheme.colorScheme.errorContainer
                        }
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = dateFormat.format(Date(avaliacao.dataHora)),
                                style = MaterialTheme.typography.titleMedium
                            )

                            AssistChip(
                                onClick = { },
                                colors = AssistChipDefaults.assistChipColors(
                                    containerColor = MaterialTheme.colorScheme.surface
                                ),
                                label = {
                                    Text(
                                        text = avaliacao.nivelRisco.descricao,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            )
                        }
                        
                        Text(
                            text = "Faixa: ${avaliacao.nivelRisco.porcentagem}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        
                        Divider(modifier = Modifier.padding(vertical = 8.dp))
                        
                        Text(
                            text = "Recomendações:",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        
                        avaliacao.recomendacoes.forEach { recomendacao ->
                            Text(
                                text = "• $recomendacao",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}
