package br.com.tqi.jumarket.repository

import br.com.tqi.jumarket.entity.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository : JpaRepository<Categoria, Long>