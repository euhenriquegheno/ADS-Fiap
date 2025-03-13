package br.com.fiap.calculojurossimples.juros

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.calculojurossimples.calculos.calcularJuros
import br.com.fiap.calculojurossimples.calculos.calcularMontante
import br.com.fiap.calculojurossimples.components.CaixaDeEntrada
import br.com.fiap.calculojurossimples.components.CardResultado

@Composable
fun JurosScreen(jurosScreenViewModel: JurosScreenViewModel) {

    val capital by jurosScreenViewModel
        .capital
        .observeAsState(initial = "")

    val taxa by jurosScreenViewModel
        .taxa
        .observeAsState(initial = "")

    val tempo by jurosScreenViewModel
        .tempo
        .observeAsState(initial = "")

    val juros by jurosScreenViewModel
        .jurosState
        .observeAsState(initial = 0.0)

    val montante by jurosScreenViewModel
        .montanteState
        .observeAsState(initial = 0.0)

    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(
                text = "Cálculo de Juros Simples",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Formulário para entrada de dados
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Dados do Investimento",
                        fontWeight = FontWeight.Bold
                    )
                    // Caixas de entrada da aplicação
                    CaixaDeEntrada(
                        value = capital,
                        placeholder = "Quanto deseja investir?",
                        label = "Valor do investimento",
                        modifier = Modifier,
                        keyboardType = KeyboardType.Decimal
                    ) {
                        jurosScreenViewModel.onCapitalChanged(it)
                    }
                    CaixaDeEntrada(
                        value = taxa,
                        placeholder = "Qual a taxa de juros mensal?",
                        label = "Taxa de juros mensal",
                        modifier = Modifier,
                        keyboardType = KeyboardType.Decimal
                    ) {
                        jurosScreenViewModel.onTaxaChanged(it)
                    }
                    CaixaDeEntrada(
                        value = tempo,
                        placeholder = "Qual o tempo em meses?",
                        label = "Período em meses",
                        modifier = Modifier,
                        keyboardType = KeyboardType.Decimal
                    ) {
                        jurosScreenViewModel.onTempoChanged(it)
                    }
                    Button(
                        onClick = {
                            jurosScreenViewModel.calcularJurosInvestimento()
                            jurosScreenViewModel.calcularMontanteInvestimento()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                    ) {
                        Text(text = "CALCULAR")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Resultado da aplicação
            CardResultado(
                juros = juros,
                montante = montante
            )
        }
    }
}