package com.ijikod.android.book_a_room.meetingRooms.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ijikod.android.book_a_room.databinding.FragmentMeetingRoomsBinding
import com.ijikod.android.book_a_room.meetingRooms.adapter.MeetingRoomsAdapter
import com.ijikod.android.book_a_room.meetingRooms.common.AutoCompositeDisposable
import com.ijikod.android.book_a_room.meetingRooms.common.addTo
import com.ijikod.android.book_a_room.meetingRooms.state.MeetingRoomsEvents
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MeetingRoomsFragment : Fragment() {

    private var _binding: FragmentMeetingRoomsBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val disposable: AutoCompositeDisposable by lazy { AutoCompositeDisposable(lifecycle) }
    private val viewModel: MeetingRoomsViewModel by viewModels()

    private lateinit var listAdapter: MeetingRoomsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listAdapter = MeetingRoomsAdapter { bookRoom(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeetingRoomsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRooms()

        binding.roomsList.adapter = listAdapter

        viewModel.events()
            .subscribe{ event ->

                if (event is MeetingRoomsEvents.Error) {
                    event.error.message?.let { errorMsg ->

                    }
                }

                if (event is MeetingRoomsEvents.ShowAllMeetingRooms) {
                     event.state.getAllMeetingRooms?.let {
                         listAdapter.data = it
                         listAdapter.notifyDataSetChanged()
                     }
                }
            }.addTo(disposable)
    }

    private fun bookRoom(spots: Int){

    }


}