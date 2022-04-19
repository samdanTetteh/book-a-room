package com.ijikod.android.book_a_room.meetingRooms.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.ijikod.android.book_a_room.R
import com.ijikod.android.book_a_room.databinding.RoomItemBinding
import com.ijikod.android.domain.entity.MeetingRoom
import com.squareup.picasso.Picasso

class MeetingRoomsAdapter( val makeBooking: (Pair<Int, Int>) -> Unit): RecyclerView.Adapter<MeetingRoomsAdapter.MeetingRoomViewHolder>() {

    var data = listOf<MeetingRoom>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingRoomViewHolder {
        return MeetingRoomViewHolder(RoomItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MeetingRoomViewHolder, position: Int) {
        holder.bind(data[position].id, data[position].spots, data[position].image)
    }

    override fun getItemCount(): Int = data.size


    inner class MeetingRoomViewHolder(private val binding: RoomItemBinding): RecyclerView.ViewHolder(binding.root) {

        private val roomImageView = binding.roomImage
        private val roomSpotsText = binding.roomSpotsTxt
        private val bookRoomButton = binding.bookBtn

        fun bind(roomId:Int, spots:Int, roomImg: String){
            Picasso.get().load(roomImg).into(roomImageView)
            bookRoomButton.isVisible = spots > 0
            if (roomSpotsText.isVisible) {
                roomSpotsText.text = binding.root.context.getString(R.string.remaining_spots_txt, spots)

                bookRoomButton.setOnClickListener {
                    makeBooking(Pair(roomId,spots))
                }
            }
        }
    }
}