package br.com.tqi.jumarket.service.impl

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
                "Já existe uma Categoria com nome '${categoria.nome}'")
        }
    }

    override fun buscarPorId(id: Long): Categoria = repository.findById(id).orElseThrow {
        NotFoundException("Não existe Categoria com id '$id'")
    }

    override fun atualizar(id: Long, categoriaAtualizada: Categoria) : Categoria {
        val categoriaAntiga = buscarPorId(id)
        categoriaAtualizada.id = categoriaAntiga.id
        repository.save(categoriaAtualizada)
        return categoriaAtualizada
    }

    override fun remover(id: Long): String {
        val buscada = buscarPorId(id)
        repository.deleteById(id)
        return buscada.nome
    }
}