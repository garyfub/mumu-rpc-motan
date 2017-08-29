package com.lovecws.mumu.rpc.motan.benchmark;

import com.lovecws.mumu.rpc.motan.service.FooService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class MotanBenchmark {

    @Test
    public void testEmptyString(){
        run(10000,"");
    }
    @Test
    public void testString(){
        run(10000,"sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaawwwwwwwwwwwwwwwwwwwwwwweeeeeeeeeeee");
    }
    public void run(int currency,String message){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-motan.xml");
        FooService service = (FooService) ctx.getBean(FooService.class);

        CountDownLatch countDownLatch=new CountDownLatch(currency);
        long startTime=System.currentTimeMillis();
        for (int i=0;i<currency;i++){
            new MotanThread(countDownLatch,service,message).start();
        }
        try {
            countDownLatch.await();
            long endTime=System.currentTimeMillis();
            System.out.println("消费时间:"+(endTime-startTime)+"ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
