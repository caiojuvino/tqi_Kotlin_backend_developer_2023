package br.com.tqi.jumarket.entity

import jakarta.persistence.*

@Entity
data class Categoria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(nullable = false, unique = true)
    var nome: String
)
