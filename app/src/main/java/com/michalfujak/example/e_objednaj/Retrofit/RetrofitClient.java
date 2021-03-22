package com.michalfujak.example.e_objednaj.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{
    // Retrofit object
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(String baseUrl)
    {
        // Call Retrofit and param url
        if(retrofit == null)
        {
            // GSON
            Gson objectGson = new GsonBuilder()
                    .setLenient()
                    .create();
            //
            // retrofit object is null
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(objectGson)).build();
                    // .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        }
        // Return retrofit object is fill
        return retrofit;
    }
}

/*
*
* public class RetrofitClient
{
    // private variable retrofit
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(String urlCommon)
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(urlCommon)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
*
* */

