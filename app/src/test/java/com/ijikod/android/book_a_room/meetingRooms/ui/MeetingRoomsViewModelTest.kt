package com.ijikod.android.book_a_room.meetingRooms.ui

import com.ijikod.android.book_a_room.common.RxJavaTestRule
import com.ijikod.android.domain.useCase.BookMeetingRoomUseCase
import com.ijikod.android.domain.useCase.GetAllMeetingRoomsUseCase
import com.ijikod.book_a_room.FakeBookedMeetingRoomRepository
import com.ijikod.book_a_room.FakeGetMeetingRoomRepository
import com.ijikod.book_a_room.Fakes
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MeetingRoomsViewModelTest {

    @get:Rule
    val rxRule = RxJavaTestRule()

    private lateinit var viewModel: MeetingRoomsViewModel


    @Before
    fun setUp() {
        viewModel = MeetingRoomsViewModel(GetAllMeetingRoomsUseCase(FakeGetMeetingRoomRepository()),
            BookMeetingRoomUseCase(FakeBookedMeetingRoomRepository()))
    }



    @Test
    fun `initial states values are null`() {
        val testObserver = viewModel.states().test()
        testObserver.assertValue { state -> state.getAllMeetingRooms == null }
        testObserver.assertValue { state -> state.bookedMeetingRoom == null }
        testObserver.assertValue { state -> state.getBookedRoomStatus == null }
    }


    @Test
    fun `when get rooms is called data for all meeting rooms is loaded`() {
        viewModel.getRooms()

        val testObserver = viewModel.states().test()
        testObserver.assertValue { state -> state.getAllMeetingRooms == listOf(Fakes.getFakeMeetingRooms()) }
    }
}