package br.com.fiap.saudemental.model

/**
 * Modelo que representa um recurso de apoio.
 */
data class Recurso(
    val id: String,
    val tipo: TipoRecurso,
    val titulo: String,
    val conteudo: String,
    val tags: List<String>,
    val recomendadoPara: List<NivelRisco>
)

/**
 * Enum que representa os tipos de recursos de apoio disponíveis.
 */
enum class TipoRecurso {
    ARTIGO,
    VIDEO,
    EXERCICIO,
    CONTATO
}
