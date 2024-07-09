package com.example.login.model

import java.time.LocalDate

data class Viagem(
    val destino: String = "",
    // 0 = Lazer / 1 = Negócios
    val tipo: Int = 0,
    val dataIni: LocalDate = LocalDate.now(),
    val dataFim: LocalDate = LocalDate.now(),
    val orcamento: Double = 0.0
) {

}