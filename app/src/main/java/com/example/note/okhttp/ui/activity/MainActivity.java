package com.example.note.okhttp.ui.activity;


import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.note.okhttp.R;
import com.example.note.okhttp.domain.HtmlParser;
import com.example.note.okhttp.domain.MyLoader;
import com.example.note.okhttp.ui.HtmlView;
import com.example.note.okhttp.ui.Presenter.ParsingPresenter;
import com.example.note.okhttp.ui.Presenter.ParsingPresenterImpl;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks, HtmlView {
    TextView title;
    TextView text;
    ImageView image;
    ParsingPresenter parsingPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView) findViewById(R.id.activity_main_title);
        text = (TextView) findViewById(R.id.activity_main_text);
        image = (ImageView) findViewById(R.id.activity_main_image);
        parsingPresenter = new ParsingPresenterImpl(this);
        Bundle bundle = new Bundle();
        bundle.putString("url", "http://ua.korrespondent.net/ukraine/3608243-na-zakarpatti-u-dvori-budynku-proluvnav-vybukh");
        Loader loader = getLoaderManager().initLoader(0,bundle,this);
        loader.forceLoad();
   }


    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        Loader<String> loader = null;
        loader = new MyLoader(this, args);
        return loader;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        parsingPresenter.getNews(data.toString());
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    @Override
    public void showElements(HashMap<String, String> map) {
        title.setText(map.get("title"));
        text.setText(map.get("text"));
        Picasso.with(image.getContext()).load(map.get("url")).into(image);
    }
}
