package aBeengers20;

import java.awt.*;
import javax.swing.*;

public class Clock3 extends JFrame implements Runnable {
	public static Thread timethread;

	public Clock3() {
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

				Game3.second.setText(result);

				Thread.sleep(1000);// 1ÃÊ °æ°ú

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
