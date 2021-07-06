package aBeengers20;

import java.awt.*;
import javax.swing.*;

public class Clock4 extends JFrame implements Runnable {
	static Thread timethread;

	Clock4() {
		if (timethread == null) {
			timethread = new Thread(this);
			timethread.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			long time1 = System.currentTimeMillis();
			while (true) {
				long time2 = System.currentTimeMillis();

				String result;
				result = String.valueOf((int) ((time2 - time1) / 1000.0));

				Game4.time = result;

				Thread.sleep(1000);// 1ÃÊ °æ°ú

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}