package com.myvaultspay.usermodule.data.remote.apiservice

import com.myvaultspay.usermodule.domain.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface UserApiService {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>

}