package com.myvaultspay.merchantmodule.data.models.responsemodels.genericresponsemodels

data class ResponseError(
    val message: String?,
    val code: Int?,
    val accessToken: String?
)
