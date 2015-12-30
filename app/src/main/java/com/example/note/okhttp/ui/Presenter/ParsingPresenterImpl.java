package com.example.note.okhttp.ui.Presenter;

import com.example.note.okhttp.domain.entities.Country;
import com.example.note.okhttp.domain.parsers.HtmlParser;
import com.example.note.okhttp.domain.parsers.MyJsonParser;
import com.example.note.okhttp.ui.Viewer;

import java.util.HashMap;
import java.util.List;

/**
 * Created by NOTE on 27.12.2015.
 */
public class ParsingPresenterImpl implements ParsingPresenter {

    private Viewer viewer;
    private HtmlParser htmlParser = new HtmlParser();
    private MyJsonParser myJsonParser = new MyJsonParser();
    private HashMap<String,String> objects;
    private List<Country> list;
    private int counter;
    public ParsingPresenterImpl(Viewer listener)
    {
        viewer = listener;
    }
    @Override
    public void getNews(String html) {
        objects = htmlParser.parse(html);
        viewer.showHtml(objects);
    }

    @Override
    public void getJson(String json) {
        list = myJsonParser.parse(json);
        if (list.size()>0) {
            viewer.showJson(list.get(0));
        }
    }

    @Override
    public void showNext() {
        counter++;
        if (counter >= list.size())
        {
            counter =0;
        }
        viewer.showJson(list.get(counter));
    }
}
