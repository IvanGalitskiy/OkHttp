package com.example.note.okhttp.ui.Presenter;

import android.content.Context;

import com.example.note.okhttp.domain.HtmlParser;
import com.example.note.okhttp.ui.HtmlView;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

/**
 * Created by NOTE on 27.12.2015.
 */
public class ParsingPresenterImpl implements ParsingPresenter {

    private HtmlView htmlView;
    private HashMap<String,String> objects;
    public ParsingPresenterImpl(HtmlView listener)
    {
        htmlView = listener;
    }
    @Override
    public void getNews(String html) {
        objects =  HtmlParser.parse(html);
        htmlView.showElements(objects);
    }
}
