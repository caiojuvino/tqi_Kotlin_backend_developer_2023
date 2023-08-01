package br.com.tqi.jumarket.dto

import br.com.tqi.jumarket.entity.Item

class CarrinhoDto (
    var id: Long?,
    var itens: MutableList<Item> = mutableListOf()
)