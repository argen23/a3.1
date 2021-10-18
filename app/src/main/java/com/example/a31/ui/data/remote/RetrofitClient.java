package com.example.a31.ui.data.remote;

import java.util.concurrent.TimeUnit;

import dagger.Provides;
import dagger.hilt.android.AndroidEntryPoint;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(provideLoggingInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .build();

    private HttpLoggingInterceptor provideLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

private final Retrofit provideRetrofit = new Retrofit.Builder().baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

    public ApiService provideApiService(){
        return provideRetrofit.create(ApiService.class);
    }

}
