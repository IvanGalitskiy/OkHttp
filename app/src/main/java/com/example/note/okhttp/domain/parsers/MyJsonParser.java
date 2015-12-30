package com.example.note.okhttp.domain.parsers;

import android.util.Log;

import com.example.note.okhttp.domain.entities.Country;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NOTE on 28.12.2015.
 */
public class MyJsonParser {
    private ObjectMapper objectMapper;
    List<Country> myObjects = new ArrayList<Country>();
    public MyJsonParser() {
        objectMapper = new ObjectMapper();
    }
    public List<Country> parse(String parseString) {
        try {
            JSONArray array = new JSONArray(parseString);
            for (int i = 0; i<array.length(); i++) {
                JSONArray obj = array.getJSONArray(i);
                myObjects.addAll(Arrays.asList(objectMapper.readValue(obj.toString(), Country[].class)));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return myObjects;
    }
}
