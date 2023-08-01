package br.com.tqi.jumarket.repository

import br.com.tqi.jumarket.entity.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository : JpaRepository<Produto, Long> {
    @Query(value = "SELECT * FROM produto WHERE id_categoria = ?1", nativeQuery = true)
    fun findByCategoria(id: Long): List<Produto>
}