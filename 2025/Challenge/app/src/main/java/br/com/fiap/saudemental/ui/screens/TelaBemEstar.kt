package br.com.fiap.saudemental.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.saudemental.database.repository.RepositorioDadosRoom
import br.com.fiap.saudemental.model.TipoHumor
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 Tela de bem-estar que permite ao usuário registrar seu humor diário
 e acessar outras funcionalidades do aplicativo.
 */
@Composable
fun TelaBemEstar(
    repositorio: RepositorioDadosRoom,
    onNavigateToAvaliacao: () -> Unit,
    onNavigateToRecursos: () -> Unit,
    onNavigateToVisualizacao: () -> Unit,
    onNavigateToLembretes: () -> Unit
) {
    var showRegistroHumorDialog by remember { mutableStateOf(false) }
    val historicoHumor = remember { mutableStateOf(repositorio.obterHistoricoHumor()) }
    val dicasPersonalizadas = remember { repositorio.obterDicasPersonalizadas(historicoHumor.value) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Bem-estar Mental",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        // Cartão de registro de humor
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Como você está se sentindo hoje?",
                    style = MaterialTheme.typography.titleLarge
                )
                
                Button(
                    onClick = { showRegistroHumorDialog = true },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Registrar humor"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Registrar Humor")
                }
            }
        }
        
        // Cartões de navegação
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(120.dp),
                onClick = onNavigateToAvaliacao
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Avaliação de Riscos",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            
            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(120.dp),
                onClick = onNavigateToRecursos
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Recursos de Apoio",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(120.dp),
                onClick = onNavigateToVisualizacao
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Visualização de Dados",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            
            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(120.dp),
                onClick = onNavigateToLembretes
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Lembretes",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        
        // Dicas personalizadas
        Text(
            text = "Dicas Personalizadas",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(dicasPersonalizadas) { dica ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = dica,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }

    // Dialog para registro de humor
    if (showRegistroHumorDialog) {
        RegistroHumorDialog(
            onDismiss = { showRegistroHumorDialog = false },
            onRegistrar = { humor, nivelEstresse, observacoes ->
                repositorio.salvarRegistroHumor(humor, nivelEstresse, observacoes)
                historicoHumor.value = repositorio.obterHistoricoHumor()
                showRegistroHumorDialog = false
            }
        )
    }
}

@Composable
fun RegistroHumorDialog(
    onDismiss: () -> Unit,
    onRegistrar: (TipoHumor, Int, String) -> Unit
) {
    var humorSelecionado by remember { mutableStateOf<TipoHumor?>(null) }
    var nivelEstresse by remember { mutableStateOf(5) }
    var observacoes by remember { mutableStateOf("") }
    val lazyListState = rememberLazyListState()

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Como você está se sentindo?")
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                // Seleção de humor
                Text(
                    text = "Selecione seu humor:",
                    style = MaterialTheme.typography.bodyLarge
                )

                // Box para conter o LazyRow e os indicadores visuais
                Box(modifier = Modifier.fillMaxWidth()) {
                    LazyRow(
                        state = lazyListState,
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(horizontal = 32.dp) // Espaço para os indicadores
                    ) {
                        items(TipoHumor.values()) { humor ->
                            HumorOption(
                                humor = humor,
                                selected = humorSelecionado == humor,
                                onClick = { humorSelecionado = humor }
                            )
                        }
                    }

                    // Indicadores visuais de rolagem (gradientes nas extremidades)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Indicador de rolagem à esquerda (visível apenas quando não estiver no início)
                        Box(
                            modifier = Modifier
                                .width(24.dp)
                                .height(80.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            MaterialTheme.colorScheme.surface.copy(alpha = 0.7f),
                                            Color.Transparent
                                        )
                                    )
                                )
                                .alpha(if (lazyListState.firstVisibleItemIndex > 0) 1f else 0f)
                        )

                        // Indicador de rolagem à direita (visível apenas quando não estiver no fim)
                        Box(
                            modifier = Modifier
                                .width(24.dp)
                                .height(80.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            MaterialTheme.colorScheme.surface.copy(alpha = 0.7f)
                                        )
                                    )
                                )
                                .alpha(if (lazyListState.canScrollForward) 1f else 0f)
                        )
                    }
                }

                // Nível de estresse
                Text(
                    text = "Nível de estresse (1-10): $nivelEstresse",
                    style = MaterialTheme.typography.bodyLarge
                )

                Slider(
                    value = nivelEstresse.toFloat(),
                    onValueChange = { nivelEstresse = it.toInt() },
                    valueRange = 1f..10f,
                    steps = 8
                )

                // Observações
                OutlinedTextField(
                    value = observacoes,
                    onValueChange = { observacoes = it },
                    label = { Text("Observações (opcional)") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    humorSelecionado?.let { humor ->
                        onRegistrar(humor, nivelEstresse, observacoes)
                    }
                },
                enabled = humorSelecionado != null
            ) {
                Text("Registrar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

@Composable
fun HumorOption(
    humor: TipoHumor,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(4.dp)
            .width(72.dp) // Largura fixa para manter consistência
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                contentColor = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier.size(56.dp) // Tamanho fixo para o botão
        ) {
            Text(
                text = humor.emoji,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = humor.descricao,
            style = MaterialTheme.typography.bodySmall,
            color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}



