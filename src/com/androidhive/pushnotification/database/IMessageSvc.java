package com.androidhive.pushnotification.database;

import java.util.List;

/**
 * Created by Valentine on 4/12/14.
 */
public interface IMessageSvc {
    public long create (Message msg);
    public List<Message> readAllMessage();
    public Message update(Message msg);
    public Message delete(Message msg);



}
