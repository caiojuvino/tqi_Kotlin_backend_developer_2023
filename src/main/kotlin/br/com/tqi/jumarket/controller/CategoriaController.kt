package br.com.tqi.jumarket.controller

import br.com.tqi.jumarket.dto.CategoriaRequest
import br.com.tqi.jumarket.dto.CategoriaResponse
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
    fun buscarTodos(): ResponseEntity<List<CategoriaResponse>> {
        val lista = service.buscarTodos().stream().map {
                c: Categoria -> CategoriaResponse(c)
            }.collect(Collectors.toList())

        return ResponseEntity.ok(lista)
    }

    @PostMapping
    fun salvar(@RequestBody dto: CategoriaRequest): ResponseEntity<CategoriaResponse> {
        val categoria = Mapper.paraCategoria(dto)
        val categoriaSalva = service.salvar(categoria)
        val view = CategoriaResponse(categoriaSalva)
        return ResponseEntity(view, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<CategoriaResponse> {
        val categoria = service.buscarPorId(id)
        val dto = CategoriaResponse(categoria)
        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

    @PatchMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody body: CategoriaRequest)
    : ResponseEntity<CategoriaResponse> {
        val categoria = Mapper.paraCategoria(body)
        val categoriaAtual = service.atualizar(id, categoria)
        val view = CategoriaResponse(categoriaAtual)
        return ResponseEntity(view, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun remover(@PathVariable id: Long): ResponseEntity<String> {
        val nome = service.remover(id)
        return ResponseEntity("Categoria '$nome' removida", HttpStatus.OK)
    }
}