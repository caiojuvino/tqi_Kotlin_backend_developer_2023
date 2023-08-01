package br.com.tqi.jumarket.entity

import jakarta.persistence.*

@Entity
data class Categoria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val nome: String = ""
)
