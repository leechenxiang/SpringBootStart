package com.leecx.tasks;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks")
public class DoTask {
	
    public void doTask1() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时:" + (end - start) + "毫秒");
    }
    
    public void doTask2() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时:" + (end - start) + "毫秒");
    }
    
    public void doTask3() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(600);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时:" + (end - start) + "毫秒");
    }
    
    @RequestMapping("test1")
    public String test1() throws Exception {
    	
    	doTask1();
    	doTask2();
    	doTask3();
    	
    	return null;
    }
    
    @Autowired
    private AsyncTask asyncTask;
    
    @RequestMapping("test2")
    public String test2() throws Exception {
    	long start = System.currentTimeMillis();
    	Future<String> task1 = asyncTask.doTask1();
    	Future<String> task2 = asyncTask.doTask2();
    	Future<String> task3 = asyncTask.doTask3();
    	while(true) {
    		if(task1.isDone() && task2.isDone() && task3.isDone()) {
    			// 三个任务都调用完成，退出循环等待
    			break;
    		}
    		Thread.sleep(200);
    	}
    	long end = System.currentTimeMillis();
    	
    	String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
    	System.out.println(times);
    	
    	return times;
    }
    
}
