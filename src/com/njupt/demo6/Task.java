package com.njupt.demo6;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable
{
	private String name;
	
	public Task(String name)
	{
		this.name = name;
	}
	
	@Override
	public void run() 
	{
		System.out.println("Task " + name + ": Starting.");
		try {
			long duration = (long) (Math.random() * 10);
			System.out.printf("Task_%s: ReportGenerator: Generating a report during %d seconds.\n",this.name, duration);
			TimeUnit.SECONDS.sleep(duration);//睡眠
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.printf("Task %s: Ending.\n", name);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
