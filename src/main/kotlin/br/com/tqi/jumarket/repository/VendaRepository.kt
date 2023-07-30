package br.com.tqi.jumarket.repository

import br.com.tqi.jumarket.entity.Venda
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VendaRepository : JpaRepository<Venda, Long>