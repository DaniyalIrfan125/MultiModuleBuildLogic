package com.myvaultspay.usermodule.data.models.responsemodels.genericresponsemodels

data class UserResponseError(
    val message: String?,
    val code: Int?,
    val accessToken: String?
)
