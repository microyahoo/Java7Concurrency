package com.njupt.demo7;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter
{
	@Override
	public String format(LogRecord record) 
	{
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("[" + record.getLevel() + "]");
		sBuffer.append(new Date(record.getMillis()) + ": ");
		sBuffer.append(record.getSourceClassName() + "." + record.getSourceMethodName() + ":");
		sBuffer.append(record.getMessage() + "\n");
		return sBuffer.toString();
	}

}
