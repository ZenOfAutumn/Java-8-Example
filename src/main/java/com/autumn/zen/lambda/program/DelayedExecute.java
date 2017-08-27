package com.autumn.zen.lambda.program;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class DelayedExecute {
	
	private static Logger logger = Logger.getLogger(DelayedExecute.class.getName());
	
	public static void info(Logger logger,Supplier<String> message){
		if(logger.isLoggable(Level.INFO)){
			logger.info(message.get());
		}
	}
	
	@Test
	public void delayLog(){
		
		final int x = 1;
		final int y = 2;
		info(logger,new Supplier<String>() {
			@Override
			public String get() {
				return "x: " +x+" y: "+ y;
			}
		});
	}
	
	@Test
	public void testLambdaLog(){
		int x= 1;
		int y =2;
		logger.info(()->"x: " +x+" y: "+ y);
	}
	
	

}
