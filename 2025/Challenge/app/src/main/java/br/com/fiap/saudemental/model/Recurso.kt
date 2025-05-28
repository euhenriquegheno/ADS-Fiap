package br.com.fiap.saudemental.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.fiap.saudemental.database.converter.Converters

/**
 * Modelo que representa um recurso de apoio.
 */
@Entity(tableName = "tbl_recurso")
@TypeConverters(Converters::class)
data class Recurso(
    @PrimaryKey
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
