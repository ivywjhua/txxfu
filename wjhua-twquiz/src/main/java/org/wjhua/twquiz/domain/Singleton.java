package org.wjhua.twquiz.domain;

public class Singleton {

	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		return  SingletonHolder.instance;
	}
	
	private static class SingletonHolder {
		private static Singleton instance = new Singleton();
	}
	
}
