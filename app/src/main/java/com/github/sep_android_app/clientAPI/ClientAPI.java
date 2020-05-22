package com.github.sep_android_app.clientAPI;

import com.github.sep_android_app.data.model.Room;
import com.github.sep_android_app.data.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ClientAPI
{
    @GET("rooms")
    Call<RoomResponse> getRooms();

    @GET("users")
    Call<UserResponse> getUsers();

    @GET("users/get")
    Call<User> getUser(@Query("username") String username);

    @GET("users/login")
    Call<String> loginCheck(@Query("username") String username,
                            @Query("password") String password);
    @POST("rooms")
    Call<String> createRoom(@Query("room") Room room);

    @POST("users/create")
    Call<String> createUser(@Query("username") String username,
                            @Query("password") String password);

    @GET("/rooms/averageTemperature")
    Call<Float> getWeeklyTemperature(@Query("roomname") String roomName);

    @GET("/rooms/averageHumidity")
    Call<Float> getWeeklyHumidity(@Query("roomname") String roomName);

    @GET("/rooms/averageCO2")
    Call<Float> getWeeklyCO2(@Query("roomname") String roomName);

    @PUT("/rooms")
    Call<String> updateRoom(@Body Room room, @Query("roomname") String roomName);

    @POST("/users/update")
    Call<String> updateUser(@Body User user, @Query("username") String username);





}
