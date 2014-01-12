package com.example.listviewtest;

public class LunchMenu {
	public String name;
	public int value;
	
	public LunchMenu(String name, int value){
		this.name = name;
		this.value = value;
	}
	
	public String lunchName(){
		return name;
	}
	
	public int lunchValue(){
		return value;
	}
	
	@Override
	public String toString(){
		return "メニュー名 ： " + name + "  価格 : " + value + "円" ;
	}

}
