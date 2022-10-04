package com.example.uana.api

import com.example.uana.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>
}