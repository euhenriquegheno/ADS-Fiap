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
import br.com.fiap.saudemental.model.TipoRecurso

/**
 * Tela que exibe recursos de apoio para saúde mental.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaRecursos(
    repositorio: RepositorioDadosRoom,
    onVoltar: () -> Unit
) {
    var tipoSelecionado by remember { mutableStateOf<TipoRecurso?>(null) }
    val recursos = remember(tipoSelecionado) {
        if (tipoSelecionado != null) {
            repositorio.obterRecursosPorTipo(tipoSelecionado!!)
        } else {
            repositorio.obterRecursos()
        }
    }
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Recursos de Apoio")
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
            Text(
                text = "Filtrar por tipo:",
                style = MaterialTheme.typography.titleMedium
            )
            
            // Filtros de tipo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = tipoSelecionado == null,
                    onClick = { tipoSelecionado = null },
                    label = { Text("Todos") }
                )
                
                TipoRecurso.values().forEach { tipo ->
                    FilterChip(
                        selected = tipoSelecionado == tipo,
                        onClick = { tipoSelecionado = tipo },
                        label = { Text(tipo.name.lowercase().replaceFirstChar { it.uppercase() }) }
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Lista de recursos
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(recursos) { recurso ->
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
                                    text = recurso.titulo,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold
                                )

                                AssistChip(
                                    onClick = { },
                                    colors = AssistChipDefaults.assistChipColors(
                                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                                    ),
                                    label = {
                                        Text(
                                            text = recurso.tipo.name.lowercase().replaceFirstChar {
                                                it.uppercase()
                                            }
                                        )
                                    }
                                )
                            }
                            
                            Text(
                                text = recurso.conteudo,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            // Tags
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                recurso.tags.forEach { tag ->
                                    SuggestionChip(
                                        onClick = { },
                                        label = { Text(tag) }
                                    )
                                }
                            }
                            
                            // Níveis de risco recomendados
                            Text(
                                text = "Recomendado para:",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                            
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                recurso.recomendadoPara.forEach { nivel ->
                                    AssistChip(
                                        onClick = { },
                                        label = { Text(nivel.descricao) }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
