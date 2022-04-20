package com.ijikod.android.data.rooms.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ijikod.android.data.common.EntityBaseDao
import com.ijikod.android.data.rooms.entities.RoomEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
abstract class RoomsDao: EntityBaseDao<RoomEntity> {

    @Transaction
    @Query("SELECT * FROM rooms")
    abstract fun getAllRooms(): Observable<List<RoomEntity>>


    @Query("DELETE FROM rooms")
    abstract fun deleteAllRooms()

    fun deleteAndInsert(roomsEntity: List<RoomEntity>) {
        deleteAllRooms()
        insertAll(roomsEntity)
    }
}