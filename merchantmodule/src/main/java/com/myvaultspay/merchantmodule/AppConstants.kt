package com.myvaultspay.merchantmodule

import androidx.annotation.LongDef
import androidx.annotation.StringDef

object AppConstants {

    @StringDef(ApiParams.ACCESS_TOKEN, ApiParams.API_ID, ApiParams.API_SECRET)
    annotation class ApiParams {
        companion object {
            const val ACCESS_TOKEN = "accessToken"
            const val API_ID = "apiId"
            const val API_SECRET = "apiSecret"
        }
    }

    @StringDef(ApiConfiguration.BASE_URL)
    annotation class ApiConfiguration {
        companion object {
            const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        }
    }


    @StringDef(DbConfiguration.DB_NAME)
    annotation class DbConfiguration {
        companion object {
            const val DB_NAME = "ComposeBaseProject"
        }
    }


    @LongDef(Chucker.CONTENT_LENGTH)
    annotation class Chucker {
        companion object {
            const val CONTENT_LENGTH = 250_000L
        }
    }


    @StringDef(
        DataStore.DATA_STORE_NAME,
        DataStore.LOCALIZATION_KEY_NAME
    )
    annotation class DataStore {
        companion object {
            const val DATA_STORE_NAME = "VaultsPay"
            const val LOCALIZATION_KEY_NAME = "app_language"
        }
    }

}