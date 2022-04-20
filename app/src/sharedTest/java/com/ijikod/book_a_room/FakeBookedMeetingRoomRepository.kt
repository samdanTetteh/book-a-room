package com.ijikod.book_a_room

import com.ijikod.android.domain.entity.BookedMeetingRoom
import com.ijikod.android.domain.entity.MeetingRoom
import com.ijikod.android.domain.repository.BookMeetingRoomRepository
import io.reactivex.Single
import javax.inject.Inject

class FakeBookedMeetingRoomRepository @Inject constructor(): BookMeetingRoomRepository {

    override fun bookMeetingRoom(): Single<BookedMeetingRoom> {
        return Single.just(Fakes.getFakeBookedMeetingRoom())
    }

    override fun updateBookedMeetingRoomSpots(room: MeetingRoom): Int {
        return (0..100).random()
    }

}