package br.com.tqi.jumarket.service

import br.com.tqi.jumarket.entity.Venda

interface IVendaService {
    fun buscarTodos(venda: Venda): List<Venda>
    fun buscarPorId(id: Long): Venda
    fun salvar(venda: Venda): Venda
    fun remover(id: Long)
}