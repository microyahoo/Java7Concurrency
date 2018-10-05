package com.njupt.demo5;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ReportProcessor implements Runnable
{
	private CompletionService<String> service;
	
	private boolean end;
	
	public ReportProcessor(CompletionService<String> service) {
		super();
		this.service = service;
		end = false;
	}
	
	public void setEnd(boolean end)
	{
		this.end = end;
	}

	@Override
	public void run() {
		while(!end)
		{
			try {
				//获取并移除表示下一个已完成任务的 Future，如果目前不存在这样的任务，则将等待指定的时间（如果有必要）。 
				//返回值表示下一个已完成任务的 Future；如果等待了指定时间仍然不存在这样的任务，则返回 null 
//				Future<String> result = service.poll(20, TimeUnit.SECONDS);
				Future<String> result = service.poll();
				
				if(result != null)
				{
					String report = result.get();
					System.out.println("ReportReceiver: Report Received: " + report);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("ReportSender: End.");
	}

}
