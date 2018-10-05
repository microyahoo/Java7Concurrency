package com.njupt.demo5;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String>
{
	private String sender;
	private String title;
	
	public ReportGenerator(String sender, String title) {
		super();
		this.sender = sender;
		this.title = title;
	}

	@Override
	public String call() throws Exception 
	{
		try {
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s_%s: ReportGenerator: Generating a report during %d seconds.\n",this.sender, this.title, duration);
			TimeUnit.SECONDS.sleep(duration);//睡眠
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sender + ": " + title;
	}

}
