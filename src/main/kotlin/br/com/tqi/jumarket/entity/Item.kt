package br.com.tqi.jumarket.entity

import jakarta.persistence.*

@Entity
data class Item(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrinho")
    var carrinho: Carrinho? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    var produto: Produto,

    @Column(nullable = false)
    val quantidade: Int
)
