package br.com.fiap.saudemental.utils

import android.content.Context
import br.com.fiap.saudemental.database.repository.RepositorioDadosRoom
import br.com.fiap.saudemental.model.NivelRisco
import br.com.fiap.saudemental.model.TipoHumor
import br.com.fiap.saudemental.model.TipoRecurso
import java.util.*

/**
 * Classe utilitária para testar a persistência e integridade dos dados no banco Room.
 */
class TesteDados(private val context: Context) {

    private val repositorio = RepositorioDadosRoom(context)

    /**
     * Executa testes de persistência e integridade dos dados.
     * @return Resultado dos testes como uma string formatada
     */
    fun executarTestes(): String {
        val resultados = StringBuilder()

        resultados.append("=== TESTES DE PERSISTÊNCIA E INTEGRIDADE ===\n\n")

        // Teste de perguntas
        val perguntasResult = testePerguntasPersistencia()
        resultados.append("1. Teste de Perguntas: $perguntasResult\n\n")

        // Teste de recursos
        val recursosResult = testeRecursosPersistencia()
        resultados.append("2. Teste de Recursos: $recursosResult\n\n")

        // Teste de avaliação
        val avaliacaoResult = testeAvaliacaoPersistencia()
        resultados.append("3. Teste de Avaliação: $avaliacaoResult\n\n")

        // Teste de registro de humor
        val humorResult = testeRegistroHumorPersistencia()
        resultados.append("4. Teste de Registro de Humor: $humorResult\n\n")

        // Teste de consultas específicas
        val consultasResult = testeConsultasEspecificas()
        resultados.append("5. Teste de Consultas Específicas: $consultasResult\n\n")

        resultados.append("=== RESULTADO FINAL ===\n")
        if (perguntasResult.contains("FALHA") ||
            recursosResult.contains("FALHA") ||
            avaliacaoResult.contains("FALHA") ||
            humorResult.contains("FALHA") ||
            consultasResult.contains("FALHA")) {
            resultados.append("❌ FALHA: Alguns testes não passaram. Verifique os detalhes acima.")
        } else {
            resultados.append("✅ SUCESSO: Todos os testes passaram com sucesso!")
        }

        return resultados.toString()
    }

    private fun testePerguntasPersistencia(): String {
        try {
            // Verificar se as perguntas foram carregadas corretamente
            val perguntas = repositorio.obterPerguntas()
            if (perguntas.isEmpty()) {
                return "❌ FALHA: Nenhuma pergunta encontrada no banco"
            }

            // Verificar se as perguntas têm todos os campos necessários
            val perguntaCompleta = perguntas.firstOrNull {
                it.id.isNotEmpty() &&
                        it.texto.isNotEmpty() &&
                        it.opcoes.isNotEmpty()
            }

            if (perguntaCompleta == null) {
                return "❌ FALHA: Perguntas não contêm todos os campos necessários"
            }

            return "✅ SUCESSO: Perguntas persistidas corretamente"
        } catch (e: Exception) {
            return "❌ FALHA: ${e.message}"
        }
    }

    private fun testeRecursosPersistencia(): String {
        try {
            // Verificar se os recursos foram carregados corretamente
            val recursos = repositorio.obterRecursos()
            if (recursos.isEmpty()) {
                return "❌ FALHA: Nenhum recurso encontrado no banco"
            }

            // Verificar se os recursos têm todos os campos necessários
            val recursoCompleto = recursos.firstOrNull {
                it.id.isNotEmpty() &&
                        it.titulo.isNotEmpty() &&
                        it.conteudo.isNotEmpty() &&
                        it.tags.isNotEmpty() &&
                        it.recomendadoPara.isNotEmpty()
            }

            if (recursoCompleto == null) {
                return "❌ FALHA: Recursos não contêm todos os campos necessários"
            }

            // Testar filtro por tipo
            val tipoTeste = TipoRecurso.ARTIGO
            val recursosFiltrados = repositorio.obterRecursosPorTipo(tipoTeste)
            if (recursosFiltrados.isEmpty() || recursosFiltrados.any { it.tipo != tipoTeste }) {
                return "❌ FALHA: Filtro de recursos por tipo não funciona corretamente"
            }

            return "✅ SUCESSO: Recursos persistidos corretamente"
        } catch (e: Exception) {
            return "❌ FALHA: ${e.message}"
        }
    }

    private fun testeAvaliacaoPersistencia(): String {
        try {
            // Criar uma avaliação de teste
            val respostas = mapOf(
                "p1" to 2,
                "p2" to 1,
                "p3" to 3,
                "p4" to 0,
                "p5" to 2
            )

            val avaliacao = repositorio.salvarAvaliacao(respostas)

            // Verificar se a avaliação foi salva corretamente
            val avaliacaoSalva = repositorio.listarAvaliacoes().find { it.id == avaliacao.id }
            if (avaliacaoSalva == null) {
                return "❌ FALHA: Avaliação não foi salva no banco"
            }

            // Verificar se todos os campos foram salvos corretamente
            if (avaliacaoSalva.respostas != respostas ||
                avaliacaoSalva.nivelRisco != avaliacao.nivelRisco ||
                avaliacaoSalva.recomendacoes != avaliacao.recomendacoes) {
                return "❌ FALHA: Campos da avaliação não foram salvos corretamente"
            }

            return "✅ SUCESSO: Avaliação persistida corretamente"
        } catch (e: Exception) {
            return "❌ FALHA: ${e.message}"
        }
    }

    private fun testeRegistroHumorPersistencia(): String {
        try {
            // Criar um registro de humor de teste
            val humor = TipoHumor.ALEGRE
            val nivelEstresse = 3
            val observacoes = "Teste de persistência"

            val registro = repositorio.salvarRegistroHumor(humor, nivelEstresse, observacoes)

            // Verificar se o registro foi salvo corretamente
            val registroSalvo = repositorio.obterHistoricoHumor().find { it.id == registro.id }
            if (registroSalvo == null) {
                return "❌ FALHA: Registro de humor não foi salvo no banco"
            }

            // Verificar se todos os campos foram salvos corretamente
            if (registroSalvo.humor != humor ||
                registroSalvo.nivelEstresse != nivelEstresse ||
                registroSalvo.observacoes != observacoes) {
                return "❌ FALHA: Campos do registro de humor não foram salvos corretamente"
            }

            return "✅ SUCESSO: Registro de humor persistido corretamente"
        } catch (e: Exception) {
            return "❌ FALHA: ${e.message}"
        }
    }

    private fun testeConsultasEspecificas(): String {
        try {
            // Testar consulta de recursos por nível de risco
            val nivelTeste = NivelRisco.MODERADO
            val recursosPorNivel = repositorio.obterRecursosPorNivelRisco(nivelTeste)
            if (recursosPorNivel.isEmpty() || recursosPorNivel.any { !it.recomendadoPara.contains(nivelTeste) }) {
                return "❌ FALHA: Consulta de recursos por nível de risco não funciona corretamente"
            }

            // Testar consulta de histórico de humor
            val historicoHumor = repositorio.obterHistoricoHumor()
            if (historicoHumor.isEmpty()) {
                return "❌ FALHA: Consulta de histórico de humor não retorna resultados"
            }

            // Testar geração de dicas personalizadas
            val dicas = repositorio.obterDicasPersonalizadas(historicoHumor)
            if (dicas.isEmpty()) {
                return "❌ FALHA: Geração de dicas personalizadas não funciona corretamente"
            }

            return "✅ SUCESSO: Consultas específicas funcionam corretamente"
        } catch (e: Exception) {
            return "❌ FALHA: ${e.message}"
        }
    }
}
