package com.example.montes8.demoretrofit2java.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreator {

    private static Retrofit RETROFIT;

    public static Retrofit getInstance(){
        if(RETROFIT == null){

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            RETROFIT = new Retrofit.Builder()
                    .baseUrl("https://mantenimientogalaxy.herokuapp.com/api/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT;
    }


}
