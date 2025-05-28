package br.com.fiap.saudemental.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.fiap.saudemental.database.converter.Converters

/**
 * Modelo que representa uma avaliação de risco psicossocial.
 */
@Entity(tableName = "tbl_avaliacao")
@TypeConverters(Converters::class)
data class Avaliacao(
    @PrimaryKey
    val id: String,
    val dataHora: Long,
    val respostas: Map<String, Int>,
    val nivelRisco: NivelRisco,
    val recomendacoes: List<String>
)

/**
 * Modelo que representa uma pergunta de avaliação de risco psicossocial.
 */
@Entity(tableName = "tbl_pergunta")
data class Pergunta(
    @PrimaryKey
    val id: String,
    val texto: String,
    @TypeConverters(Converters::class)
    val opcoes: List<String>
)
