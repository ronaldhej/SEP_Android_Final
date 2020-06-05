package com.github.sep_android_app.ui.rooms;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.sep_android_app.R;
import com.github.sep_android_app.adapters.DataAdapter;
import com.github.sep_android_app.data.model.RoomData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class fragment_room_data extends Fragment {

    private FragmentRoomDataViewModel mViewModel;
    private RecyclerView recyclerView;
    private List<RoomData> RoomData = new ArrayList<>();
    private FloatingActionButton mainFab;

    public static fragment_room_data newInstance() {
        return new fragment_room_data();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: creating data view");
        View view = inflater.inflate(R.layout.fragment_room_data, null);
        recyclerView = view.findViewById(R.id.recyclerFragmentViewRoomData);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Adding dummy data
        RoomData.add(new RoomData("today", "CO2: 3800ppm, Temp: 20.3C. Humidity: 48%"));

        //Assigning adapter to the recyclerview
        DataAdapter adapter = new DataAdapter(RoomData);
        recyclerView.setAdapter(adapter);
        //Getting instance of button, but hiding it as it's not used here
        mainFab = requireActivity().findViewById(R.id.main_fab);
        mainFab.hide();

        //Toast to show that data has passed via from previous fragment via arguments
        Context context = getContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, getArguments().getString("roomName"), duration);
        toast.show();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentRoomDataViewModel.class);
        // TODO: Use the ViewModel
    }

}
