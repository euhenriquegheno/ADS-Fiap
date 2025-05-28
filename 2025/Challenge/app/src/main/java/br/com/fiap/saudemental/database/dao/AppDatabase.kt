package br.com.fiap.saudemental.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.fiap.saudemental.database.converter.Converters
import br.com.fiap.saudemental.model.Avaliacao
import br.com.fiap.saudemental.model.Pergunta
import br.com.fiap.saudemental.model.Recurso
import br.com.fiap.saudemental.model.RegistroHumor

/**
 * Classe principal do banco de dados Room que gerencia todas as entidades e DAOs
 */
@Database(
    entities = [
        Avaliacao::class,
        Pergunta::class,
        Recurso::class,
        RegistroHumor::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun avaliacaoDao(): AvaliacaoDao
    abstract fun perguntaDao(): PerguntaDao
    abstract fun recursoDao(): RecursoDao
    abstract fun registroHumorDao(): RegistroHumorDao

    companion object {
        private const val DATABASE_NAME = "saude_mental_db"
        
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                .allowMainThreadQueries() // Apenas para simplificar o exemplo, em produção use coroutines
                .fallbackToDestructiveMigration()
                .build()
                
                INSTANCE = instance
                instance
            }
        }
    }
}
