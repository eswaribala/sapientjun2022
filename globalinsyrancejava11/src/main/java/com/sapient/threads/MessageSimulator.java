package com.sapient.threads;

import com.sapient.models.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageSimulator implements Runnable{

    private List<Message> messages;

    public MessageSimulator(List<Message> messages) {
        this.messages=new ArrayList<>();
    }

    public synchronized void produceMessage(){

       while(true) {
           if (messages.size() == 0) {
               for (int i = 0; i < 100; i++) {
                   messages.add(new Message(i, "Message" + i));
               }
               notify();
           } else {
               try {
                   wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       }

    }

    public synchronized void consumeMessage(){

        while(true) {
            if (this.messages.size() > 0) {
                for (Message message : messages)
                    System.out.println(message);

                messages.clear();
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    public void run() {

        if(Thread.currentThread().getName().equals("Producer"))
            produceMessage();
        else
            consumeMessage();

    }
}
