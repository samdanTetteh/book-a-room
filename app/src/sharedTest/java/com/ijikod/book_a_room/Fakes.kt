package com.ijikod.book_a_room

import com.google.gson.Gson
import com.ijikod.android.data.rooms.GetMeetingRoomsApiContract
import com.ijikod.android.domain.entity.BookedMeetingRoom
import com.ijikod.android.domain.entity.MeetingRoom

object Fakes {

    fun getFakeMeetingRooms(): MeetingRoom {
        return Gson().fromJson(ROOMS_JSON, MeetingRoom::class.java)
    }

    fun getFakeBookedMeetingRoom(): BookedMeetingRoom {
        return Gson().fromJson(BOOKED_ROOM_JSON, BookedMeetingRoom::class.java)
    }


    private const val BOOKED_ROOM_JSON = "{\n" +
            "    \"success\": true\n" +
            "}"

    private const val ROOMS_JSON = "{\n" +
            "    \"rooms\": [\n" +
            "        {\n" +
            "            \"name\": \"Ljerka\",\n" +
            "            \"spots\": 43,\n" +
            "            \"thumbnail\": \"https://images.unsplash.com/photo-1571624436279-b272aff752b5?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1504&q=80\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Mostafa\",\n" +
            "            \"spots\": 4,\n" +
            "            \"thumbnail\": \"https://images.unsplash.com/photo-1497366858526-0766cadbe8fa?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Helmold\",\n" +
            "            \"spots\": 86,\n" +
            "            \"thumbnail\": \"https://images.unsplash.com/photo-1539872209618-fb1770aa6ff8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1251&q=80\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Painter\",\n" +
            "            \"spots\": 16,\n" +
            "            \"thumbnail\": \"https://images.unsplash.com/photo-1540760029765-138c8f6d2eac?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Septima\",\n" +
            "            \"spots\": 84,\n" +
            "            \"thumbnail\": \"https://images.unsplash.com/photo-1455994972514-4624f7f224a7?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1267&q=80\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Alexis\",\n" +
            "            \"spots\": 0,\n" +
            "            \"thumbnail\": \"https://images.unsplash.com/photo-1504384308090-c894fdcc538d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Yana\",\n" +
            "            \"spots\": 34,\n" +
            "            \"thumbnail\": \"https://images.unsplash.com/photo-1498409785966-ab341407de6e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1520&q=80\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Mina\",\n" +
            "            \"spots\": 39,\n" +
            "            \"thumbnail\": \"https://images.unsplash.com/photo-1601762429744-46fe92ccd903?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80\"\n" +
            "        }\n" +
            "    ]\n" +
            "}"
}