package com.michalfujak.example.e_objednaj.Retrofit;

import com.michalfujak.example.e_objednaj.Modul.ApplicationLogin;
import com.michalfujak.example.e_objednaj.Modul.ApplicationLoginSecret;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface IObjednajServiceClient
{
    // interface
    @POST("/authorizeapp/{urlNonce}")
    Call<ApplicationLoginSecret> appLoginSecret(@Body ApplicationLogin appLogin, @Path("urlNonce") String urlNonce);


    // Call token
    @GET("authorizeapp")
    Call<ResponseBody> getSecretToken(@Header("Authorization") String getToken);
}

