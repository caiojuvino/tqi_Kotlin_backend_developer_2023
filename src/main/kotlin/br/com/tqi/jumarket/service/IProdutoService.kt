package br.com.tqi.jumarket.service

import br.com.tqi.jumarket.entity.Produto

interface IProdutoService {
    fun buscarTudo(): List<Produto>
    fun salvar(produto: Produto): Produto
    fun buscarPorId(id: Long): Produto
    fun buscarPorCategoria(nome: String): List<Produto>
    fun atualizar(id: Long, produtoAtualizado: Produto): Produto
    fun remover(id: Long)
}