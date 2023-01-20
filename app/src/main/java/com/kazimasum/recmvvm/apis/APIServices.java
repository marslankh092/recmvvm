package com.kazimasum.recmvvm.apis;

import com.kazimasum.recmvvm.models.MovieModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
//    //http://192.168.100.199/api/json_user_fetch.php
public interface APIServices
{
    @GET("json_user_fetch.php")
    Call<List<MovieModel>> getMovieList();
}
