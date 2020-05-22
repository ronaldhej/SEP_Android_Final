package com.github.sep_android_app.clientAPI;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.sep_android_app.data.model.Room;
import com.github.sep_android_app.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIRepository
{
    private static APIRepository instance;
    private MutableLiveData<List<User>> users;
    private MutableLiveData<List<Room>> rooms;
    public APIRepository()
    {
        users = new MutableLiveData<>();
        rooms = new MutableLiveData<>();
    }

    public static synchronized APIRepository getInstance()
    {
        if(instance == null)
        {
            instance = new APIRepository();
        }
        return instance;
    }
    public LiveData<List<User>> getUsers()
    {
        return users;
    }
    public LiveData<List<Room>> getRooms()
    {
        return rooms;
    }
    public void updateRooms()
    {
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<RoomResponse> call = clientAPI.getRooms();
        call.enqueue(new Callback<RoomResponse>()
        {
            @Override
            public void onResponse(Call<RoomResponse> call, Response<RoomResponse> response)
            {
                if (response.code() == 200)
                {
                    rooms.setValue(response.body().getRooms());
                }
            }

            @Override
            public void onFailure(Call<RoomResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");


            }

        });
    }
    public void updateUsers()
    {
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<UserResponse> call = clientAPI.getUsers();
        call.enqueue(new Callback<UserResponse>()
        {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response)
            {
                if (response.code() == 200)
                {
                    users.setValue(response.body().getUsers());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");

            }

        });
    }
    public void loginUser(String username, String password)
    {
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<String> call = clientAPI.loginCheck(username, password);
        call.enqueue(new Callback<String>()
        {


            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                //TODO:implement login function
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
    public void createRoom(Room room)
    {
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<String> call = clientAPI.createRoom(room);
        call.enqueue(new Callback<String>()
        {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                //TODO:displaying the room
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
    public void createUser(String username, String password)
    {
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<String> call = clientAPI.createUser(username, password);
        call.enqueue(new Callback<String>()
        {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                //TODO:displaying the next view
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
    public void getWeeklyTemperature(String roomname)
    {
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<Float> call = clientAPI.getWeeklyTemperature(roomname);
        call.enqueue(new Callback<Float>()
        {

            @Override
            public void onResponse(Call<Float> call, Response<Float> response) {
                //TODO:displaying the weekly temperature
            }

            @Override
            public void onFailure(Call<Float> call, Throwable t) {

            }
        });
    }
    public void getWeeklyHumidity(String roomname)
    {
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<Float> call = clientAPI.getWeeklyHumidity(roomname);
        call.enqueue(new Callback<Float>()
        {

            @Override
            public void onResponse(Call<Float> call, Response<Float> response) {
                //TODO:displaying the weekly humidity
            }

            @Override
            public void onFailure(Call<Float> call, Throwable t) {

            }
        });
    }
    public void getWeeklyCO2(String roomname)
    {
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<Float> call = clientAPI.getWeeklyCO2(roomname);
        call.enqueue(new Callback<Float>()
        {

            @Override
            public void onResponse(Call<Float> call, Response<Float> response) {
                //TODO:displaying the weekly CO2
            }

            @Override
            public void onFailure(Call<Float> call, Throwable t) {

            }
        });
    }
    public void updateRoom(Room room, String roomName)
    {
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<String> call = clientAPI.updateRoom(room, roomName);
        call.enqueue(new Callback<String>()
        {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                //TODO:display the new room
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
    // Might not work due to making it return user instead of being void
    public LiveData<User> getUser(String username)
    {
        final MutableLiveData<User> data = new MutableLiveData<>();
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<User> call = clientAPI.getUser(username);
        call.enqueue(new Callback<User>()
        {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }


        });
        return data;
    }
    public void updateUser(User user, String username)
    {
        ClientAPI clientAPI = ServiceGenerator.getClientAPI();
        Call<String> call = clientAPI.updateUser(user, username);
        call.enqueue(new Callback<String>()
        {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                //TODO:display the new user
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

}
