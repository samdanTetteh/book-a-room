package com.ijikod.android.domain.useCase

import com.ijikod.android.domain.entity.BookedMeetingRoom
import com.ijikod.android.domain.entity.MeetingRoom
import com.ijikod.android.domain.repository.BookMeetingRoomRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class BookMeetingRoomUseCase @Inject constructor(private val repository: BookMeetingRoomRepository) {

    operator fun invoke(): Single<BookedMeetingRoom> {
        return repository.bookMeetingRoom()
    }

    fun updateMeetingRoomSpots(room: MeetingRoom): Int {
        return repository.updateBookedMeetingRoomSpots(room)
    }
}