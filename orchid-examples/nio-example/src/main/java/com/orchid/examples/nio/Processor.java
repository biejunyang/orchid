package com.orchid.examples.nio;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.nio.channels.SelectionKey;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * Processor类中设置一个线程池来处理请求，
 * 这样就可以充分利用多线程的优势
 */
public class Processor {
    private static final ExecutorService service = Executors.newFixedThreadPool(1);


    public void process(final SelectionKey selectionKey){
        service.submit(new Handler());
    }
}
