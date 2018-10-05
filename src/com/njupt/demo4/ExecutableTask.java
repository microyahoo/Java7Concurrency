package com.njupt.demo4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String>
{
	private String name;
	
	public ExecutableTask(String name)//strictfp
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public String call() throws Exception 
	{
		try {
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: Waiting %d seconds for results.\n",this.name, duration);
			TimeUnit.SECONDS.sleep(duration);//睡眠
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Hello, World. I'm " + name;
	}

}
