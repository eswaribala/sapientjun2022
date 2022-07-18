package com.sapient.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class SelectorDemo {
    private static final Logger logger = LoggerFactory
            .getLogger(SelectorDemo.class);
    public static void main(String[] args){
        try {
            Selector selector= Selector.open();
            ServerSocketChannel serverSocketChannel=
                    ServerSocketChannel.open();
            InetSocketAddress inetSocketAddress=new
                    InetSocketAddress("localhost"
                    ,27017);
            serverSocketChannel.bind(inetSocketAddress);
            serverSocketChannel.configureBlocking(false);
            int ops=serverSocketChannel.validOps();
            SelectionKey selectionKey=serverSocketChannel
                    .register(selector,ops,null);
            for(;;){

            }

        } catch (IOException e) {
            logger.info(e.getMessage());
        }

    }
}
