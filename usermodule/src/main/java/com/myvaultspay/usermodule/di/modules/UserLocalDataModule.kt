package com.myvaultspay.usermodule.di.modules

import android.content.Context
import com.myvaultspay.usermodule.data.local.datastore.UserDataStoreProvider
import com.myvaultspay.usermodule.data.local.db.UserAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UserLocalDataModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        UserAppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideDao(db: UserAppDatabase) = db.appDao()


    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext appContext: Context) = UserDataStoreProvider(appContext)


}