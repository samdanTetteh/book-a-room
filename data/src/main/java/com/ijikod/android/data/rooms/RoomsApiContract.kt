package com.ijikod.android.data.rooms

import com.google.gson.annotations.SerializedName

interface RoomsApiContract {

    data class MeetingRoomsResponse(
        @SerializedName("rooms") val rooms: List<Rooms>
    )

    data class Rooms(
        @SerializedName("name") val name: String,
        @SerializedName("spots") val spots: Int,
        @SerializedName("image") val thumbnail: String
    )
}