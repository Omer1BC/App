package com.example.cardsinterface;

public class Message {
    public static String SENT_BY_ME = "me";
    public static String SENT_BY_BOT =  "bot";

    String message;
    String by;

    public Message(String message, String by) {
        this.message = message;
        this.by = by;
    }

    public String getMessage() {
        return message;
    }

    public String getBy() {
        return by;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBy(String by) {
        this.by = by;
    }
}
