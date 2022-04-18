package com.ijikod.android.data.rooms.api

import com.ijikod.android.data.rooms.BookRoomApiContract
import com.ijikod.android.data.rooms.GetMeetingRoomsApiContract
import io.reactivex.Single
import retrofit2.http.GET

interface RoomsRemoteApi {

    @GET("/rooms.json")
    fun getAllMeetingRooms(): Single<GetMeetingRoomsApiContract.MeetingRoomsResponse>

    @GET("/bookRoom.json")
    fun bookMeetingRoom(): Single<BookRoomApiContract.BookRoomResponse>
}