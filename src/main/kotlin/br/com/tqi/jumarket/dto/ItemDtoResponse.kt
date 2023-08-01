package br.com.tqi.jumarket.dto

import br.com.tqi.jumarket.entity.Produto

class ItemDtoResponse (
    var id: Long?,
    var produto: Produto,
    var quantidade: Int
)