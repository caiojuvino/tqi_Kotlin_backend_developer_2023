package br.com.tqi.jumarket.entity

data class Carrinho(
    var id: Long? = null,
    var produtos: List<Produto>
)
