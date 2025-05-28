package br.com.fiap.saudemental.database.converter

import androidx.room.TypeConverter
import br.com.fiap.saudemental.model.NivelRisco
import br.com.fiap.saudemental.model.TipoHumor
import br.com.fiap.saudemental.model.TipoRecurso
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Classe de conversores para tipos complexos usados no Room
 */
class Converters {
    private val gson = Gson()

    // Conversores para List<String>
    @TypeConverter
    fun fromStringList(value: List<String>?): String {
        return gson.toJson(value ?: emptyList<String>())
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listType) ?: emptyList()
    }

    // Conversores para Map<String, Int>
    @TypeConverter
    fun fromStringIntMap(value: Map<String, Int>?): String {
        return gson.toJson(value ?: emptyMap<String, Int>())
    }

    @TypeConverter
    fun toStringIntMap(value: String): Map<String, Int> {
        val mapType = object : TypeToken<Map<String, Int>>() {}.type
        return gson.fromJson(value, mapType) ?: emptyMap()
    }

    // Conversores para List<NivelRisco>
    @TypeConverter
    fun fromNivelRiscoList(value: List<NivelRisco>?): String {
        return gson.toJson(value?.map { it.name } ?: emptyList<String>())
    }

    @TypeConverter
    fun toNivelRiscoList(value: String): List<NivelRisco> {
        val listType = object : TypeToken<List<String>>() {}.type
        val stringList: List<String> = gson.fromJson(value, listType) ?: emptyList()
        return stringList.map { NivelRisco.valueOf(it) }
    }

    // Conversores para NivelRisco
    @TypeConverter
    fun fromNivelRisco(value: NivelRisco?): String? {
        return value?.name
    }

    @TypeConverter
    fun toNivelRisco(value: String?): NivelRisco? {
        return if (value == null) null else NivelRisco.valueOf(value)
    }

    // Conversores para TipoRecurso
    @TypeConverter
    fun fromTipoRecurso(value: TipoRecurso?): String? {
        return value?.name
    }

    @TypeConverter
    fun toTipoRecurso(value: String?): TipoRecurso? {
        return if (value == null) null else TipoRecurso.valueOf(value)
    }

    // Conversores para TipoHumor
    @TypeConverter
    fun fromTipoHumor(value: TipoHumor?): String? {
        return value?.name
    }

    @TypeConverter
    fun toTipoHumor(value: String?): TipoHumor? {
        return if (value == null) null else TipoHumor.valueOf(value)
    }
}
