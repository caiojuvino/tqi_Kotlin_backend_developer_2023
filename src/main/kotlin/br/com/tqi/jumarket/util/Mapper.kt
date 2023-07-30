package br.com.tqi.jumarket.util

import br.com.tqi.jumarket.dto.CategoriaDto
import br.com.tqi.jumarket.dto.ProdutoDto
import br.com.tqi.jumarket.entity.Categoria
import br.com.tqi.jumarket.entity.Produto

class Mapper {
    companion object {
        fun paraCategoria(dto: CategoriaDto): Categoria =
            dto.run { Categoria(this.id, this.nome) }

        fun paraProduto(dto: ProdutoDto): Produto =
            dto.run { Produto(
                this.id,
                this.categoria,
                this.nome,
                this.unidadeDeMedida,
                this.preco
            ) }

        fun paraDto(categoria: Categoria): CategoriaDto =
            categoria.run { CategoriaDto(this.id, this.nome) }

        fun paraDto(produto: Produto): ProdutoDto =
            produto.run { ProdutoDto(
                this.id,
                this.categoria,
                this.nome,
                this.unidadeDeMedida,
                this.preco
            ) }
    }
}