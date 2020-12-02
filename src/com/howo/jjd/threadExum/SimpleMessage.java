package com.howo.jjd.threadExum;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class SimpleMessage implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime dateTime;

    public SimpleMessage(String sender, String text, LocalDateTime dateTime) {
        this.sender = sender;
        this.text = text;
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime(){

        dateTime = LocalDateTime.now();

    }


    @Override
    public String toString() {
        return sender.toUpperCase() + ": " +
                "написал: '" + text + '\'' +
                ", " + dateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)) +
                '}';
    }

    public static SimpleMessage getMessage(String sender, String text, LocalDateTime dateTime){
        return new SimpleMessage(sender, text, dateTime);
    }
}