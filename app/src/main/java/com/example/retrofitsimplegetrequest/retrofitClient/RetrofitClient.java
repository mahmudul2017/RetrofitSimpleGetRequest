package com.example.retrofitsimplegetrequest.retrofitClient;

import android.content.Context;

import java.util.zip.CheckedOutputStream;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String baseUrl = "";
    private static Retrofit retrofit;

    public synchronized static Retrofit getInstance(final Context context, String mBaseUrl) {
        if (retrofit == null) {
            createRetrofit(context, mBaseUrl);
        }
        return retrofit;
    }

    public static void createRetrofit(final Context context, String baseUrl){
           if (baseUrl.equals("api")){
               retrofit = new Retrofit.Builder()
                       .baseUrl("https://jsonplaceholder.typicode.com/")
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();
           }
        }
}
