package com.ijikod.android.book_a_room.meetingRooms.di

import android.content.Context
import android.os.Parcel
import androidx.room.Room
import com.ijikod.android.data.common.BookARoomDatabase
import com.ijikod.android.data.rooms.dao.RoomsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule() {

    @Provides
    fun provideAllBreedsDao(bookARoomDatabase: BookARoomDatabase): RoomsDao = bookARoomDatabase.roomsDao()

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext appContext: Context): BookARoomDatabase {
        return Room.databaseBuilder(appContext, BookARoomDatabase::class.java, "meeting-rooms")
            .fallbackToDestructiveMigration()
            .build()
    }
}