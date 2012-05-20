package org.wjhua.twquiz.domain2;

import java.util.Random;

public class TestThread {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			final int nextInt = new Random().nextInt(10) * 100;
			Thread t = new Thread("t" + i) {
				@Override
				public void run() {
					try {
						Thread.sleep(nextInt);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(this.getName() + "\t" + nextInt);

				}

			};
			t.start();
			try {
				t.join(nextInt);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("aaaaaaaaaaaaaa");
		// try {
		// Thread.currentThread().join();
		// System.out.println("aaaaaaaaaaaaaa");
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
	}
}
