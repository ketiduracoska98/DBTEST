package com.company.model;

public class Event {
    private String title;
    private String topic;

    public Event(String title, String topic) {
        this.title = title;
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }
}
