package br.com.tqi.jumarket.service

import br.com.tqi.jumarket.entity.Categoria

interface ICategoriaService {
    fun buscarTodos(): List<Categoria>
    fun salvar(categoria: Categoria): Categoria
    fun buscarPorId(id: Long): Categoria
    fun atualizar(id: Long, categoriaAtualizada: Categoria) : Categoria
    fun remover(id: Long): String
}