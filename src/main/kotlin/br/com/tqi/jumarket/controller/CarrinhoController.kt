package br.com.tqi.jumarket.controller

import br.com.tqi.jumarket.service.impl.CarrinhoService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/carrinho")
class CarrinhoController (
    private val carrinhoService : CarrinhoService
){
}