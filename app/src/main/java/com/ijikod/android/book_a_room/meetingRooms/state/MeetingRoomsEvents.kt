package com.ijikod.android.book_a_room.meetingRooms.state

sealed class MeetingRoomsEvents {
    object Loading: MeetingRoomsEvents()
    data class ShowAllMeetingRooms(val state: MeetingRoomState): MeetingRoomsEvents()
    data class BookMeetingRoom(val id: Int, val spot: Int): MeetingRoomsEvents()
    data class Error (val error: Throwable): MeetingRoomsEvents()
}