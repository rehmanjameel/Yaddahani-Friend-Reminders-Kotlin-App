package com.codebase.yaddahani.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codebase.yaddahani.models.FriendsRemindersListModel

@Database(entities = [FriendsRemindersListModel::class], version = 1, exportSchema = false)
abstract class ReminderDataBase : RoomDatabase() {

    abstract fun reminderDao() : ReminderDao

    companion object {

        @Volatile
        private var INSTANCE: ReminderDataBase? = null

        fun getDataBase(context: Context) : ReminderDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ReminderDataBase::class.java,
                    "reminderDataBase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}