package com.github.sep_android_app.ui.rooms;

import android.app.usage.UsageEvents;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.sep_android_app.data.model.Room;

import java.util.ArrayList;
import java.util.List;

public class FragmentRoomsViewModel extends ViewModel {
    public MutableLiveData<List<Room>> roomLiveData;
    List<Room> roomList;

    public FragmentRoomsViewModel() {
        roomLiveData = new MutableLiveData<>();

        init();
    }

    public MutableLiveData<List<Room>> getRoomLiveData() {
        return roomLiveData;
    }

    public void init() {
        //Call rest API here
        roomLiveData.setValue(roomList);
    }

}
