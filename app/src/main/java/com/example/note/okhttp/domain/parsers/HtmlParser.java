package com.example.note.okhttp.domain.parsers;

import android.content.Context;
import android.provider.DocumentsContract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;


/**
 * Created by NOTE on 27.12.2015.
 */
public class HtmlParser  {
    public HtmlParser() {
    }

    public HashMap<String, String> parse(String html) {
            HashMap<String,String> map = new HashMap<>();
            Document doc = Jsoup.parse(html);
            Element img = doc.select("img.post-item__photo-img").first();
            String url = img.absUrl("src");
            String title = doc.title();
            String text = doc.select("div.post-item__text").text();
            map.put("url", url);
            map.put("title", title);
            map.put("text", text);
            return map;
    }
}
