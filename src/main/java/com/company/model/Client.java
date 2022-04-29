package com.company.model;

import com.company.Observer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class Client implements Observer {
    private String name;
    private List<Subject> subjects;

    public Client() {

    }
    public Client(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public void receiveNotification(String name, Subject s, Event e) {
        if(this.name.equals(name) && subjects.contains(s)) {
            System.out.println("Client " + name+ " New post at " +e.getTitle() + " with topic " + e.getTopic());
        }
    }

}
