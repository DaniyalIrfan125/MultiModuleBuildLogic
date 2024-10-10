package com.myvaultspay.usermodule.data.remote.repository

import com.myvaultspay.usermodule.data.local.db.AppDao
import com.myvaultspay.usermodule.data.remote.apiservice.UserApiService
import com.myvaultspay.usermodule.domain.model.Product
import com.myvaultspay.usermodule.domain.repository.UserMainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class UserMainRepositoryImp @Inject constructor(
    private val userApiService: UserApiService,
    appDao: AppDao
) : UserMainRepository {


    override suspend fun getProducts(): Flow<Response<List<Product>>> {
        return flow { emit(userApiService.getProducts()) }
    }

}