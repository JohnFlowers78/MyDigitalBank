package br.com.meusite.mydigitalbank

data class Transacao(
    val descricao: String,
    val valor: Double,
    val data: String,
    val hora: String
)