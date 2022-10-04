package com.example.uana.api

import com.example.uana.model.Categoria
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>>{
        return RetrofitInstance.api.listCategoria()
    }

}