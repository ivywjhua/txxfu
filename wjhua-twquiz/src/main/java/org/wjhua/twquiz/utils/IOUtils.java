package org.wjhua.twquiz.utils;

import java.io.Closeable;

public class IOUtils {

	/**
	 * Close closeable object quietly.
	 * 
	 * @param in
	 */
	public static void closeQuietly(Closeable in) {
		if (null != in) {
			try {
				in.close();
			} catch (Exception e) {
				// ignore
			}
		}
	}
}
