package com.michalfujak.example.e_objednaj.Utils;

import com.michalfujak.example.e_objednaj.Retrofit.IObjednajServiceClient;
import com.michalfujak.example.e_objednaj.Retrofit.RetrofitClient;

public class Common
{
    // variable, url string
    private static final String BASE_URL = "https://eobjednaj.sk/api/";

    public static IObjednajServiceClient getAPIServerOne()
    {
        return RetrofitClient.getRetrofit(BASE_URL).create(IObjednajServiceClient.class);
    }
}


