package br.com.tqi.jumarket.util

import br.com.tqi.jumarket.dto.CarrinhoDto
import br.com.tqi.jumarket.dto.CategoriaRequest
import br.com.tqi.jumarket.dto.ProdutoDto
import br.com.tqi.jumarket.entity.Carrinho
import br.com.tqi.jumarket.entity.Categoria
import br.com.tqi.jumarket.entity.Produto

class Mapper {
    companion object {
        fun paraCategoria(dto: CategoriaRequest): Categoria =
            Categoria(nome = dto.nome.lowercase())

        fun paraProduto(dto: ProdutoDto): Produto =
            dto.run { Produto(
                this.id,
                this.categoria,
                this.nome,
                this.unidadeDeMedida,
                this.preco
            ) }

        fun paraCarrinho(dto: CarrinhoDto): Carrinho =
            dto.run { Carrinho(
                this.id,
                this.itens
            ) }

        fun paraDto(produto: Produto): ProdutoDto =
            produto.run { ProdutoDto(
                this.id,
                this.categoria,
                this.nome,
                this.unidadeDeMedida,
                this.preco
            ) }

        fun paraDto(carrinho: Carrinho): CarrinhoDto =
            carrinho.run { CarrinhoDto(
                this.id,
                this.itens
            ) }
    }
}