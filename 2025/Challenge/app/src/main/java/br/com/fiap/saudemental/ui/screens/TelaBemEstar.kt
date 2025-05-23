package br.com.fiap.saudemental.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.saudemental.data.RepositorioDados
import br.com.fiap.saudemental.model.RegistroHumor
import br.com.fiap.saudemental.model.TipoHumor
import java.text.SimpleDateFormat
import java.util.*

/**
 * Tela de acompanhamento do bem-estar emocional.
 * Permite ao usuário registrar seu humor diário e visualizar histórico recente.
 */
@Composable
fun TelaBemEstar(
    onRegistroSalvo: () -> Unit
) {
    val historicoHumor = remember { RepositorioDados.obterHistoricoHumor() }
    var humorSelecionado by remember { mutableStateOf<TipoHumor?>(null) }
    var nivelEstresse by remember { mutableStateOf(5) }
    var observacoes by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Como você está hoje?",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = "Registre seu humor e nível de estresse para acompanhar seu bem-estar emocional.",
            style = MaterialTheme.typography.bodyLarge
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Seleção de humor
        Text(
            text = "Selecione seu humor:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(TipoHumor.values()) { humor ->
                SeletorHumor(
                    humor = humor,
                    selecionado = humor == humorSelecionado,
                    onSelecionar = { humorSelecionado = humor }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Nível de estresse
        Text(
            text = "Nível de estresse (1-10): $nivelEstresse",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        
        Slider(
            value = nivelEstresse.toFloat(),
            onValueChange = { nivelEstresse = it.toInt() },
            valueRange = 1f..10f,
            steps = 8,
            modifier = Modifier.fillMaxWidth()
        )
        
        // Observações
        OutlinedTextField(
            value = observacoes,
            onValueChange = { observacoes = it },
            label = { Text("Observações (opcional)") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Botão de salvar
        Button(
            onClick = {
                // Salvar o registro (simulado)
                onRegistroSalvo()
                
                // Limpar campos
                humorSelecionado = null
                nivelEstresse = 5
                observacoes = ""
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = humorSelecionado != null
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Registrar Humor")
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Histórico recente
        Text(
            text = "Histórico Recente",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        
        historicoHumor.take(5).forEach { registro ->
            RegistroHumorItem(registro = registro)
        }
    }
}

/**
 * Componente que exibe um seletor de humor.
 */
@Composable
fun SeletorHumor(
    humor: TipoHumor,
    selecionado: Boolean,
    onSelecionar: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(80.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selecionado) 
                MaterialTheme.colorScheme.primaryContainer 
            else 
                MaterialTheme.colorScheme.surface
        ),
        onClick = onSelecionar
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = humor.emoji,
                style = MaterialTheme.typography.headlineMedium
            )
            
            Text(
                text = humor.descricao,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

/**
 * Componente que exibe um item do histórico de humor.
 */
@Composable
fun RegistroHumorItem(registro: RegistroHumor) {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))
    val dataFormatada = dateFormat.format(Date(registro.dataHora))
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = registro.humor.emoji,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(end = 16.dp)
            )
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = registro.humor.descricao,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Text(
                    text = "Data: $dataFormatada",
                    style = MaterialTheme.typography.bodyMedium
                )
                
                Text(
                    text = "Nível de estresse: ${registro.nivelEstresse}/10",
                    style = MaterialTheme.typography.bodyMedium
                )
                
                if (registro.observacoes.isNotEmpty()) {
                    Text(
                        text = registro.observacoes,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}
