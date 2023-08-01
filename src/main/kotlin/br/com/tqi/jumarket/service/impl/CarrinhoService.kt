package br.com.tqi.jumarket.service.impl

import br.com.tqi.jumarket.dto.ItemDtoRequest
import br.com.tqi.jumarket.entity.Carrinho
import br.com.tqi.jumarket.entity.Item
import br.com.tqi.jumarket.exception.NotFoundException
import br.com.tqi.jumarket.repository.CarrinhoRepository
import br.com.tqi.jumarket.service.ICarrinhoService
import org.springframework.stereotype.Service

@Service
class CarrinhoService (
    private val repository: CarrinhoRepository,
    private val produtoService : ProdutoService
): ICarrinhoService {

    override fun criar(): Carrinho = repository.save(Carrinho())

    override fun buscarPorId(id: Long): Carrinho = repository.findById(id).orElseThrow {
        NotFoundException("Não existe Carrinho com id '$id'")
    }

    override fun remover(id: Long) {
        buscarPorId(id)
        repository.deleteById(id)
    }

    override fun adicionarItem(idDoCarrinho: Long, dto: ItemDtoRequest): Carrinho {
        val carrinho = buscarPorId(idDoCarrinho)
        val item = Item(
            produto = produtoService.buscarPorId(dto.idDoProduto),
            quantidade = dto.quantidade)
        carrinho.itens.add(item)
        return repository.save(carrinho)
    }
}