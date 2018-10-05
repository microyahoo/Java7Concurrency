package com.njupt.demo3;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		Task task = new Task();
		
		System.out.println("Main: Executing the Task");
		
		Future<String> result = executor.submit(task);
		
		TimeUnit.SECONDS.sleep(2);
		
		System.out.println("Main: Canceling the Task");
		
		result.cancel(true);//取消任务
		
		System.out.printf("Main: Cancelled: %s\n", result.isCancelled());
		System.out.printf("Main: Done: %s\n", result.isDone());
		
		executor.shutdown();
		System.out.println("Main: The executor has finished.");
	}
}
