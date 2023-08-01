package br.com.tqi.jumarket.repository

import br.com.tqi.jumarket.entity.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository : JpaRepository<Categoria, Long> {
    @Query(value = "SELECT * FROM categoria WHERE LOWER(nome) = LOWER(?1)", nativeQuery = true)
    fun findByNome(nome: String): List<Categoria>
}