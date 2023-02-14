package com.izicap.chatgptcall.models;

public class Response {
    private String question;
    private String answer;



    public Response(String question, String answer) {
        this.answer = answer;
        this.question = question;
    }



    public Response() {}



    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



    public String getQuestion() {
        return question;
    }



    public void setQuestion(String question) {
        this.question = question;
    }


}
