package br.com.tqi.jumarket.controller

import br.com.tqi.jumarket.service.impl.VendaService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/venda")
class VendaController (
    private val vendaService : VendaService
){
}