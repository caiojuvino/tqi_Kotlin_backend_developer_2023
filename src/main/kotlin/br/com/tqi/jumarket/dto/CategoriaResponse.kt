package br.com.tqi.jumarket.dto

import br.com.tqi.jumarket.entity.Categoria

class CategoriaResponse (
    val id: Long,
    val nome: String
) {
    constructor(categoria: Categoria) : this(
        categoria.id,
        categoria.nome
    )
}
