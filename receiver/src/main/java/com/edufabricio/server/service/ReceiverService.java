package com.edufabricio.server.service;

import com.edufabricio.server.jpa.MessageReceived;
import com.edufabricio.server.repository.MessageReceivedRepository;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReceiverService {

    @Autowired
    private MessageReceivedRepository messageReceivedRepository;

    public void receive(BasicDBObject message) {

        MessageReceived messageReceived = new MessageReceived();
        messageReceived.setMessage(message.getString("message"));
        messageReceived.setSendAt(new Date());

        messageReceivedRepository.save(messageReceived);
    }
}
