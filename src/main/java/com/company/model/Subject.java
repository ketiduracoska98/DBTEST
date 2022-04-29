package com.company.model;

import com.company.Observer;
import java.util.ArrayList;

public class Subject {
    private String name;
    private ArrayList<Event> eventList;
    private ArrayList<Observer> observers;
    public Subject(String name) {
        this.name = name;
        eventList = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public String getName() {
        return name;
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void addEvent(String clientName, Event e) {
        this.eventList.add(e);
        for(Observer o : observers) {
            o.receiveNotification(clientName, this, e);
        }
    }
}
