package br.com.tqi.jumarket.entity

import java.math.BigDecimal

data class Produto(
    var id: Long? = null,
    var nome: String,
    var unidadeDeMedida: String,
    var preco: BigDecimal,
    var categoria: Categoria
)
