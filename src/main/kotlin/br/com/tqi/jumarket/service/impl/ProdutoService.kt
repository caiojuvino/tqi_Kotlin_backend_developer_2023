package br.com.tqi.jumarket.service.impl

import br.com.tqi.jumarket.entity.Produto
import br.com.tqi.jumarket.exception.BadRequestException
import br.com.tqi.jumarket.exception.NotFoundException
import br.com.tqi.jumarket.repository.ProdutoRepository
import br.com.tqi.jumarket.service.IProdutoService
import org.springframework.stereotype.Service

@Service
class ProdutoService (
    private val repository: ProdutoRepository,
    private val categoriaService: CategoriaService
): IProdutoService {

    override fun buscarTudo(): List<Produto> = repository.findAll()

    override fun salvar(produto: Produto): Produto {
        produto.categoria = categoriaService.buscarPorNome(produto.categoria.nome)
        return repository.save(produto)
    }

    override fun buscarPorId(id: Long): Produto = repository.findById(id).orElseThrow {
        NotFoundException("Não existe Produto com id '$id'")
    }

    override fun buscarPorCategoria(nome: String): List<Produto> {
        val categoria = categoriaService.buscarPorNome(nome)
        return repository.findByCategoria(categoria.id!!)
    }

    override fun atualizar(id: Long, produtoAtualizado: Produto) : Produto {
        val produtoAntigo = buscarPorId(id)
        produtoAtualizado.id = produtoAntigo.id
        produtoAtualizado.categoria = categoriaService.buscarPorNome(produtoAtualizado.categoria.nome)
        try {
            repository.save(produtoAtualizado)
        } catch (e: Exception) {
            throw BadRequestException(
                "É preciso informar nome, categoria, unidade e preço'")
        }
        return produtoAtualizado
    }

    override fun remover(id: Long) {
        buscarPorId(id)
        repository.deleteById(id)
    }
}