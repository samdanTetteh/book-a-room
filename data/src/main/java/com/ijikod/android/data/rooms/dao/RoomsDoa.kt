package com.ijikod.android.data.rooms.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ijikod.android.data.common.EntityBaseDao
import com.ijikod.android.data.rooms.entities.RoomEntity
import io.reactivex.Observable

@Dao
abstract class RoomsDoa: EntityBaseDao<RoomEntity> {

    @Transaction
    @Query("SELECT * FROM rooms")
    abstract fun getAllBreeds(): Observable<RoomEntity>


    @Query("DELETE FROM rooms")
    abstract fun deleteAllRooms()

    @Query("INSERT INTO rooms VALUES (:spot)")
    abstract fun insertAvailableRoomSpots(spot: Int)

    fun deleteAndInsert(roomsEntity: RoomEntity) {
        deleteAllRooms()
        insertAll(roomsEntity)
    }
}