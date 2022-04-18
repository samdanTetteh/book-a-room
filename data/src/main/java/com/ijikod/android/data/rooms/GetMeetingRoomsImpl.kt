package com.ijikod.android.data.rooms

import com.ijikod.android.data.rooms.api.RoomsRemoteApi
import com.ijikod.android.data.rooms.dao.RoomsDao
import com.ijikod.android.domain.entity.MeetingRoom
import com.ijikod.android.domain.repository.GetMeetingRoomsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class GetMeetingRoomsImpl @Inject constructor(private val remote: RoomsRemoteApi,
                                              private val local: RoomsDao
): GetMeetingRoomsRepository {

    override fun loadMeetingRooms(): Completable {
        return remote.getAllMeetingRooms()
            .toObservable()
            .doAfterNext {
                local.deleteAndInsert(it.toEntity())
            }.ignoreElements()
    }

    override fun getMeetingRooms(): Observable<List<MeetingRoom>> {
        return local.getAllRooms().map { it.toDomain() }
    }


}