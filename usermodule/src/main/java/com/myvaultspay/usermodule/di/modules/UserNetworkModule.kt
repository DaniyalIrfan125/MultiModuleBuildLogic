package com.myvaultspay.usermodule.di.modules

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.myvaultspay.usermodule.UserAppConstants
import com.myvaultspay.usermodule.data.local.db.AppDao
import com.myvaultspay.usermodule.data.remote.apiservice.UserApiService
import com.myvaultspay.usermodule.data.remote.repository.UserMainRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UserNetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        chuckInterceptor: ChuckerInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(chuckInterceptor)
            .addInterceptor(httpLoggingInterceptor).build()


    @Provides
    @Singleton
    fun provideApiService(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): UserApiService {
        return Retrofit.Builder().baseUrl(UserAppConstants.ApiConfiguration.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient).build().create(UserApiService::class.java)
    }


    @Provides
    fun provideGson(): Gson = GsonBuilder().create()


    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
    }


    @Singleton
    @Provides
    fun provideChuckerInterceptor(
        @ApplicationContext context: Context,
        chuckerCollector: ChuckerCollector
    ): ChuckerInterceptor =
        ChuckerInterceptor.Builder(context).collector(chuckerCollector)
            .maxContentLength(UserAppConstants.Chucker.CONTENT_LENGTH)
            .redactHeaders("Content-Type", "application/json").alwaysReadResponseBody(true).build()


    @Singleton
    @Provides
    fun provideChuckerCollector(@ApplicationContext context: Context): ChuckerCollector =
        ChuckerCollector(
            context = context,
            // Toggles visibility of the push notification
            showNotification = true,
            // Allows to customize the retention period of collected data
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )


    @Singleton
    @Provides
    fun provideRepository(
        userApiService: UserApiService,
        appDao: AppDao
    ) =
        UserMainRepositoryImp(userApiService, appDao)

}