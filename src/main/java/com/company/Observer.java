package com.company;

import com.company.model.Event;
import com.company.model.Subject;

public interface Observer {
    void receiveNotification(String name, Subject s, Event e);
}
