package com.ijikod.android.data.rooms

import com.ijikod.android.data.rooms.api.RoomsRemoteApi
import com.ijikod.android.data.rooms.dao.RoomsDao
import com.ijikod.android.domain.entity.BookedMeetingRoom
import com.ijikod.android.domain.repository.BookMeetingRoomRepository
import io.reactivex.Completable
import io.reactivex.Single

class BookingMeetingRoomImpl(
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

    override fun updateBookedMeetingRoomSpots(id: Int, spots: Int): Completable {
        return local.updateAvailableRoomSpots(id, spots)
    }
}