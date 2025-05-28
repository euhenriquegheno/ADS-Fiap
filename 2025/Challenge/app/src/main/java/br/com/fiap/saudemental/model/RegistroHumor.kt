package br.com.fiap.saudemental.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.fiap.saudemental.database.converter.Converters

/**
 * Modelo que representa um registro de humor diário.
 */
@Entity(tableName = "tbl_registro_humor")
@TypeConverters(Converters::class)
data class RegistroHumor(
    @PrimaryKey
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
