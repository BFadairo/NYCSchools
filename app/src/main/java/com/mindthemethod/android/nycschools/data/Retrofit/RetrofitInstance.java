package com.mindthemethod.android.nycschools.data.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private final static String BASE_URL = "https://data.cityofnewyork.us/resource/";

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance() {

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build();
        }
        return retrofit;
    }
}
