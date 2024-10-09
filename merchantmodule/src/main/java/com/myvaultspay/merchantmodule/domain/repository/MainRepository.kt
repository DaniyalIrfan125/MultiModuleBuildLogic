package com.myvaultspay.merchantmodule.domain.repository


import com.myvaultspay.merchantmodule.domain.model.Product
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MainRepository {

    suspend fun getProducts():  Flow<Response<List<Product>>>

}