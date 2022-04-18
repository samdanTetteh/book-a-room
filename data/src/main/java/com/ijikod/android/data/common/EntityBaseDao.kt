package com.ijikod.android.data.common

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface EntityBaseDao<in E> {
    @Insert
    fun insert(entity: E): Long

    @Insert
    fun insertAll(vararg entity: E)

    @Insert
    fun insertAll(entities: List<E>)

    @Update
    fun update(entity: E): Int

    @Delete
    fun delete(entity: E): Int
}