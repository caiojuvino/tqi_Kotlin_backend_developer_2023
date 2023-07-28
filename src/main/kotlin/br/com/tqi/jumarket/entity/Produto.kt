package br.com.tqi.jumarket.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Produto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    var categoria: Categoria,

    @Column(nullable = false, unique = true)
    var nome: String,

    var unidadeDeMedida: String,

    @Column(nullable = false)
    var preco: BigDecimal
)
