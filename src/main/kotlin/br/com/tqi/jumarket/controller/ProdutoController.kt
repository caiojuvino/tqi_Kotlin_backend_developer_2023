package br.com.tqi.jumarket.controller

import br.com.tqi.jumarket.dto.ProdutoDto
import br.com.tqi.jumarket.entity.Produto
import br.com.tqi.jumarket.service.impl.ProdutoService
import br.com.tqi.jumarket.util.Mapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/produto")
class ProdutoController (
    private val service : ProdutoService
){
    @GetMapping
    fun buscarTodos(): ResponseEntity<List<ProdutoDto>> {
        val lista = service.buscarTodos().stream().map { p: Produto -> Mapper.paraDto(p) }
            .collect(Collectors.toList())
        return ResponseEntity.ok(lista)
    }

    @PostMapping
    fun salvar(@RequestBody dto: ProdutoDto): ResponseEntity<ProdutoDto> {
        val produto = Produto(
            nome = dto.nome,
            categoria = dto.categoria,
            unidadeDeMedida = dto.unidadeDeMedida,
            preco = dto.preco
        )
        val produtoSalvo = service.salvar(produto)
        val dtoSalvo = Mapper.paraDto(produtoSalvo)
        return ResponseEntity(dtoSalvo, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<ProdutoDto> {
        val produto = service.buscarPorId(id)
        val dto = Mapper.paraDto(produto)
        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

    @PatchMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody dto: ProdutoDto)
            : ResponseEntity<ProdutoDto> {

        dto.id = id
        val produto = Mapper.paraProduto(dto)
        val produtoAtual = service.atualizar(id, produto)
        val dtoAtual = Mapper.paraDto(produtoAtual)
        return ResponseEntity(dtoAtual, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun remover(@PathVariable id: Long): ResponseEntity<String> {
        service.remover(id)
        return ResponseEntity("Produto com id '$id' removido", HttpStatus.OK)
    }
}