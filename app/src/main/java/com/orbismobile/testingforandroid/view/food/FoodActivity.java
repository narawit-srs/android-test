package com.orbismobile.testingforandroid.view.food;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.orbismobile.testingforandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodActivity extends AppCompatActivity {

    CountingIdlingResource countingIdlingResource = new CountingIdlingResource("DATA_LOADED");

    private TextView lblMessage;

    public CountingIdlingResource getCountingIdlingResource() {
        return countingIdlingResource;
    }

    public void setCountingIdlingResource(CountingIdlingResource countingIdlingResource) {
        this.countingIdlingResource = countingIdlingResource;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lblMessage = findViewById(R.id.lblMessage);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        performNetworkTask();


        //lblMessage.setText("NUEVO TEXTO");


//        new AsyncTask<Void, Void, Void>() {
//            @Override
//            protected Void doInBackground(Void... voids) {
//                try{
//                    Thread.sleep(5000);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                lblMessage.setText("NUEVO TEXTO");
//            }
//        }.execute();


//        countingIdlingResource.increment();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        lblMessage.setText("NUEVO TEXTO");
//                        countingIdlingResource.decrement();
//                    }
//                });
//            }
//        }).start();
    }


    private void performNetworkTask() {

        countingIdlingResource.increment();

        WinGokuAPI.Factory.getIstance().getFake("https://jsonplaceholder.typicode.com/posts").enqueue(new Callback<List<FakeResponse>>() {
            @Override
            public void onResponse(Call<List<FakeResponse>> call, Response<List<FakeResponse>> response) {
                if (response.isSuccessful()) {
                    lblMessage.setText(response.body().get(0).getTitle());
                } else {

                }

                countingIdlingResource.decrement();
            }

            @Override
            public void onFailure(Call<List<FakeResponse>> call, Throwable t) {

            }
        });
    }
}
