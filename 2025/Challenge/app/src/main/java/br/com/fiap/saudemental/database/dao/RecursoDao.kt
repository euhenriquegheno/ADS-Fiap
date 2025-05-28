package br.com.fiap.saudemental.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.saudemental.model.Recurso
import br.com.fiap.saudemental.model.TipoRecurso

/**
 * DAO para operações de banco de dados relacionadas à entidade Recurso
 */
@Dao
interface RecursoDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salvar(recurso: Recurso): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salvarTodos(recursos: List<Recurso>)
    
    @Update
    fun atualizar(recurso: Recurso): Int
    
    @Delete
    fun excluir(recurso: Recurso): Int
    
    @Query("SELECT * FROM tbl_recurso WHERE id = :id")
    fun buscarPorId(id: String): Recurso?
    
    @Query("SELECT * FROM tbl_recurso")
    fun listarTodos(): List<Recurso>
    
    @Query("SELECT * FROM tbl_recurso WHERE tipo = :tipo")
    fun listarPorTipo(tipo: TipoRecurso): List<Recurso>
}
