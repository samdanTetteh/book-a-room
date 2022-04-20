package com.ijikod.android.data.rooms

import com.ijikod.android.data.rooms.api.RoomsRemoteApi
import com.ijikod.android.data.rooms.dao.RoomsDao
import com.ijikod.android.data.rooms.entities.RoomEntity
import com.ijikod.android.domain.entity.BookedMeetingRoom
import com.ijikod.android.domain.entity.MeetingRoom
import com.ijikod.android.domain.repository.BookMeetingRoomRepository
import io.reactivex.Single
import javax.inject.Inject

class BookingMeetingRoomImpl @Inject constructor(
    private val remote: RoomsRemoteApi,
    private val local: RoomsDao
): BookMeetingRoomRepository {

    override fun bookMeetingRoom(): Single<BookedMeetingRoom> {
        return remote.bookMeetingRoom().map {
            BookedMeetingRoom(
                success = it.success
            )
        }
    }

    override fun updateBookedMeetingRoomSpots(room: MeetingRoom): Int {
        return local.update(room.toEntity())
    }
}