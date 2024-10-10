package com.myvaultspay.merchantmodule.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myvaultspay.merchantmodule.MerchantAppConstants
import com.myvaultspay.merchantmodule.data.models.responsemodels.PostsResponseItem


@Database(entities = [PostsResponseItem::class], version = 1, exportSchema = false)
abstract class MerchantAppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object {
        @Volatile
        private var instance: MerchantAppDatabase? = null

        fun getDatabase(context: Context): MerchantAppDatabase =
            instance
                ?: synchronized(this) {
                    instance
                        ?: buildDatabase(
                            context
                        )
                            .also { instance = it }
                }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(
                appContext,
                MerchantAppDatabase::class.java,
                MerchantAppConstants.DbConfiguration.DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }

}