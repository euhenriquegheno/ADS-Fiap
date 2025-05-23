package br.com.fiap.saudemental.model

/**
 * Modelo que representa um registro de humor diário.
 */
data class RegistroHumor(
    val id: String,
    val dataHora: Long,
    val humor: TipoHumor,
    val nivelEstresse: Int,
    val observacoes: String = ""
)

/**
 * Enum que representa os tipos de humor disponíveis para registro.
 */
enum class TipoHumor(val emoji: String, val descricao: String) {
    TRISTE("😢", "Triste"),
    ALEGRE("😊", "Alegre"),
    CANSADO("😴", "Cansado"),
    ANSIOSO("😰", "Ansioso"),
    MEDO("😨", "Medo"),
    RAIVA("😠", "Raiva"),
    MOTIVADO("💪", "Motivado"),
    PREOCUPADO("🤔", "Preocupado"),
    ESTRESSADO("😤", "Estressado"),
    ANIMADO("🤩", "Animado"),
    SATISFEITO("😌", "Satisfeito")
}
