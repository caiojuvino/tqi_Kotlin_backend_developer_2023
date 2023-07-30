package br.com.tqi.jumarket.repository

import br.com.tqi.jumarket.entity.Carrinho
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarrinhoRepository : JpaRepository<Carrinho, Long>