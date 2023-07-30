package br.com.tqi.jumarket.service

import br.com.tqi.jumarket.entity.Carrinho

interface ICarrinhoService {
    fun buscarTodos(): List<Carrinho>
    fun salvar(carrinho: Carrinho): Carrinho
    fun buscarPorId(id: Long): Carrinho
    fun remover(id: Long)
}