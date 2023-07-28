package br.com.tqi.jumarket.entity

import jakarta.persistence.*

@Entity
data class Carrinho(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
