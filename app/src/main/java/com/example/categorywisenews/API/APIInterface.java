package com.example.categorywisenews.API;

import com.example.categorywisenews.API.response.GetSourcrsResponse;
import com.example.categorywisenews.API.response.GetTopHeadLinesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("top-headlines")
    Call<GetTopHeadLinesResponse> getTopHeadLines(@Query("country") String country,
                                                  @Query ("apiKey") String apiKey);
    @GET("sources")
    Call<GetSourcrsResponse> getSourcrs(@Query("category") String category,
                                        @Query ("apiKey") String apiKey);}

