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

/**
 * Tela de lembretes e dicas personalizadas com base no histórico do usuário.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLembretes(
    repositorio: RepositorioDadosRoom,
    onVoltar: () -> Unit
) {
    val historicoHumor = remember { repositorio.obterHistoricoHumor() }
    val dicasPersonalizadas = remember { repositorio.obterDicasPersonalizadas(historicoHumor) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Lembretes e Dicas")
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
        // Uma única LazyColumn para toda a tela, garantindo rolagem completa
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // Título e descrição das dicas personalizadas
            item {
                Text(
                    text = "Dicas Personalizadas",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Com base no seu histórico de humor e avaliações, preparamos algumas dicas para ajudar a melhorar seu bem-estar mental.",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            // Dicas personalizadas ou mensagem quando não há dicas
            if (dicasPersonalizadas.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Registre seu humor diariamente para receber dicas personalizadas.",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            } else {
                items(dicasPersonalizadas) { dica ->
                    DicaCard(dica = dica)
                }
            }

            // Espaçador entre seções
            item {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Lembretes Diários",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            // Lembretes diários
            val lembretesDiarios = listOf(
                "Registre seu humor pela manhã",
                "Faça uma pausa de 5 minutos a cada hora de trabalho",
                "Beba água regularmente",
                "Pratique respiração profunda por 2 minutos",
                "Faça uma avaliação de risco semanalmente"
            )

            items(lembretesDiarios) { lembrete ->
                LembreteItem(lembrete = lembrete)

                // Pequeno espaçamento entre os itens
                if (lembrete != lembretesDiarios.last()) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            // Espaço adicional no final para garantir que o último item seja visível
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun DicaCard(dica: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = dica,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun LembreteItem(lembrete: String) {
    var checked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = lembrete,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )

            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}
