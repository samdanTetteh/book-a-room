package com.ijikod.android.data.rooms

import com.ijikod.android.data.rooms.entities.RoomEntity
import com.ijikod.android.domain.entity.MeetingRoom

fun GetMeetingRoomsApiContract.MeetingRoomsResponse.toEntity(): List<RoomEntity> {
     return this.rooms.mapIndexed { index, value ->
         RoomEntity(
             id = index,
             name = value.name,
             spots = value.spots,
             image = value.thumbnail
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