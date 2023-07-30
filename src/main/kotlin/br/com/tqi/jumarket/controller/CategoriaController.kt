package br.com.tqi.jumarket.controller

import br.com.tqi.jumarket.dto.CategoriaDto
import br.com.tqi.jumarket.entity.Categoria
import br.com.tqi.jumarket.service.impl.CategoriaService
import br.com.tqi.jumarket.util.Mapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/categoria")
class CategoriaController (
    private val service: CategoriaService
){
    @GetMapping
    fun buscarTodos(): ResponseEntity<List<CategoriaDto>> {
        val lista = service.buscarTodos().stream().map { c: Categoria -> Mapper.paraDto(c) }
            .collect(Collectors.toList())
        return ResponseEntity.ok(lista)
    }

    @PostMapping
    fun salvar(@RequestBody dto: CategoriaDto): ResponseEntity<CategoriaDto> {
        val categoria = Categoria(nome = dto.nome)
        val categoriaSalva = service.salvar(categoria)
        val dtoSalvo = Mapper.paraDto(categoriaSalva)
        return ResponseEntity(dtoSalvo, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<CategoriaDto> {
        val categoria = service.buscarPorId(id)
        val dto = Mapper.paraDto(categoria)
        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

    @PatchMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody dto: CategoriaDto)
    : ResponseEntity<CategoriaDto> {

        dto.id = id
        val categoria = Mapper.paraCategoria(dto)
        val categoriaAtual = service.atualizar(id, categoria)
        val dtoAtual = Mapper.paraDto(categoriaAtual)
        return ResponseEntity(dtoAtual, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun remover(@PathVariable id: Long): ResponseEntity<String> {
        var nome = service.remover(id)
        return ResponseEntity("Categoria '$nome' removida", HttpStatus.OK)
    }
}