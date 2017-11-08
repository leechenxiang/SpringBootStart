package com.leecx.tasks;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
    
	@Async
	public Future<String> doTask1() throws Exception {
	    System.out.println("开始做任务1");
	    long start = System.currentTimeMillis();
	    Thread.sleep(400);
	    long end = System.currentTimeMillis();
	    System.out.println("完成任务1，耗时：" + (end - start) + "毫秒");
	    return new AsyncResult<>("任务1完成");
	}
	
	@Async
	public Future<String> doTask2() throws Exception {
	    System.out.println("开始做任务2");
	    long start = System.currentTimeMillis();
	    Thread.sleep(600);
	    long end = System.currentTimeMillis();
	    System.out.println("完成任务2，耗时：" + (end - start) + "毫秒");
	    return new AsyncResult<>("任务2完成");
	}
	
	@Async
	public Future<String> doTask3() throws Exception {
	    System.out.println("开始做任务3");
	    long start = System.currentTimeMillis();
	    Thread.sleep(300);
	    long end = System.currentTimeMillis();
	    System.out.println("完成任务3，耗时：" + (end - start) + "毫秒");
	    return new AsyncResult<>("任务3完成");
	}
}
