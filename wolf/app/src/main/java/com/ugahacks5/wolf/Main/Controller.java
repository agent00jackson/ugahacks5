package com.ugahacks5.wolf.Main;

import android.util.Log;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {

    static final String BASE_URL = "https://hackathon-1569554271539.appspot.com/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        HackathonAPI hackathonAPI = retrofit.create(HackathonAPI.class);

        Call<List<StockInfo>> call = hackathonAPI.loadStack("status:open");
        call.enqueue(new Callback<List<StockInfo>>() {
            @Override
            public void onResponse(Call<List<StockInfo>> call, Response<List<StockInfo>> response) {
                if(response.isSuccessful()) {
                    List<StockInfo> changesList = response.body();
                    for(StockInfo s : changesList)
                    {
                        Log.d("d",s.getTicker());
                    }
                } else {
                    Log.d("d",response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<StockInfo>> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }

}