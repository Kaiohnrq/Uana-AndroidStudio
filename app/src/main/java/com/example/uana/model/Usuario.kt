package com.example.uana.model

import java.util.*

data class Usuario(
    val id: Long,
    val cpf: Int,
    val nome: String,
    val nascimento: String,
    val genero: Boolean,
    val email: String,
    val endereco: String,
    val senha: String,
    val telefone: Int
        ){

    var favoritos = 0
}