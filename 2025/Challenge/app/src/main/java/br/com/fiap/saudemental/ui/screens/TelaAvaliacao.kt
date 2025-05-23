package br.com.fiap.saudemental.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.saudemental.data.RepositorioDados
import br.com.fiap.saudemental.model.Pergunta

/**
 * Tela de avaliação de riscos psicossociais.
 * Permite ao usuário responder um questionário para avaliar seu nível de risco.
 */
@Composable
fun TelaAvaliacao(
    onAvaliacaoConcluida: (Map<String, Int>) -> Unit
) {
    val perguntas = RepositorioDados.obterPerguntas()
    var perguntaAtual by remember { mutableStateOf(0) }
    val respostas = remember { mutableStateMapOf<String, Int>() }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Avaliação de Riscos Psicossociais",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = "Responda às perguntas abaixo para avaliarmos seu nível de risco psicossocial.",
            style = MaterialTheme.typography.bodyLarge
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        if (perguntaAtual < perguntas.size) {
            // Exibe a pergunta atual
            PerguntaAvaliacao(
                pergunta = perguntas[perguntaAtual],
                respostaSelecionada = respostas[perguntas[perguntaAtual].id],
                onRespostaSelecionada = { valor ->
                    respostas[perguntas[perguntaAtual].id] = valor
                }
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (perguntaAtual > 0) {
                    Button(
                        onClick = { perguntaAtual-- }
                    ) {
                        Text("Anterior")
                    }
                } else {
                    Spacer(modifier = Modifier.width(88.dp)) // Espaço equivalente ao botão
                }
                
                Button(
                    onClick = {
                        if (respostas.containsKey(perguntas[perguntaAtual].id)) {
                            perguntaAtual++
                        }
                    },
                    enabled = respostas.containsKey(perguntas[perguntaAtual].id)
                ) {
                    Text("Próxima")
                }
            }
            
            // Indicador de progresso
            LinearProgressIndicator(
                progress = (perguntaAtual + 1).toFloat() / perguntas.size,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
            
            Text(
                text = "Pergunta ${perguntaAtual + 1} de ${perguntas.size}",
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            // Todas as perguntas foram respondidas
            ResultadoAvaliacao(
                respostas = respostas,
                onConcluir = { onAvaliacaoConcluida(respostas) }
            )
        }
    }
}

/**
 * Componente que exibe uma pergunta da avaliação e suas opções de resposta.
 */
@Composable
fun PerguntaAvaliacao(
    pergunta: Pergunta,
    respostaSelecionada: Int?,
    onRespostaSelecionada: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = pergunta.texto,
            style = MaterialTheme.typography.titleLarge
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        pergunta.opcoes.forEachIndexed { index, opcao ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = respostaSelecionada == index,
                    onClick = { onRespostaSelecionada(index) }
                )
                
                Text(
                    text = opcao,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

/**
 * Componente que exibe o resultado da avaliação de riscos.
 */
@Composable
fun ResultadoAvaliacao(
    respostas: Map<String, Int>,
    onConcluir: () -> Unit
) {
    val nivelRisco = RepositorioDados.calcularNivelRisco(respostas)
    val recomendacoes = RepositorioDados.gerarRecomendacoes(nivelRisco)
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Resultado da Avaliação",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = when (nivelRisco) {
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
                Text(
                    text = "Seu nível de risco é: ${nivelRisco.descricao}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                
                Text(
                    text = "Faixa: ${nivelRisco.porcentagem}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        
        Text(
            text = "Recomendações",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(recomendacoes) { recomendacao ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = recomendacao,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                        
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null
                        )
                    }
                }
            }
        }
        
        Button(
            onClick = onConcluir,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Concluir Avaliação")
        }
    }
}
