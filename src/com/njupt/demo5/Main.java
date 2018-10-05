package com.njupt.demo5;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main 
{
	public static void main(String[] args) 
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		System.out.println(executor.getClass());
		
		//通常，CompletionService 依赖于一个单独的 Executor 来实际执行任务，在这种情况下，
		//CompletionService 只管理一个内部完成队列。ExecutorCompletionService 类提供了此方法的一个实现。
		CompletionService<String> service = new ExecutorCompletionService<>(executor);
		
		ReportRequest faceRequest = new ReportRequest("Face", service);
		ReportRequest onlineRequest = new ReportRequest("Online", service);
		Thread faceThread = new Thread(faceRequest);
		Thread onlineThread = new Thread(onlineRequest);
		
		ReportProcessor processor = new ReportProcessor(service);
		Thread senderThread = new Thread(processor);
		
		System.out.println("Main: Starting the Threads.");
		faceThread.start();
		onlineThread.start();
		senderThread.start();
		
		try {
			System.out.println("Main: Waiting for the report generators.");
			faceThread.join();
			onlineThread.join();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Main: Shutting down the executor.");
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		processor.setEnd(true);
		System.out.println("Main: Ends.");
	}
}
