package com.ijikod.android.domain.useCase

import com.ijikod.android.domain.entity.BookedMeetingRoom
import com.ijikod.android.domain.repository.BookMeetingRoomRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class BookMeetingRoomUseCase @Inject constructor(private val repository: BookMeetingRoomRepository) {

    operator fun invoke(): Observable<BookedMeetingRoom> {
        return repository.bookMeetingRoom()
    }

    fun updateMeetingRoomSpots(id: Int, spots: Int): Completable {
        return repository.updateBookedMeetingRoomSpots(id, spots)
    }
}