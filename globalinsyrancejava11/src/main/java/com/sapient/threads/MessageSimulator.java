package com.sapient.threads;

import com.sapient.models.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageSimulator implements Runnable{

    private List<Message> messages;

    public MessageSimulator() {
        this.messages=new ArrayList<>();
    }

    public synchronized void produceMessage(){

       while(true) {
           if (messages.size() == 0) {
               System.out.println("Message Not found in List....");
               for (int i = 0; i < 100; i++) {
                   messages.add(new Message(i, "Message" + i));
               }
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
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
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                messages.clear();
                notify();
            } else {
                try {
                    System.out.println("Waiting for the message");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    public void run() {
      // System.out.println(Thread.currentThread().getName());
        if(Thread.currentThread().getName().equals("Producer"))
            produceMessage();
        else
            consumeMessage();

    }
}
