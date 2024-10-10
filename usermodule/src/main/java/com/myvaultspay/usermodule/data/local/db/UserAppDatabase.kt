package com.myvaultspay.usermodule.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myvaultspay.usermodule.UserAppConstants
import com.myvaultspay.usermodule.data.models.responsemodels.PostsResponseItem


@Database(entities = [PostsResponseItem::class], version = 1, exportSchema = false)
abstract class UserAppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object {
        @Volatile
        private var instance: UserAppDatabase? = null

        fun getDatabase(context: Context): UserAppDatabase =
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
                UserAppDatabase::class.java,
                UserAppConstants.DbConfiguration.DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }

}