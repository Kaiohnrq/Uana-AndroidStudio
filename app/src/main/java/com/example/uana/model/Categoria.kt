package com.example.uana.model

data class Categoria(
    var id: Long,
    var descricao: String?,
    var produtos: List<Produto>?
) {

    override fun toString(): String {
        return descricao!!
    }

}