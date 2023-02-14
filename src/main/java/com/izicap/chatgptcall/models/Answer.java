package com.izicap.chatgptcall.models;

import java.util.List;

public class Answer {
    private List<Choice> choices;



    public Answer() {}

    public String getAnswerText() {
        return choices.get(0).getText();
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
