package com.company;

import com.company.exceptions.AlreadySubscribed;
import com.company.exceptions.ExistingClient;
import com.company.exceptions.NonExistingClient;
import com.company.model.Client;
import com.company.model.Event;
import com.company.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    ClientService client;
    ArrayList<Client> clientArrayList = new ArrayList<>();

    @PostMapping("/addClient")
    public void addClient(@RequestBody Client client) throws ExistingClient{
        if(clientArrayList.contains(client)) {
            throw new ExistingClient("Client with name " + client.getName() + " exists!");
        }
        clientArrayList.add(new Client(client.getName()));
    }

    @PostMapping("subscribe/{name}")
    public void subscribeClient(@PathVariable String name, @RequestBody Subject s) throws NonExistingClient, AlreadySubscribed {
        if(!clientArrayList.contains(new Client(name))) {
            throw new NonExistingClient("Client " + name + " doesn't exist!");
        }
        if(client.checkIfSubscribed(s)) {
            throw new AlreadySubscribed("Client already subscribed!");
        }
        client.subscribe(s);
    }

    @GetMapping("display/{name}")
    public void DisplayEvent(@PathVariable String name) {
       client.DisplayEvents(name);
    }
}
