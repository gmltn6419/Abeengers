package aBeengers20;

import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Change2 extends JFrame {

	Music music;

	Change2() throws MalformedURLException {

		setTitle("ABEENGERS");
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		music = new Music("잠자는애.mp3", true);
		music.start();

		GifBackGroundPanel background = new GifBackGroundPanel(new ImageIcon("./image/전환후보2.gif").getImage());

		add(background);
		pack();

		Timer t = new Timer();

		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				music.close();
				setVisible(false);
				dispose();

				try {
					new Game2();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		};

		t.schedule(tt, 5000);
	}
}