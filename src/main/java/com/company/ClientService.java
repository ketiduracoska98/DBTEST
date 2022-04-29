package com.company;

import com.company.model.Client;
import com.company.model.Event;
import com.company.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    Client client;

    public void subscribe(Subject s) {
        client.getSubjects().add(s);
    }
    public boolean checkIfSubscribed(Subject s) {
        return client.getSubjects().contains(s);
    }
    public void DisplayEvents(String name) {
        if(client.getName().equals(name)) {
            for(Subject s:  client.getSubjects()) {
                for(Event e : s.getEventList()) {
                    System.out.println(name + " subject " + s + " title" + e.getTitle() + " event topic" + e.getTopic());
                }
            }
        }

    }
}
