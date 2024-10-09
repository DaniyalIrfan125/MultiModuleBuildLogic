package com.myvaultspay.merchantmodule.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.myvaultspay.merchantmodule.AppConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DataStoreProvider(val context: Context) {

    //Create some keys
    companion object {
        //Create the dataStore
        private val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
            name = AppConstants.DataStore.DATA_STORE_NAME
        )


        val IS_LOCALIZATION_KEY =
            booleanPreferencesKey(AppConstants.DataStore.LOCALIZATION_KEY_NAME)

    }


    //Store data
    suspend fun storeLocalizationData(isLocalizationKey: Boolean) {
        context.userPreferencesDataStore.edit {
            it[IS_LOCALIZATION_KEY] = isLocalizationKey
        }
    }


    //fetching Localization flow
    val localizationFlow: Flow<Boolean> = context.userPreferencesDataStore.data.map {
        it[IS_LOCALIZATION_KEY] ?: false
    }


}