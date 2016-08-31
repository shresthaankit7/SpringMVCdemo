package com.ankit.domain;

/**
 * Created by ankit07 on 8/28/16.
 */
public class Message {
    String name;
    String text;

    public Message(){}

    public Message(String name,String text){
        this.name = name;
        this.text = text;
    }

    public String getName(){
        return name;
    }

    public String getText(){
        return text;
    }
}
