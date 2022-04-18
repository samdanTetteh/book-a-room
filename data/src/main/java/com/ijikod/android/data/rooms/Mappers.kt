package com.ijikod.android.data.rooms

import com.ijikod.android.data.rooms.entities.RoomEntity
import com.ijikod.android.domain.entity.MeetingRoom

fun GetMeetingRoomsApiContract.MeetingRoomsResponse.toEntity(): List<RoomEntity> {
     return this.rooms.map {
         RoomEntity(
             name = it.name,
             spots = it.spots,
             image = it.thumbnail
         )
     }
}


fun List<RoomEntity>.toDomain(): List<MeetingRoom> {
    return this.map { roomEntity ->
        MeetingRoom (
            id = roomEntity.id,
            name = roomEntity.name,
            spots = roomEntity.spots,
            image = roomEntity.image
        )
    }
}