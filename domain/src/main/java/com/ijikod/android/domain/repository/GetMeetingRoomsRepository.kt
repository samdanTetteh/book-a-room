package com.ijikod.android.domain.repository

import com.ijikod.android.domain.entity.MeetingRoom
import io.reactivex.Completable
import io.reactivex.Observable

interface GetMeetingRoomsRepository {

    fun loadMeetingRooms(): Completable

    fun getMeetingRooms(): Observable<List<MeetingRoom>>
}