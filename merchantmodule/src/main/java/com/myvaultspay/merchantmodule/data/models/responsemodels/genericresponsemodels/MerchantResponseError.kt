package com.myvaultspay.merchantmodule.data.models.responsemodels.genericresponsemodels

data class MerchantResponseError(
    val message: String?,
    val code: Int?,
    val accessToken: String?
)
