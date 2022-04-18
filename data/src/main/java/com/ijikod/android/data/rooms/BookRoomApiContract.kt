package com.ijikod.android.data.rooms

import com.google.gson.annotations.SerializedName

interface BookRoomApiContract {

    data class BookRoomResponse(
        @SerializedName("success") val success: String
    )
}