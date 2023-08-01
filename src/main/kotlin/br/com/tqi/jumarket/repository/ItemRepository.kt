package br.com.tqi.jumarket.repository


import br.com.tqi.jumarket.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<Item, Long>