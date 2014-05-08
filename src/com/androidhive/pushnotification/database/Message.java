package com.androidhive.pushnotification.database;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    public int id;
    public String date;
    public String category;
    public String msg;
    public int isRead;

    public Message(){

    }

    public Message(String category, String date, String msg, int read){
        this.category = category;
        this.date = date;
        this.msg = msg;
        this.isRead = read;

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setRead(int url) {
        this.isRead = url;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String cat) {
        this.category = cat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return msg;
    }
}
