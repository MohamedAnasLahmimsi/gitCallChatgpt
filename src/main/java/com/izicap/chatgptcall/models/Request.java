package com.izicap.chatgptcall.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {
    private String model;
    private String prompt;
    @JsonProperty("max_tokens")
    private int maxTokens;
    private double temperature;



    public Request() {}

    public Request(String prompt) {
        this.model = "text-davinci-003";
        this.prompt = prompt;
        this.maxTokens = 4000;
        this.temperature = 1.0;
    }

    public Request(String model, String prompt, int maxTokens, double temperature) {
        this.model = model;
        this.prompt = prompt;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }


}
