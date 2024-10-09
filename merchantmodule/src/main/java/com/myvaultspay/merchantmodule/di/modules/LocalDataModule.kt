package com.myvaultspay.merchantmodule.di.modules

import android.content.Context
import com.myvaultspay.merchantmodule.data.local.datastore.DataStoreProvider
import com.myvaultspay.merchantmodule.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideDao(db: AppDatabase) = db.appDao()


    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext appContext: Context) = DataStoreProvider(appContext)


}