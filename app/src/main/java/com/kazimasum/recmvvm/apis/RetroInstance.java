package com.kazimasum.recmvvm.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance
{ //192.168.100.199
    //https://quotable.io/random
    public static String baseurl="http://192.168.100.199/api/"; // volley_array.json
    private static Retrofit retrofit;

    public static Retrofit getRetroClient()
    {
         if(retrofit==null)
         {
             retrofit= new Retrofit.Builder()
                           .baseUrl(baseurl)
                           .addConverterFactory(GsonConverterFactory.create())
                           .build();
         }
         return retrofit;
    }
}
