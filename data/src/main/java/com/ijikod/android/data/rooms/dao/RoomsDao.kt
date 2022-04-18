package com.ijikod.android.data.rooms.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ijikod.android.data.common.EntityBaseDao
import com.ijikod.android.data.rooms.entities.RoomEntity
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
abstract class RoomsDao: EntityBaseDao<RoomEntity> {

    @Transaction
    @Query("SELECT * FROM rooms")
    abstract fun getAllRooms(): Observable<List<RoomEntity>>


    @Query("DELETE FROM rooms")
    abstract fun deleteAllRooms()

    @Query("UPDATE rooms SET spots = :spots WHERE id = :id")
    abstract fun updateAvailableRoomSpots(id:Int, spots: Int): Completable

    fun deleteAndInsert(roomsEntity: List<RoomEntity>) {
        deleteAllRooms()
        insertAll(roomsEntity)
    }
}