package com.sapient.utility;

import com.sapient.threads.MessageSimulator;

public class MessageBoard {

    public static void main(String[] args){
        //Inter thread communication
        MessageSimulator messageSimulator=new MessageSimulator();
        Thread thread1=new Thread(messageSimulator,"Producer");
        Thread thread2=new Thread(messageSimulator,"Consumer");
        thread1.start();
        thread2.start();
    }
}
