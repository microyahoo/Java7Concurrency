package com.njupt.demo4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main 
{
	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
		ExecutorService service = Executors.newCachedThreadPool();
		ResultTask[] resultTasks = new ResultTask[5];
		
		for(int i = 0; i < 5; i ++)
		{
			ExecutableTask task = new ExecutableTask("Task " + i);
			resultTasks[i] = new ResultTask(task);
			service.submit(resultTasks[i]);
//			service.submit(task);
		}
		
		TimeUnit.SECONDS.sleep(5);
		
		for(int i = 0; i < resultTasks.length; i ++)
		{
			resultTasks[i].cancel(true);//取消任务
		}
		
		for(int i = 0; i < resultTasks.length; i ++)
		{
			if(! resultTasks[i].isCancelled())
			{
				System.out.println(resultTasks[i].get());
			}
		}
		
		service.shutdown();
	}
}
