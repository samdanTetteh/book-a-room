package com.ijikod.android.domain.repository

import com.ijikod.android.domain.entity.BookedMeetingRoom
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface BookMeetingRoomRepository {

    fun bookMeetingRoom(): Single<BookedMeetingRoom>

    fun updateBookedMeetingRoomSpots(id: Int, spots: Int): Completable
}