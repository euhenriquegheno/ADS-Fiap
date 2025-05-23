package br.com.fiap.saudemental.model

/**
 * Enum que representa os níveis de risco psicossocial.
 */
enum class NivelRisco(val descricao: String, val porcentagem: String) {
    NEUTRO("Neutro", "0 a 25%"),
    LEVE("Leve", "26% a 50%"),
    MODERADO("Moderado", "51% a 75%"),
    AGUDO("Agudo", "76% a 100%")
}
