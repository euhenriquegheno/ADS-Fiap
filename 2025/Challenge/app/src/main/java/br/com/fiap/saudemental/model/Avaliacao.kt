package br.com.fiap.saudemental.model

/**
 * Modelo que representa uma avaliação de risco psicossocial.
 */
data class Avaliacao(
    val id: String,
    val dataHora: Long,
    val respostas: Map<String, Int>,
    val nivelRisco: NivelRisco,
    val recomendacoes: List<String>
)

/**
 * Modelo que representa uma pergunta de avaliação de risco psicossocial.
 */
data class Pergunta(
    val id: String,
    val texto: String,
    val opcoes: List<String>
)
