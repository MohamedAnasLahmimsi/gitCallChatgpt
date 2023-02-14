package com.izicap.chatgptcall.models;

public class Choice {

    private String text;



    public Choice() {}

    public Choice(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
