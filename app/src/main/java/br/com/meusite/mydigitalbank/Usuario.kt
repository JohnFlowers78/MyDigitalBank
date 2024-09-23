package br.com.meusite.mydigitalbank

data class Usuario(
    val nome: String,
    val foto : Int,
    val transacoes: List<Transacao>
)
