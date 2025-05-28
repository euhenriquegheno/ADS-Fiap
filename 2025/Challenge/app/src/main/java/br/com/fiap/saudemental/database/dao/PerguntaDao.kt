package br.com.fiap.saudemental.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.saudemental.model.Pergunta

/**
 * DAO para operações de banco de dados relacionadas à entidade Pergunta
 */
@Dao
interface PerguntaDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salvar(pergunta: Pergunta): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salvarTodas(perguntas: List<Pergunta>)
    
    @Update
    fun atualizar(pergunta: Pergunta): Int
    
    @Delete
    fun excluir(pergunta: Pergunta): Int
    
    @Query("SELECT * FROM tbl_pergunta WHERE id = :id")
    fun buscarPorId(id: String): Pergunta?
    
    @Query("SELECT * FROM tbl_pergunta")
    fun listarTodas(): List<Pergunta>
}
