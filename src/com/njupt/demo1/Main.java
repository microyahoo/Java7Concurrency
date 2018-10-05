package com.njupt.demo1;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		
		System.out.printf("Main: Starting at : %s\n" , new Date());
		
		for(int i = 0; i < 5; i ++)
		{
			Task task = new Task("Task " + i);
//			service.submit(task);
			service.schedule(task, i + 1, TimeUnit.SECONDS);
		}
		
		service.shutdown();
		
//		System.out.println("Hello world");
		
		try {
			service.awaitTermination(1, TimeUnit.DAYS);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		Thread.sleep(3000);
		System.out.printf("Main: Ends at : %s\n" , new Date());
	}
}
