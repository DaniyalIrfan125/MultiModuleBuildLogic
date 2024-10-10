package com.myvaultspay.usermodule.data.remote

import com.myvaultspay.usermodule.data.models.responsemodels.genericresponsemodels.UserResponseError


sealed class Resource<out T> {

    class Loading<T> : Resource<T>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(
        val status: Status,
        val data: T?,
        val message: String?,
        val userResponseError: UserResponseError?
    ) : Resource<T>()

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }


    companion object {

        /**
         * Returns [State.Loading] instance.
         */
        fun <T> loading() = Loading<T>()

        /**
         * Returns [State.Success] instance.
         * @param data Data to emit with status.
         */
        fun <T> success(data: T) =
            Success(data)

        /**
         * Returns [State.Error] instance.
         * @param message Description of failure.
         */
        fun <T> error(message: String, data: T? = null, userResponseError: UserResponseError?) =
            Error<T>(Status.ERROR, data, message, userResponseError)

    }

    fun abd(value: Int): String {
        return "dance for me"
    }

    val abc: (Int) -> Int = { a ->
        a * 8
    }

    fun ok() {
        haha("danu") {
            abd(1)
        }
    }

    fun haha(variableName: String, myname: (Int) -> String) {

    }


}