package br.com.fiap.saudemental.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.saudemental.model.Avaliacao

/**
 * DAO para operações de banco de dados relacionadas à entidade Avaliacao
 */
@Dao
interface AvaliacaoDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salvar(avaliacao: Avaliacao): Long
    
    @Update
    fun atualizar(avaliacao: Avaliacao): Int
    
    @Delete
    fun excluir(avaliacao: Avaliacao): Int
    
    @Query("SELECT * FROM tbl_avaliacao WHERE id = :id")
    fun buscarPorId(id: String): Avaliacao?
    
    @Query("SELECT * FROM tbl_avaliacao ORDER BY dataHora DESC")
    fun listarTodas(): List<Avaliacao>
    
    @Query("SELECT * FROM tbl_avaliacao WHERE nivelRisco = :nivelRisco ORDER BY dataHora DESC")
    fun listarPorNivelRisco(nivelRisco: String): List<Avaliacao>
}
