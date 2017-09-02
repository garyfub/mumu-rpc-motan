package com.lovecws.mumu.rpc.motan.benchmark.motan;

import com.lovecws.mumu.rpc.motan.benchmark.client.AbstractBenchmarkClientRunnable;
import com.lovecws.mumu.rpc.motan.benchmark.service.BenchmarkService;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MotanBenchmarkClientRunnable extends AbstractBenchmarkClientRunnable {

    public MotanBenchmarkClientRunnable(BenchmarkService benchmarkService, String params, CyclicBarrier barrier, CountDownLatch latch, long startTime, long endTime) {
        super(benchmarkService, barrier, latch, startTime, endTime);
    }

    private static String SEND_MESSAGE=null;
    static {
        StringBuilder builder=new StringBuilder();
        while (builder.toString().getBytes().length<1024*512){
            builder.append("lovecws");
        }
        SEND_MESSAGE=builder.toString();
    }
    @Override
    protected Object call(BenchmarkService benchmarkService) {
        String hello = ((MotanBenchmarkServiceImpl) benchmarkService).getFooService().hello(SEND_MESSAGE);
        System.out.println(hello);
        return hello;
        //return benchmarkService.execute("hello",new Class[]{String.class},new Object[]{"lovecws"});
    }
}
