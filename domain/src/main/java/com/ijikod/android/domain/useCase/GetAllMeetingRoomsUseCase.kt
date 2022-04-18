package com.ijikod.android.domain.useCase

import com.ijikod.android.domain.entity.MeetingRoom
import com.ijikod.android.domain.repository.GetMeetingRoomsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class GetAllMeetingRoomsUseCase @Inject constructor(
    private val repository: GetMeetingRoomsRepository) {

    operator fun invoke(): Completable {
        return repository.loadMeetingRooms()
    }

    fun getAllMeetingRooms(): Observable<MeetingRoom> {
        return repository.getMeetingRooms()
    }
}