package com.autumn.zen.lambda.expression;

import java.util.Comparator;

public class LambdaExpression {
	
	
	// params,arrow,expression
	// Examples: (String left,String right)->Integer.compare(left.length(),right.length())
	
	Comparator<String> comparatorOfString(){
		return (left,right)->{if(left.length()<right.length()){
			return -1;
		}else if(left.length()>right.length()){
			return 1;
		}else{
			return 0;
		}
		};
	}
	
	
	
	

}
