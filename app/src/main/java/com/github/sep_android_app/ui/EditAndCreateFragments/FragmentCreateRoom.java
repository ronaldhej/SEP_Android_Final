package com.github.sep_android_app.ui.EditAndCreateFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.github.sep_android_app.R;
import com.github.sep_android_app.adapters.RoomAdapter;
import com.github.sep_android_app.clientAPI.APIRepository;
import com.github.sep_android_app.clientAPI.ClientAPI;
import com.github.sep_android_app.data.model.Room;
import com.github.sep_android_app.ui.rooms.FragmentRoomsViewModel;
import com.github.sep_android_app.ui.rooms.fragment_rooms;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCreateRoom#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCreateRoom extends Fragment {

    APIRepository client = new APIRepository();

    public FragmentCreateRoom() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCreateRoom.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCreateRoom newInstance(String param1, String param2) {
        FragmentCreateRoom fragment = new FragmentCreateRoom();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_create_room, container, false);
        Button createRoomBtn = view.findViewById(R.id.btn_create_room);
        final EditText tb_roomName = view.findViewById(R.id.tb_createRoomName);
        Log.d("credit", "ViewHolder: " + R.string.r_credit);
        createRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomName = String.valueOf(tb_roomName.getText());
                client.createRoom(new Room(roomName));
                Navigation.findNavController(view).navigate(R.id.action_fragmentCreateRoom_to_nav_rooms);
            }
        });
        return view;
    }
}