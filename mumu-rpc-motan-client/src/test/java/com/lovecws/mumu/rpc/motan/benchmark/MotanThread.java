package com.lovecws.mumu.rpc.motan.benchmark;

import com.lovecws.mumu.rpc.motan.service.FooService;

import java.util.concurrent.CountDownLatch;

public class MotanThread extends Thread{

    private CountDownLatch countDownLatch;
    private FooService fooService;
    private String message;

    public MotanThread(CountDownLatch countDownLatch,FooService fooService,String message){
        this.countDownLatch=countDownLatch;
        this.fooService=fooService;
        this.message=message;
    }

    @Override
    public void run() {
        super.run();
        String hello = fooService.hello(message);
        countDownLatch.countDown();
    }
}
