package com.myvaultspay.merchantmodule.data.remote.repository

import com.myvaultspay.merchantmodule.data.local.db.AppDao
import com.myvaultspay.merchantmodule.data.remote.apiservice.ApiService
import com.myvaultspay.merchantmodule.domain.model.Product
import com.myvaultspay.merchantmodule.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MainRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    appDao: AppDao
) : MainRepository {


    override suspend fun getProducts(): Flow<Response<List<Product>>> {
        return flow { emit(apiService.getProducts()) }
    }

}