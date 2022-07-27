package com.example.cep_search_engine

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInitializer {

    /* Consumir JSON da API e converter (parser) */
    val retrofitJSON = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Implementar a interface
    fun apiRetrofitServiceJSON(): APIRetrofitService {
        return retrofitJSON.create(APIRetrofitService::class.java)
    }
}