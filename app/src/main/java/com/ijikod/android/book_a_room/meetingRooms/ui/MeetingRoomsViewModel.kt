package com.ijikod.android.book_a_room.meetingRooms.ui

import com.ijikod.android.book_a_room.meetingRooms.common.AsyncResult
import com.ijikod.android.book_a_room.meetingRooms.common.Reducer
import com.ijikod.android.book_a_room.meetingRooms.common.RxViewModelStore
import com.ijikod.android.book_a_room.meetingRooms.common.mapToAsyncResult
import com.ijikod.android.book_a_room.meetingRooms.state.MeetingRoomState
import com.ijikod.android.book_a_room.meetingRooms.state.MeetingRoomsEvents
import com.ijikod.android.domain.useCase.BookMeetingRoomUseCase
import com.ijikod.android.domain.useCase.GetAllMeetingRoomsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import java.lang.Error
import javax.inject.Inject

@HiltViewModel
class MeetingRoomsViewModel @Inject constructor(
    private val getAllMeetingUseCase: GetAllMeetingRoomsUseCase,
    private val bookMeetingRoomUseCase: BookMeetingRoomUseCase
):  RxViewModelStore<MeetingRoomState, MeetingRoomsEvents>(MeetingRoomState()) {


    fun getRooms() {
        getAllMeetingUseCase.getAllMeetingRooms()
            .mapToAsyncResult()
            .subscribeOn(Schedulers.io())
            .subscribe { result ->
                if (result is AsyncResult.Error){
                    publish(MeetingRoomsEvents.Error(result.error))
                } else {
                    applyState(Reducer { currentState().copy(allMeetingRooms = result) })
                    publish(MeetingRoomsEvents.ShowAllMeetingRooms(currentState()))
                }
            }.addDisposable()


        getAllMeetingUseCase.getRoomsFromRemote()
            .mapToAsyncResult()
            .subscribeOn(Schedulers.io())
            .subscribe{
                if (it is AsyncResult.Error){
                    publish(MeetingRoomsEvents.Error(it.error))
                }
            }.addDisposable()

    }

    fun bookMeetingRoom(id: Int, spots:Int){
        bookMeetingRoomUseCase.invoke()
            .mapToAsyncResult()
            .subscribeOn(Schedulers.io())
            .subscribe { result ->
                if (result is AsyncResult.Error) {
                    publish(MeetingRoomsEvents.Error(result.error))
                } else {
                    bookMeetingRoomUseCase.updateMeetingRoomSpots(id, spots)
                    applyState(Reducer { currentState().copy(bookedMeetingRoom = result) })
                    publish(MeetingRoomsEvents.BookedMeetingRoom(currentState()))
                }
            }.addDisposable()
    }

}