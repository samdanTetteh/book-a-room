package com.ijikod.android.book_a_room.meetingRooms.state

import com.ijikod.android.book_a_room.meetingRooms.common.AsyncResult
import com.ijikod.android.domain.entity.BookedMeetingRoom
import com.ijikod.android.domain.entity.MeetingRoom

data class MeetingRoomState(
    val allMeetingRooms: AsyncResult<List<MeetingRoom>>? = null,
    val bookedMeetingRoom: AsyncResult<BookedMeetingRoom>? = null){

    val isLoading: Boolean
        get() = allMeetingRooms is AsyncResult.Loading

    val getAllMeetingRooms: List<MeetingRoom>?
        get() = if (allMeetingRooms is AsyncResult.Success && allMeetingRooms.data != null) {
            allMeetingRooms.data
        } else null
}
