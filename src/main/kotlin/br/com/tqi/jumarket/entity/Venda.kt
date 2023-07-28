package br.com.tqi.jumarket.entity

import br.com.tqi.jumarket.enum.Pagamento
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Venda(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrinho", nullable = false)
    val carrinho: Carrinho,

    @Enumerated(EnumType.STRING)
    var tipoDePagamento: Pagamento,

    @Column(nullable = false, unique = true)
    var total: BigDecimal
)
