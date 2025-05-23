package br.com.fiap.saudemental.data

import br.com.fiap.saudemental.model.*
import java.util.*

/**
 * Repositório que fornece dados mockados para a aplicação.
 * Na Sprint 1, todos os dados são simulados localmente.
 */
object RepositorioDados {

    /**
     * Retorna uma lista de perguntas para avaliação de riscos psicossociais.
     */
    fun obterPerguntas(): List<Pergunta> {
        return listOf(
            Pergunta(
                id = "p1",
                texto = "Com que frequência você se sente sobrecarregado com metas de trabalho?",
                opcoes = listOf("Nunca", "Raramente", "Às vezes", "Frequentemente")
            ),
            Pergunta(
                id = "p2",
                texto = "Com que frequência sua jornada de trabalho se estende além do horário normal?",
                opcoes = listOf("Nunca", "Raramente", "Às vezes", "Frequentemente")
            ),
            Pergunta(
                id = "p3",
                texto = "Com que frequência você sente falta de suporte dos colegas ou superiores?",
                opcoes = listOf("Nunca", "Raramente", "Às vezes", "Frequentemente")
            ),
            Pergunta(
                id = "p4",
                texto = "Com que frequência você presencia ou sofre comportamentos desrespeitosos no trabalho?",
                opcoes = listOf("Nunca", "Raramente", "Às vezes", "Frequentemente")
            ),
            Pergunta(
                id = "p5",
                texto = "Com que frequência você se sente sem autonomia para realizar suas tarefas?",
                opcoes = listOf("Nunca", "Raramente", "Às vezes", "Frequentemente")
            )
        )
    }

    /**
     * Calcula o nível de risco com base nas respostas da avaliação.
     */
    fun calcularNivelRisco(respostas: Map<String, Int>): NivelRisco {
        // Cálculo simplificado para exemplo
        val total = respostas.values.sum()
        val maximo = respostas.size * 3 // Valor máximo possível (3 = índice de "Frequentemente")
        val porcentagem = (total.toDouble() / maximo) * 100

        return when {
            porcentagem <= 25 -> NivelRisco.NEUTRO
            porcentagem <= 50 -> NivelRisco.LEVE
            porcentagem <= 75 -> NivelRisco.MODERADO
            else -> NivelRisco.AGUDO
        }
    }

    /**
     * Gera recomendações com base no nível de risco.
     */
    fun gerarRecomendacoes(nivelRisco: NivelRisco): List<String> {
        return when (nivelRisco) {
            NivelRisco.NEUTRO -> listOf(
                "Continue mantendo o equilíbrio entre vida pessoal e profissional",
                "Pratique exercícios físicos regularmente",
                "Mantenha uma rotina de sono saudável"
            )
            NivelRisco.LEVE -> listOf(
                "Estabeleça limites claros entre trabalho e descanso",
                "Pratique técnicas de respiração e mindfulness",
                "Considere conversar com um colega de confiança sobre suas preocupações"
            )
            NivelRisco.MODERADO -> listOf(
                "Busque apoio profissional para gerenciar o estresse",
                "Reavalie sua carga de trabalho e prioridades",
                "Pratique técnicas de relaxamento diariamente",
                "Considere conversar com seu gestor sobre ajustes na rotina"
            )
            NivelRisco.AGUDO -> listOf(
                "Busque ajuda profissional imediatamente",
                "Considere tirar alguns dias de folga para recuperação",
                "Pratique técnicas de autocuidado intensivas",
                "Converse com RH sobre possíveis adaptações no ambiente de trabalho",
                "Estabeleça limites rígidos para preservar sua saúde mental"
            )
        }
    }

    /**
     * Retorna uma lista de recursos de apoio.
     */
    fun obterRecursos(): List<Recurso> {
        return listOf(
            Recurso(
                id = "r1",
                tipo = TipoRecurso.ARTIGO,
                titulo = "Como gerenciar o estresse no ambiente de trabalho",
                conteudo = "O estresse no trabalho é uma realidade para muitos profissionais. Neste artigo, apresentamos estratégias eficazes para gerenciar o estresse e manter o equilíbrio emocional durante a jornada de trabalho...",
                tags = listOf("estresse", "trabalho", "equilíbrio"),
                recomendadoPara = listOf(NivelRisco.LEVE, NivelRisco.MODERADO)
            ),
            Recurso(
                id = "r2",
                tipo = TipoRecurso.VIDEO,
                titulo = "Técnicas de respiração para momentos de ansiedade",
                conteudo = "Neste vídeo, você aprenderá técnicas simples de respiração que podem ser praticadas em qualquer lugar para reduzir a ansiedade e acalmar a mente...",
                tags = listOf("ansiedade", "respiração", "técnicas"),
                recomendadoPara = listOf(NivelRisco.LEVE, NivelRisco.MODERADO, NivelRisco.AGUDO)
            ),
            Recurso(
                id = "r3",
                tipo = TipoRecurso.EXERCICIO,
                titulo = "Meditação guiada para redução de estresse",
                conteudo = "Siga este exercício de meditação guiada de 10 minutos para reduzir o estresse e aumentar a clareza mental...",
                tags = listOf("meditação", "estresse", "mindfulness"),
                recomendadoPara = listOf(NivelRisco.NEUTRO, NivelRisco.LEVE, NivelRisco.MODERADO)
            ),
            Recurso(
                id = "r4",
                tipo = TipoRecurso.CONTATO,
                titulo = "Linha de apoio psicológico",
                conteudo = "Contato confidencial para suporte psicológico imediato. Disponível 24/7 para todos os funcionários...",
                tags = listOf("apoio", "emergência", "psicológico"),
                recomendadoPara = listOf(NivelRisco.MODERADO, NivelRisco.AGUDO)
            ),
            Recurso(
                id = "r5",
                tipo = TipoRecurso.ARTIGO,
                titulo = "Estabelecendo limites saudáveis no trabalho",
                conteudo = "Aprender a dizer não e estabelecer limites claros é essencial para manter a saúde mental no ambiente de trabalho...",
                tags = listOf("limites", "trabalho", "saúde mental"),
                recomendadoPara = listOf(NivelRisco.LEVE, NivelRisco.MODERADO)
            )
        )
    }

    /**
     * Retorna recursos filtrados por tipo.
     */
    fun obterRecursosPorTipo(tipo: TipoRecurso): List<Recurso> {
        return obterRecursos().filter { it.tipo == tipo }
    }

    /**
     * Retorna recursos recomendados para um nível de risco específico.
     */
    fun obterRecursosPorNivelRisco(nivelRisco: NivelRisco): List<Recurso> {
        return obterRecursos().filter { it.recomendadoPara.contains(nivelRisco) }
    }

    /**
     * Simula o histórico de registros de humor.
     */
    fun obterHistoricoHumor(): List<RegistroHumor> {
        val calendar = Calendar.getInstance()
        val hoje = calendar.timeInMillis
        
        // Cria registros para os últimos 7 dias
        val registros = mutableListOf<RegistroHumor>()
        
        for (i in 0..6) {
            calendar.timeInMillis = hoje
            calendar.add(Calendar.DAY_OF_YEAR, -i)
            
            // Simula diferentes humores e níveis de estresse
            val humor = TipoHumor.values().random()
            val nivelEstresse = (1..10).random()
            
            registros.add(
                RegistroHumor(
                    id = UUID.randomUUID().toString(),
                    dataHora = calendar.timeInMillis,
                    humor = humor,
                    nivelEstresse = nivelEstresse,
                    observacoes = "Registro do dia ${calendar.get(Calendar.DAY_OF_MONTH)}/${calendar.get(Calendar.MONTH) + 1}"
                )
            )
        }
        
        return registros
    }

    /**
     * Retorna dicas personalizadas com base no histórico de humor.
     */
    fun obterDicasPersonalizadas(historicoHumor: List<RegistroHumor>): List<String> {
        // Análise simplificada do histórico
        val humorFrequente = historicoHumor
            .groupBy { it.humor }
            .maxByOrNull { it.value.size }
            ?.key
        
        val estresseMedio = historicoHumor
            .map { it.nivelEstresse }
            .average()
            .toInt()
        
        val dicas = mutableListOf<String>()
        
        // Dicas baseadas no humor mais frequente
        when (humorFrequente) {
            TipoHumor.ANSIOSO, TipoHumor.PREOCUPADO, TipoHumor.ESTRESSADO -> {
                dicas.add("Pratique técnicas de respiração profunda por 5 minutos, 3 vezes ao dia")
                dicas.add("Considere limitar o consumo de cafeína")
                dicas.add("Reserve momentos do dia para desconectar-se de dispositivos eletrônicos")
            }
            TipoHumor.TRISTE, TipoHumor.CANSADO -> {
                dicas.add("Tente incluir uma caminhada leve de 15 minutos em sua rotina diária")
                dicas.add("Busque interações sociais positivas, mesmo que breves")
                dicas.add("Considere ajustar sua rotina de sono para garantir 7-8 horas de descanso")
            }
            TipoHumor.ALEGRE, TipoHumor.MOTIVADO, TipoHumor.ANIMADO -> {
                dicas.add("Continue cultivando atividades que trazem alegria e satisfação")
                dicas.add("Compartilhe sua energia positiva com colegas que possam estar precisando")
                dicas.add("Mantenha um diário de gratidão para reforçar emoções positivas")
            }
            else -> {
                dicas.add("Pratique a atenção plena (mindfulness) por alguns minutos diariamente")
                dicas.add("Mantenha uma rotina equilibrada entre trabalho e descanso")
                dicas.add("Reserve tempo para atividades que você aprecia")
            }
        }
        
        // Dicas baseadas no nível médio de estresse
        when {
            estresseMedio >= 7 -> {
                dicas.add("Seu nível de estresse está elevado. Considere técnicas de relaxamento diárias")
                dicas.add("Avalie suas prioridades e veja o que pode ser delegado ou adiado")
                dicas.add("Considere conversar com um profissional sobre estratégias de manejo de estresse")
            }
            estresseMedio >= 4 -> {
                dicas.add("Pratique pausas curtas durante o dia para reduzir o acúmulo de tensão")
                dicas.add("Experimente técnicas de alongamento para aliviar a tensão física")
                dicas.add("Considere atividades relaxantes como leitura ou banhos quentes antes de dormir")
            }
        }
        
        return dicas
    }
}
