package com.example.note.okhttp.ui;

import com.example.note.okhttp.domain.entities.Country;

import java.util.HashMap;
import java.util.List;

/**
 * Created by NOTE on 27.12.2015.
 */
public interface Viewer {
    public void showHtml(HashMap<String,String> map);
    public void showJson(Country country);
}
