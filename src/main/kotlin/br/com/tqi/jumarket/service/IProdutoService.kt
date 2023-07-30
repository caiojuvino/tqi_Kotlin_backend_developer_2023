package br.com.tqi.jumarket.service

import br.com.tqi.jumarket.entity.Produto

interface IProdutoService {
    fun buscarTodos(): List<Produto>
    fun salvar(produto: Produto): Produto
    fun buscarPorId(id: Long): Produto
    fun atualizar(id: Long, produtoAtualizado: Produto): Produto
    fun remover(id: Long)
}