package com.example.note.okhttp.domain;

import android.content.Context;
import android.os.Bundle;
import android.content.AsyncTaskLoader;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by NOTE on 26.12.2015.
 */
public class MyLoader extends AsyncTaskLoader<String> {

    private  String url = "https://www.google.com.ua";
    private String key = "url";
    OkHttpClient client = new OkHttpClient();
    public MyLoader(Context context, Bundle bundle) {
        super(context);
        if (bundle!=null){
            url = bundle.getString(key);
        }
    }

    @Override
    public String loadInBackground() {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
      return null;
    }

}
