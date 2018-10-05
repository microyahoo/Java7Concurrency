package com.njupt.demo5;

import java.util.concurrent.CompletionService;

//在一个对象里发送任务给执行器，然后再另一个对象里处理结果

public class ReportRequest implements Runnable
{
	private String name;
	
	private CompletionService<String> service;
	
	public ReportRequest(String name, CompletionService<String> service) {
		super();
		this.name = name;
		this.service = service;
	}

	@Override
	public void run() {
		ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
		service.submit(reportGenerator);//执行
	}

}
