package com.example.note.okhttp.ui.activity;


import android.app.LoaderManager.LoaderCallbacks;
import android.content.DialogInterface;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.note.okhttp.R;
import com.example.note.okhttp.domain.MyLoader;
import com.example.note.okhttp.domain.entities.Country;
import com.example.note.okhttp.ui.Viewer;
import com.example.note.okhttp.ui.Presenter.ParsingPresenter;
import com.example.note.okhttp.ui.Presenter.ParsingPresenterImpl;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks, Viewer, View.OnClickListener {
    TextView title;
    TextView text;
    ImageView image;
    Button nextBtn;
    ParsingPresenter parsingPresenter;
    private int task = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView) findViewById(R.id.activity_main_title);
        text = (TextView) findViewById(R.id.activity_main_text);
        image = (ImageView) findViewById(R.id.activity_main_image);
        nextBtn = (Button) findViewById(R.id.activity_main_next);
        nextBtn.setOnClickListener(this);
        parsingPresenter = new ParsingPresenterImpl(this);
        Bundle bundle = new Bundle();
        if (task ==0) {
            bundle.putString("url", "http://ua.korrespondent.net/ukraine/3608243-na-zakarpatti-u-dvori-budynku-proluvnav-vybukh");
        } else if (task ==1){
            bundle.putString("url", "http://virtual-cv.com.ua/admin/language/alllanguege");
        }
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
        if (task == 0) {
            parsingPresenter.getNews(data.toString());
        } else if (task ==1) {
            parsingPresenter.getJson(data.toString());
        }
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    @Override
    public void showHtml(HashMap<String, String> map) {
        title.setText(map.get("title"));
        text.setText(map.get("text"));
        Picasso.with(image.getContext()).load(map.get("url")).into(image);
    }

    @Override
    public void showJson(Country country) {
        title.setText(country.getName());
        text.setText(country.getId()+"");
        Picasso.with(image.getContext()).load(country.getFlag()).into(image);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.activity_main_next:
                parsingPresenter.showNext();
                break;
        }
    }
}
