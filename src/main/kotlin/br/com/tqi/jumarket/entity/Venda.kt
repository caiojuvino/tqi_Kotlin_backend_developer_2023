package br.com.tqi.jumarket.entity

import br.com.tqi.jumarket.enum.Pagamento
import java.math.BigDecimal

data class Venda(
    var id: Long? = null,
    var tipoDePagamento: Pagamento,
    var total: BigDecimal,
    val carrinhos: List<Carrinho>
)
