package com.orbismobile.testingforandroid.view.food;

import android.support.test.espresso.IdlingResource;
import android.util.Log;

import com.jakewharton.espresso.OkHttp3IdlingResource;
import com.orbismobile.testingforandroid.BuildConfig;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by carlosleonardocamilovargashuaman on 8/31/17.
 */

public interface WinGokuAPI2 {

    final String BASE_URL = "http://wingoku.com";

    class Factory {
        private static WinGokuAPI2 WinGokuAPI;
        //public static MyExecutor executor;

        public static WinGokuAPI2 getIstance() {
            if (WinGokuAPI == null) {

                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

                logging.setLevel(HttpLoggingInterceptor.Level.NONE);

                if(BuildConfig.DEBUG){
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                }
                
                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .addInterceptor(logging)
                        .writeTimeout(10, TimeUnit.SECONDS)
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(20, TimeUnit.SECONDS)
                        .build();


                // setting our custom executorService to the Okhttp Dispatcher
                //okHttpClient_builder.dispatcher(new Dispatcher(executor));

                IdlingResource idlingResource = OkHttp3IdlingResource.create("OkHttp", okHttpClient);


                Retrofit client = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                WinGokuAPI = client.create(WinGokuAPI2.class);
                return WinGokuAPI;
            } else {
                return WinGokuAPI;
            }
        }
    }

    String HEADER_AUTHORIZATION = "Authorization";

    @GET
    Call<List<FakeResponse>> getFake(@Url String url);

}
