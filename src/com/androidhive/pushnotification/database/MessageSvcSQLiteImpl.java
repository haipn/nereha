package com.androidhive.pushnotification.database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Valentine on 4/18/14.
 */
public class MessageSvcSQLiteImpl extends SQLiteOpenHelper implements IMessageSvc {

    private static final String DBNAME = "message.db";
    private static final int DBVERSION = 1;

    public MessageSvcSQLiteImpl(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    private String createBookTable = "create table Message (id integer primary key autoincrement," +
            "date text not null, category text, read tinyint, message text not null)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createBookTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVers, int newVers) {
        db.execSQL("DROP TABLE IF EXISTS Message");
        onCreate(db);
    }

    @Override
    public long create(Message book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", book.getDate());
        values.put("category", book.getCategory());
        values.put("read", book.getIsRead());
        values.put("message", book.getMessage());
        long ret = db.insert("Message", null, values);
        db.close();
        return ret;
    }

    @Override
    public ArrayList<Message> readAllMessage() {
        ArrayList<Message> books = new ArrayList<Message>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Message", new String[]{"id", "date", "category", "read", "message"},
                null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Message book = getMessage(cursor);
            books.add(book);
            cursor.moveToNext();
        }
        cursor.close();
        return books;
    }

    @Override
    public Message update(Message book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", book.getDate());
        values.put("category", book.getCategory());
        values.put("read", book.getIsRead());
        values.put("message", book.getMessage());
        db.update("Message", values, "id" + "=" + book.getId(), null);
        db.close();
        return book;
    }

    @Override
    public Message delete(Message book) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Message", "id" + "=" + book.getId(), null);
        db.close();
        return null;
    }

    private Message getMessage(Cursor cursor) {
        Message book = new Message();
        book.setId(cursor.getInt(0));
        book.setDate(cursor.getString(1));
        book.setCategory(cursor.getString(2));
        book.setRead(cursor.getInt(3));
        book.setMessage(cursor.getString(4));
        return book;
    }


}
