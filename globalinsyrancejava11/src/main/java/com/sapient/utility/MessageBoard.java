package com.sapient.utility;

import com.sapient.threads.MessageSimulator;

public class MessageBoard {

    public static void main(String[] args){
        Thread thread1=new Thread(new MessageSimulator(),"Producer");
        Thread thread2=new Thread(new MessageSimulator(),"Consumer");
        thread1.start();
        thread2.start();
    }
}
