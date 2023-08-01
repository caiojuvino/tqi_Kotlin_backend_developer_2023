package br.com.tqi.jumarket.service

import br.com.tqi.jumarket.dto.ItemDtoRequest
import br.com.tqi.jumarket.entity.Carrinho

interface ICarrinhoService {

    fun criar(): Carrinho
    fun adicionarItem(idDoCarrinho: Long, dto: ItemDtoRequest): Carrinho
    fun buscarPorId(id: Long): Carrinho
    fun remover(id: Long)
}