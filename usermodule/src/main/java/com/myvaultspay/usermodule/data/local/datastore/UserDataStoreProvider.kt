package com.myvaultspay.usermodule.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.myvaultspay.usermodule.UserAppConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserDataStoreProvider(val context: Context) {

    //Create some keys
    companion object {
        //Create the dataStore
        private val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
            name = UserAppConstants.DataStore.DATA_STORE_NAME
        )


        val IS_LOCALIZATION_KEY =
            booleanPreferencesKey(UserAppConstants.DataStore.LOCALIZATION_KEY_NAME)

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