package org.wjhua.twquiz.domain2;

public class Singleton {

	private static Singleton instance;

	private static Object syncObject = new Object();

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (null == instance) {
			synchronized (syncObject) {
				if (null == instance) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
