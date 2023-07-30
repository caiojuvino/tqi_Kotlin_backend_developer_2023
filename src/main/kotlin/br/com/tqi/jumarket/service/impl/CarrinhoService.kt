package br.com.tqi.jumarket.service.impl

import br.com.tqi.jumarket.entity.Carrinho
import br.com.tqi.jumarket.exception.BadRequestException
import br.com.tqi.jumarket.exception.NotFoundException
import br.com.tqi.jumarket.repository.CarrinhoRepository
import br.com.tqi.jumarket.service.ICarrinhoService
import org.springframework.stereotype.Service

@Service
class CarrinhoService (
    private val repository: CarrinhoRepository
): ICarrinhoService {

    override fun buscarTodos(): List<Carrinho> = repository.findAll()

    override fun salvar(carrinho: Carrinho): Carrinho = repository.save(carrinho)

    override fun buscarPorId(id: Long): Carrinho = repository.findById(id).orElseThrow {
        NotFoundException("Não existe Carrinho com id '$id'")
    }

    override fun remover(id: Long) {
        buscarPorId(id)
        repository.deleteById(id)
    }
}