package com.myvaultspay.usermodule.domain.repository


import com.myvaultspay.usermodule.domain.model.Product
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface UserMainRepository {

    suspend fun getProducts(): Flow<Response<List<Product>>>

}