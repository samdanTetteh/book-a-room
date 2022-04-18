package com.ijikod.android.domain.repository

import com.ijikod.android.domain.entity.BookedMeetingRoom
import io.reactivex.Completable
import io.reactivex.Observable

interface BookMeetingRoomRepository {

    fun bookMeetingRoom(): Observable<BookedMeetingRoom>

    fun updateBookedMeetingRoomSpots(id: Int, spots: Int): Completable
}