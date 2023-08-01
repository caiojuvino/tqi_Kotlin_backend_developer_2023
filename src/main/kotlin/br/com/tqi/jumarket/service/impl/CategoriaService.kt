package br.com.tqi.jumarket.service.impl

import br.com.tqi.jumarket.dto.CategoriaRequest
import br.com.tqi.jumarket.entity.Categoria
import br.com.tqi.jumarket.exception.BadRequestException
import br.com.tqi.jumarket.exception.NotFoundException
import br.com.tqi.jumarket.repository.CategoriaRepository
import br.com.tqi.jumarket.service.ICategoriaService
import org.springframework.stereotype.Service

@Service
class CategoriaService (
    private val repository: CategoriaRepository
): ICategoriaService {

    override fun buscarTodos(): List<Categoria> = repository.findAll()

    override fun salvar(categoria: Categoria): Categoria {
        try {
            return repository.save(categoria)
        } catch (e: Exception) {
            throw BadRequestException(
                "Já existe uma Categoria com nome '${categoria.nome.lowercase()}'")
        }
    }

    override fun buscarPorId(id: Long): Categoria = repository.findById(id).orElseThrow {
        NotFoundException("Não existe Categoria com id '$id'")
    }

    override fun buscarPorNome(nome: String): Categoria {
        try {
            return repository.findByNome(nome)[0]
        } catch (e: Exception) {
            throw BadRequestException("Não existe Categoria com nome '$nome'")
        }
    }

    override fun atualizar(id: Long, categoria: Categoria) : Categoria {
        buscarPorId(id)
        val novaCategoria = Categoria(
            id = id,
            nome = categoria.nome
        )
        repository.save(novaCategoria)
        return novaCategoria
    }

    override fun remover(id: Long): String {
        val buscada = buscarPorId(id)
        val nome = buscada.nome
        try {
            repository.deleteById(id)
            return nome
        } catch (e: Exception) {
            throw BadRequestException("Ainda existem produtos cadastrados na Categoria '${nome}'")
        }
    }
}