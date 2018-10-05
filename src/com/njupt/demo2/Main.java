package com.njupt.demo2;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main 
{
	public static void main(String[] args) 
	{
//		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		ScheduledThreadPoolExecutor service = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

		//可以设置此值为true，这样调用shutdown()方法后，周期性任务仍将继续执行
//		service.setContinueExistingPeriodicTasksAfterShutdownPolicy(true);
//		service.setExecuteExistingDelayedTasksAfterShutdownPolicy(true);
		
		System.out.printf("Main: Starting at : %s\n" , new Date());
		
		Task task = new Task("Task");
		
		ScheduledFuture<?> result = service.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
		
		for(int i = 0; i < 10; i ++)
		{
			System.out.printf("Main: Delay : %d\n" , result.getDelay(TimeUnit.MILLISECONDS));
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		service.shutdown();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Finished at : %s\n" , new Date());
	}
}
