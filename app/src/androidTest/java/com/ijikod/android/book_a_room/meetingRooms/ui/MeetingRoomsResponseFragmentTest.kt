package com.ijikod.android.book_a_room.meetingRooms.ui

import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ijikod.android.book_a_room.R
import com.ijikod.android.book_a_room.first
import com.ijikod.android.book_a_room.launchFragmentInHiltContainer
import com.ijikod.android.book_a_room.meetingRooms.common.FIRST_MEETING_ROOM_NAME
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
@HiltAndroidTest
class MeetingRoomsResponseFragmentTest{

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        // Populate @Inject fields in test class
        hiltRule.inject()

        launchMeetingRoomsFragment()
    }

    private val navController = TestNavHostController(ApplicationProvider.getApplicationContext())


    @Test
    fun givenMeetingRoomsFragmentIsDisplayedIsRecyclerViewVisible() {
        Espresso.onView(first(withId(R.id.rooms_list))).check(ViewAssertions.matches(isDisplayed()))
    }


    @Test
    fun givenMeetingRoomsFragmentIsDisplayedIsFirstMeetingRoomCorrect() {
        Espresso.onView(first(withId(R.id.rooms_list)))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        hasDescendant(withId(R.id.room_name)),
                        hasDescendant(withText(FIRST_MEETING_ROOM_NAME))
                    )
                )
            )}



    private fun launchMeetingRoomsFragment() {
        launchFragmentInHiltContainer<MeetingRoomsFragment>() {
            navController.setGraph(R.navigation.nav_graph)
            navController.setCurrentDestination(R.id.meetingRoomsFragment)
            this.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                if (viewLifecycleOwner != null) {
                    // The fragment’s view has just been created
                    Navigation.setViewNavController(this.requireView(), navController)
                }
            }
        }
    }

}