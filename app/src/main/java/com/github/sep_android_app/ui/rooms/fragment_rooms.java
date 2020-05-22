package com.github.sep_android_app.ui.rooms;

import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.sep_android_app.R;
import com.github.sep_android_app.adapters.RoomAdapter;
import com.github.sep_android_app.data.model.Room;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class fragment_rooms extends Fragment implements RoomAdapter.onClickListener {


    private FragmentRoomsViewModel mViewModel;
    private FloatingActionButton mainFab;
    private List<Room> rooms = new ArrayList<>();
    private RecyclerView recyclerView;

    public static fragment_rooms newInstance() {
        return new fragment_rooms();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rooms, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewRoom);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        rooms.add(new Room("Livingroom"));

        RoomAdapter adapter = new RoomAdapter(rooms, this);

        recyclerView.setAdapter(adapter);
        mainFab = requireActivity().findViewById(R.id.main_fab);
        mainFab.setImageResource(R.drawable.ic_add);
        // Setting specific FAB onClick
        mainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();

                builder.setView(inflater.inflate(R.layout.dialog_create_room, null));
                Log.d(TAG, "Trying to inflate dialog");
                builder.create();
                builder.show();
            }
        });
        mainFab.show();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentRoomsViewModel.class);
        // TODO: Use the ViewModel
    }

    // Handling different on click behaviour depending on ID of the button in the item_room
    @Override
    public void onClick(int position, View view) {
        switch (view.getId()) {
            case R.id.edit_room_button:
                Log.d(TAG, "Edit room button pressed at " + position + " " + rooms.get(position).getName());
                break;
            case R.id.delete_room_button:
                Log.d(TAG, "Delete room button pressed at " + position + " " + rooms.get(position).getName());
                break;
            case R.id.view_data_button:
                Log.d(TAG, "View data button pressed at " + position + " " + rooms.get(position).getName());
                Bundle bundle = new Bundle();
                bundle.putString("roomName", rooms.get(position).getName());
                Navigation.findNavController(view).navigate(R.id.action_nav_rooms_to_fragment_room_data, bundle);

                break;
        }

    }
}
