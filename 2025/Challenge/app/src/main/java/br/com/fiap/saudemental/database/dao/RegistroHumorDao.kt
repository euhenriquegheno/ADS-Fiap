package br.com.fiap.saudemental.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.saudemental.model.RegistroHumor
import br.com.fiap.saudemental.model.TipoHumor

/**
 * DAO para operações de banco de dados relacionadas à entidade RegistroHumor
 */
@Dao
interface RegistroHumorDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salvar(registroHumor: RegistroHumor): Long
    
    @Update
    fun atualizar(registroHumor: RegistroHumor): Int
    
    @Delete
    fun excluir(registroHumor: RegistroHumor): Int
    
    @Query("SELECT * FROM tbl_registro_humor WHERE id = :id")
    fun buscarPorId(id: String): RegistroHumor?
    
    @Query("SELECT * FROM tbl_registro_humor ORDER BY dataHora DESC")
    fun listarTodos(): List<RegistroHumor>
    
    @Query("SELECT * FROM tbl_registro_humor WHERE humor = :tipoHumor ORDER BY dataHora DESC")
    fun listarPorTipoHumor(tipoHumor: TipoHumor): List<RegistroHumor>
    
    @Query("SELECT * FROM tbl_registro_humor WHERE dataHora BETWEEN :dataInicio AND :dataFim ORDER BY dataHora DESC")
    fun listarPorPeriodo(dataInicio: Long, dataFim: Long): List<RegistroHumor>
}
