package aBeengers20;

import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Change4 extends JFrame {

	Music music;

	Change4() throws MalformedURLException {

		setTitle("ABEENGERS");
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		music = new Music("데굴데굴.mp3", true);
		music.start();

		GifBackGroundPanel background = new GifBackGroundPanel(new ImageIcon("./image/전환후보4.gif").getImage());

		add(background);
		pack();

		Timer t = new Timer();

		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				music.close();
				setVisible(false);
				dispose();

				new Game4(); // 게임4로 이동
			}

		};

		t.schedule(tt, 2125);
	}
}