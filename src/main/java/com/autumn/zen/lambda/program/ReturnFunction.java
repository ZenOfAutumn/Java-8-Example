package com.autumn.zen.lambda.program;

import java.util.function.UnaryOperator;

import org.junit.Assert;
import org.junit.Test;


public class ReturnFunction {
	
	// 1.return UnaryOperator
	
	public static UnaryOperator<String> replace(String regex,String replacement){
		return s->s.replaceAll(regex, replacement);
	}
	
	public static String process(String ori,UnaryOperator<String> uop){
		return uop.apply(ori);
	}

	@Test
	public void testReplace(){
		Assert.assertEquals("2", process("1", replace("1", "2")));
	}
	
	
}
