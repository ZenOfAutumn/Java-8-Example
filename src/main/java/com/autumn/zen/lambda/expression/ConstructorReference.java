package com.autumn.zen.lambda.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructorReference {
	
	
	static class Button{
		
		private String label;
		
		private int order;
		
		public Button(String label,int order) {
			this.label = label;
			this.order = order;
		}
		
		public Button(String label) {
			this.label = label;
		}
		
		public String getLabel() {
			return label;
		}
		
		public int getOrder() {
			return order;
		}
	}
	
	
	static List<Button> buildButtons(List<String> labels){
		Stream<Button> stream = labels.stream().map(Button::new);
		return stream.collect(Collectors.toList());
	}
	
	static Button[] buildButtonsArray(List<String> labels){
		Stream<Button> stream = labels.stream().map(Button::new);
		Button[] buttons = stream.toArray(Button[]::new);
		return buttons;
	}
	
	
	public static void main(String[] args) {
		System.out.println(buildButtonsArray(new ArrayList<String>(){ 
			{this.add("1");};
		}).length);
		
	}
	
	

}
