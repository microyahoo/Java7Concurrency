package com.njupt.demo6;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main 
{
	public static void main(String[] args) 
	{
		RejectedTaskController controller = new RejectedTaskController();
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		System.out.println(executor);
		executor.setRejectedExecutionHandler(controller);
		System.out.println("Main: Starting");
		
		for(int i = 0; i < 3; i ++)
		{
			Task task = new Task("Task " + i);
			executor.submit(task);
		}
		
		System.out.println("Main: Shutting down the Executor.");
		executor.shutdown();
		
		System.out.println("Main: Sending another Task.");
		Task task = new Task("RejectedTask");
		executor.submit(task);
		
		System.out.println("Main: End.");
//		System.out.println("");
	}
}
