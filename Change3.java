package aBeengers20;

import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Change3 extends JFrame {

	Music music;

	Change3() throws MalformedURLException {

		setTitle("ABEENGERS");
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		music = new Music("�����̴� ��.mp3", true);
		music.start();

		GifBackGroundPanel background = new GifBackGroundPanel(new ImageIcon("./image/��ȯ�ĺ�3.gif").getImage());

		add(background);
		pack();

		Timer t = new Timer();

		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				music.close();
				setVisible(false);
				dispose();

				new Game3(); // ����3���� �̵�
			}

		};

		t.schedule(tt, 5550);
	}
}