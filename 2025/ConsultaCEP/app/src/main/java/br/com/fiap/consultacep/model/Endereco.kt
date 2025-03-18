package br.com.fiap.consultacep.model

import com.google.gson.annotations.SerializedName

data class Endereco (
    val cep: String = "",
    @SerializedName("logradouro") val rua: String = "", //Estou chamando de rua, mas no json de resposta vai ser logradouro
    @SerializedName("localidade") val cidade: String = "",
    val bairro: String = "",
    val uf: String = ""
)