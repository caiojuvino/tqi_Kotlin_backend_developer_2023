package br.com.tqi.jumarket.dto

import br.com.tqi.jumarket.entity.Categoria
import java.math.BigDecimal

class ProdutoDto (
    var id: Long?,
    var categoria: Categoria,
    var nome: String,
    var unidadeDeMedida: String,
    var preco: BigDecimal
)