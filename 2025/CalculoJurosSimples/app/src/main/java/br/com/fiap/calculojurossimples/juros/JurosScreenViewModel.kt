package br.com.fiap.calculojurossimples.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.calculojurossimples.calculos.calcularJuros
import br.com.fiap.calculojurossimples.calculos.calcularMontante

class JurosScreenViewModel: ViewModel() {

    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String> = _capital

    private val _taxa = MutableLiveData<String>()
    val taxa: LiveData<String> = _taxa

    private val _tempo = MutableLiveData<String>()
    val tempo: LiveData<String> = _tempo

    private val _juros = MutableLiveData<Double>()
    val jurosState: LiveData<Double> = _juros

    private val _montante = MutableLiveData<Double>()
    val montanteState: LiveData<Double> = _montante

    fun onCapitalChanged(novoCapital: String) {
        _capital.value = novoCapital
    }

    fun onTaxaChanged(novaTaxa: String) {
        _taxa.value = novaTaxa
    }

    fun onTempoChanged(novoTempo: String) {
        _tempo.value = novoTempo
    }

    fun calcularJurosInvestimento() {
        _juros.value = calcularJuros(
            capital = _capital.value!!.toDouble(),
            taxa = _taxa.value!!.toDouble(),
            tempo = _tempo.value!!.toDouble()
        )
    }

    fun calcularMontanteInvestimento() {
        _montante.value = calcularMontante(
            _capital.value!!.toDouble(),
            _juros.value!!.toDouble()
        )
    }
}