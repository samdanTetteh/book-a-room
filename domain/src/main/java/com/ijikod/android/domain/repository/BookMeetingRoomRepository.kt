package com.ijikod.android.domain.repository

import com.ijikod.android.domain.entity.BookedMeetingRoom
import com.ijikod.android.domain.entity.MeetingRoom
import io.reactivex.Completable
import io.reactivex.Single

interface BookMeetingRoomRepository {

    fun bookMeetingRoom(): Single<BookedMeetingRoom>

    fun updateBookedMeetingRoomSpots(room: MeetingRoom): Int
}