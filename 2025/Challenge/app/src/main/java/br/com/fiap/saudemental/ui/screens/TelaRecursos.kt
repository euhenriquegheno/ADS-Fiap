package br.com.fiap.saudemental.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.saudemental.data.RepositorioDados
import br.com.fiap.saudemental.model.Recurso
import br.com.fiap.saudemental.model.TipoRecurso

/**
 * Tela de recursos de apoio.
 * Permite ao usuário acessar artigos, vídeos, exercícios e contatos de apoio.
 */
@Composable
fun TelaRecursos(
    onRecursoSelecionado: (Recurso) -> Unit
) {
    var filtroTipo by remember { mutableStateOf<TipoRecurso?>(null) }
    var termoBusca by remember { mutableStateOf("") }
    
    val recursos = remember(filtroTipo, termoBusca) {
        var listaRecursos = if (filtroTipo != null) {
            RepositorioDados.obterRecursosPorTipo(filtroTipo!!)
        } else {
            RepositorioDados.obterRecursos()
        }
        
        if (termoBusca.isNotEmpty()) {
            listaRecursos = listaRecursos.filter { 
                it.titulo.contains(termoBusca, ignoreCase = true) || 
                it.tags.any { tag -> tag.contains(termoBusca, ignoreCase = true) }
            }
        }
        
        listaRecursos
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Recursos de Apoio",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = "Acesse artigos, vídeos, exercícios e contatos para apoiar sua saúde mental.",
            style = MaterialTheme.typography.bodyLarge
        )
        
        // Campo de busca
        OutlinedTextField(
            value = termoBusca,
            onValueChange = { termoBusca = it },
            label = { Text("Buscar recursos") },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Ícone de busca"
                )
            }
        )
        
        // Filtros por tipo
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            item {
                FilterChip(
                    selected = filtroTipo == null,
                    onClick = { filtroTipo = null },
                    label = { Text("Todos") }
                )
            }
            
            items(TipoRecurso.values()) { tipo ->
                FilterChip(
                    selected = filtroTipo == tipo,
                    onClick = { filtroTipo = tipo },
                    label = { Text(tipoRecursoParaTexto(tipo)) }
                )
            }
        }
        
        // Lista de recursos
        if (recursos.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Nenhum recurso encontrado",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(recursos) { recurso ->
                    RecursoItem(
                        recurso = recurso,
                        onClick = { onRecursoSelecionado(recurso) }
                    )
                }
            }
        }
    }
}

/**
 * Componente que exibe um item de recurso.
 */
@Composable
fun RecursoItem(
    recurso: Recurso,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = onClick
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
                Text(
                    text = tipoRecursoParaEmoji(recurso.tipo),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(end = 8.dp)
                )
                
                Text(
                    text = recurso.titulo,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Text(
                text = recurso.conteudo.take(100) + if (recurso.conteudo.length > 100) "..." else "",
                style = MaterialTheme.typography.bodyMedium
            )
            
            // Tags
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                recurso.tags.forEach { tag ->
                    SuggestionChip(
                        onClick = { },
                        label = { Text(tag) }
                    )
                }
            }
        }
    }
}

/**
 * Converte um TipoRecurso para texto legível.
 */
fun tipoRecursoParaTexto(tipo: TipoRecurso): String {
    return when (tipo) {
        TipoRecurso.ARTIGO -> "Artigos"
        TipoRecurso.VIDEO -> "Vídeos"
        TipoRecurso.EXERCICIO -> "Exercícios"
        TipoRecurso.CONTATO -> "Contatos"
    }
}

/**
 * Converte um TipoRecurso para emoji representativo.
 */
fun tipoRecursoParaEmoji(tipo: TipoRecurso): String {
    return when (tipo) {
        TipoRecurso.ARTIGO -> "📝"
        TipoRecurso.VIDEO -> "🎬"
        TipoRecurso.EXERCICIO -> "🧘"
        TipoRecurso.CONTATO -> "📞"
    }
}

/**
 * Tela de detalhes de um recurso específico.
 */
@Composable
fun TelaDetalhesRecurso(
    recurso: Recurso,
    onVoltar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = recurso.titulo,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = tipoRecursoParaEmoji(recurso.tipo),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(end = 8.dp)
            )
            
            Text(
                text = tipoRecursoParaTexto(recurso.tipo),
                style = MaterialTheme.typography.titleMedium
            )
        }
        
        Divider()
        
        Text(
            text = recurso.conteudo,
            style = MaterialTheme.typography.bodyLarge
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        Button(
            onClick = onVoltar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}
