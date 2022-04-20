package com.ijikod.android.data.rooms

import com.google.gson.annotations.SerializedName

interface GetMeetingRoomsApiContract {

    data class MeetingRoomsResponse(
        @SerializedName("rooms") val rooms: List<RoomsResponse>
    )

    data class RoomsResponse(
        @SerializedName("name") val name: String,
        @SerializedName("spots") val spots: Int,
        @SerializedName("thumbnail") val thumbnail: String
    )
}