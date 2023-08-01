package br.com.tqi.jumarket.entity

import jakarta.persistence.*

@Entity
data class Carrinho(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    val itens: MutableList<Item> = mutableListOf()
)
