package br.com.fiap.saudemental.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.saudemental.data.RepositorioDados
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.IntrinsicSize

/**
 * Tela de lembretes e dicas personalizadas.
 * Exibe lembretes, dicas e apoio personalizado com base no histórico do usuário.
 */
@Composable
fun TelaLembretes() {
    val historicoHumor = remember { RepositorioDados.obterHistoricoHumor() }
    val dicasPersonalizadas = remember { RepositorioDados.obterDicasPersonalizadas(historicoHumor) }

    // Use um Column com verticalScroll para fazer toda a tela rolar
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Isso faz toda a tela rolar
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Lembretes e Dicas",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Confira lembretes e dicas personalizadas para apoiar seu bem-estar.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Lembretes diários
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )

                    Text(
                        text = "Lembretes Diários",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }

                Divider()

                // Lembretes fixos
                val lembretes = listOf(
                    "Registre seu humor diariamente",
                    "Faça uma pausa a cada 2 horas de trabalho",
                    "Beba água regularmente",
                    "Pratique 5 minutos de respiração profunda"
                )

                lembretes.forEach { lembrete ->
                    LembreteItem(
                        texto = lembrete,
                        horario = obterHorarioAleatorio()
                    )
                }

                Button(
                    onClick = { /* Adicionar novo lembrete */ },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Adicionar Lembrete")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Dicas personalizadas
        Text(
            text = "Dicas Personalizadas",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        // Use Column em vez de LazyColumn para as dicas
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            dicasPersonalizadas.forEach { dica ->
                DicaPersonalizadaItem(dica = dica)
            }
        }

        // Adicione um espaço no final para garantir que tudo seja visível
        Spacer(modifier = Modifier.height(24.dp))
    }
}

/**
 * Componente que exibe um item de lembrete.
 */
@Composable
fun LembreteItem(
    texto: String,
    horario: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = texto,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        
        Text(
            text = horario,
            style = MaterialTheme.typography.bodyMedium
        )
        
        Switch(
            checked = true,
            onCheckedChange = { /* Ativar/desativar lembrete */ }
        )
    }
}

/**
 * Componente que exibe um item de dica personalizada.
 */
@Composable
fun DicaPersonalizadaItem(dica: String) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "💡",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(end = 16.dp)
            )
            
            Column {
                Text(
                    text = "Dica para você",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = dica,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

/**
 * Gera um horário aleatório para simulação.
 */
private fun obterHorarioAleatorio(): String {
    val horas = (8..20).random()
    val minutos = listOf(0, 15, 30, 45).random()
    return String.format("%02d:%02d", horas, minutos)
}
