package org.wjhua.twquiz.domain2;

public class ReleaseMain {

	public int releaseNumberCompare(String release1, String release2){
		String[] strArray1 = release1.split(".");
		String[] strArray2 = release2.split(".");
		
		int[] numArray1 = new int[]{strArray1.length};
		int[] numArray2 = new int[]{strArray2.length};
		for (int i = 0; i < strArray1.length; i++) {
			numArray1[i] = Integer.valueOf(strArray1[i]);
		}
		for (int i = 0; i < strArray2.length; i++) {
			numArray2[i] = Integer.valueOf(strArray2[i]);
		}
		
		
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		
	}
}
