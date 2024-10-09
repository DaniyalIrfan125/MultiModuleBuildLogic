package com.myvaultspay.merchantmodule.data.remote.apiservice

import com.myvaultspay.merchantmodule.domain.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>

}