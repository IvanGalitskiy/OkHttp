package com.example.note.okhttp.domain.entities;

/**
 * Created by NOTE on 30.12.2015.
 */
public class Country {
    private long id;
    private String name;
    private String flag;

    public Country() {
    }

    public Country(long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.flag = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String image) {
        this.flag = image;
    }

    @Override
    public String toString() {
        return name ;
    }
}
