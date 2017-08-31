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

public interface WinGokuAPI {

    final String BASE_URL = "http://wingoku.com";

    class Factory {
        private static WinGokuAPI WinGokuAPI;
        //public static MyExecutor executor;

        public static WinGokuAPI getIstance() {
            if (WinGokuAPI == null) {

                Log.e("wingoku"," INSTANCE CLASS CREATED");
                OkHttpClient.Builder okHttpClient_builder = new OkHttpClient().newBuilder();
                okHttpClient_builder.connectTimeout(10, TimeUnit.SECONDS);
                okHttpClient_builder.readTimeout(20, TimeUnit.SECONDS);

                // setting our custom executorService to the Okhttp Dispatcher
                //okHttpClient_builder.dispatcher(new Dispatcher(executor));

                if (BuildConfig.DEBUG) {
                    Log.e("wignoku", "debug build");
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    okHttpClient_builder.addInterceptor(interceptor);
                }


                Retrofit retrofit = new Retrofit.Builder()
                        .client(okHttpClient_builder.build())
                        .addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL)
                        .build();
                WinGokuAPI = retrofit.create(WinGokuAPI.class);
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
