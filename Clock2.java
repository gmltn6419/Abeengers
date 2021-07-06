package aBeengers20;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Clock2 extends JFrame implements Runnable {
	static Thread timethread;

	public Clock2() {
		// TODO Auto-generated method stub
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

				Game2.second.setText(result);

				Thread.sleep(1000);// 1ÃÊ °æ°ú

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}