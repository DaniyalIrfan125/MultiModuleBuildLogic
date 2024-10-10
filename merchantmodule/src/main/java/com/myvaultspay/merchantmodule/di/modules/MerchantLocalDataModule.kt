package com.myvaultspay.merchantmodule.di.modules

import android.content.Context
import com.myvaultspay.merchantmodule.data.local.datastore.MerchantDataStoreProvider
import com.myvaultspay.merchantmodule.data.local.db.MerchantAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class MerchantLocalDataModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        MerchantAppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideDao(db: MerchantAppDatabase) = db.appDao()


    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext appContext: Context) = MerchantDataStoreProvider(appContext)


}