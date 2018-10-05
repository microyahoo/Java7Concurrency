package com.njupt.demo4;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//可使用 FutureTask 包装 Callable 或 Runnable 对象。因为 FutureTask 实现了 Runnable，所以可将 FutureTask 提交给 Executor 执行。 
//除了作为一个独立的类外，此类还提供了 protected 功能，这在创建自定义任务类时可能很有用。

public class ResultTask extends FutureTask<String>//就相当于一个包装类的作用
{
	private String name;
	
	public ResultTask(Callable<String> callable) {
		super(callable);
		this.name = ((ExecutableTask)callable).getName();
	}
	
	@Override
	protected void done() {//当任务执行结束时，FutureTask类就会调用done()方法
		if(isCancelled())
		{
			System.out.printf("%s: Has been cancelled.\n", name);
		}else {
			System.out.printf("%s: Has finished.\n", name);
		}
	}
}
