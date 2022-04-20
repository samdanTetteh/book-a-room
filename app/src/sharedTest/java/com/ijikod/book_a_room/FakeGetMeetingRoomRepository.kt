package com.ijikod.book_a_room

import com.ijikod.android.domain.entity.MeetingRoom
import com.ijikod.android.domain.repository.GetMeetingRoomsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class FakeGetMeetingRoomRepository @Inject constructor(): GetMeetingRoomsRepository {
    override fun loadMeetingRooms(): Completable {
        return Completable.complete()
    }

    override fun getMeetingRooms(): Observable<List<MeetingRoom>> {
        return  Observable.just(listOf(Fakes.getFakeMeetingRooms()))
    }
}