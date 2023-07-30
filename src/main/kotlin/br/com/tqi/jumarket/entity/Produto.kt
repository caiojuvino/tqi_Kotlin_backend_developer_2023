package br.com.tqi.jumarket.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Produto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY,
        cascade = [CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE])
    @JoinColumn(name = "id_categoria")
    var categoria: Categoria,

    @Column(nullable = false)
    var nome: String,

    var unidadeDeMedida: String,

    @Column(nullable = false)
    var preco: BigDecimal
)
