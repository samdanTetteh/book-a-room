package com.ijikod.android.book_a_room.meetingRooms.state

sealed class MeetingRoomsEvents {
    object Loading: MeetingRoomsEvents()
    data class ShowAllMeetingRooms(val state: MeetingRoomState): MeetingRoomsEvents()
    data class BookedMeetingRoom(val state: MeetingRoomState): MeetingRoomsEvents()
    data class Error (val error: Throwable): MeetingRoomsEvents()
}