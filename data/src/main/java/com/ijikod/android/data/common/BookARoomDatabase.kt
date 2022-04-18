package com.ijikod.android.data.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ijikod.android.data.rooms.dao.RoomsDoa
import com.ijikod.android.data.rooms.entities.RoomEntity

@Database(entities = [RoomEntity::class], version = 1)
abstract class BookARoomDatabase: RoomDatabase() {
    abstract fun roomsDao(): RoomsDoa
}