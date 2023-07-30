package br.com.tqi.jumarket.repository

import br.com.tqi.jumarket.entity.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository : JpaRepository<Produto, Long>