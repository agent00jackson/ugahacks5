package com.ugahacks5.wolf.Main;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HackathonAPI {
    @GET("stack")
    Call<List<StockInfo>> loadStack(@Query("q") String status);

    @GET("portfolio")
    Call<List<Position>> loadPortfolio(@Query("q") String status);


}
