package com.github.sep_android_app.clientAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ServiceGenerator
{
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://localhost:23561")
            .addConverterFactory(GsonConverterFactory.create());


    private static Retrofit retrofit = retrofitBuilder.build();
    private static ClientAPI clientAPI = retrofit.create(ClientAPI.class);
    public static ClientAPI getClientAPI()
    {
        return clientAPI;
    }

}
