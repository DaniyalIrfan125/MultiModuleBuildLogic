package com.myvaultspay.merchantmodule.data.remote.repository

import com.myvaultspay.merchantmodule.data.local.db.AppDao
import com.myvaultspay.merchantmodule.data.remote.apiservice.MerchantApiService
import com.myvaultspay.merchantmodule.domain.model.Product
import com.myvaultspay.merchantmodule.domain.repository.MerchantMainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MerchantMerchantMainRepositoryImp @Inject constructor(
    private val merchantApiService: MerchantApiService,
    appDao: AppDao
) : MerchantMainRepository {


    override suspend fun getProducts(): Flow<Response<List<Product>>> {
        return flow { emit(merchantApiService.getProducts()) }
    }

}