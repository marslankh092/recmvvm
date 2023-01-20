package com.kazimasum.recmvvm.viewmodels;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kazimasum.recmvvm.apis.APIServices;
import com.kazimasum.recmvvm.apis.RetroInstance;
import com.kazimasum.recmvvm.models.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel
{
    private MutableLiveData<List<MovieModel>> movielist;


    public MovieListViewModel(){

        movielist=new MutableLiveData<>();
    }


    public MutableLiveData<List<MovieModel>> getMovielistObserver()
    {
        return movielist;
    }

    public void makeApiCall()
    {
        APIServices apiServices= RetroInstance.getRetroClient().create(APIServices.class);
        Call<List<MovieModel>> call=apiServices.getMovieList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
               movielist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
            movielist.postValue(null);
            Log.e("Error :",t.getMessage().toString());
            }
        });


    }
}
