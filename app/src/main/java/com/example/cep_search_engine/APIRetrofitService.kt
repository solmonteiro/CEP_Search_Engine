package com.example.cep_search_engine

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface APIRetrofitService {

    /* Mapeando os caminhos (path) */

    @GET("{CEP}/json/")
    fun getEnderecoByJSON(@Path("CEP") CEP : String) : Call<CEP>

}