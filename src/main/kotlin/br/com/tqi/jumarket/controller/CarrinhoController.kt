package br.com.tqi.jumarket.controller

import br.com.tqi.jumarket.dto.CarrinhoDto
import br.com.tqi.jumarket.dto.ItemDtoRequest
import br.com.tqi.jumarket.service.impl.CarrinhoService
import br.com.tqi.jumarket.util.Mapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/carrinho")
class CarrinhoController (
    private val carrinhoService : CarrinhoService
){
    @PostMapping
    fun criar(): ResponseEntity<CarrinhoDto> {
        val carrinhoSalvo = carrinhoService.criar()
        val dtoSalvo = Mapper.paraDto(carrinhoSalvo)
        return ResponseEntity.ok(dtoSalvo)
    }
    @PostMapping("/{id}/item")
    fun adicionarItem(
        @PathVariable id: Long,
        @RequestBody itemDtoRequest: ItemDtoRequest
    ): ResponseEntity<CarrinhoDto> {
        val carrinhoSalvo = carrinhoService.adicionarItem(id, itemDtoRequest)
        val dtoSalvo = Mapper.paraDto(carrinhoSalvo)
        return ResponseEntity.ok(dtoSalvo)
    }
}