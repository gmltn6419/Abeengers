package aBeengers20;

import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import javax.swing.*;

public class Dubutton extends JPanel implements ActionListener {
	JButton bt = new JButton(new ImageIcon("./image/구멍.png"));
	Random r = new Random();
	static Timer m_timer = new Timer();
	static TimerTask m_task;

	Dubutton() {
		bt.setContentAreaFilled(false);// 배경채우기
		bt.setBorderPainted(false);// 테두리
		bt.setFocusPainted(false);// 눌렀을때 테두리
		bt.setVisible(true);
		bt.setDisabledIcon(new ImageIcon("./image/구멍.png"));
		bt.setEnabled(false);// 여러번 x
		bt.addActionListener(this);
		add(bt);

		ImageIcon dudu, gumang;
		dudu = new ImageIcon("./image/올라왔다내려가는두더지.gif");
		gumang = new ImageIcon("./image/구멍.png");

		// boolean yorn = r.nextBoolean();
		// if(yorn != 0)

		Timer b_timer = new Timer(); // 전체 게임 타이머
		TimerTask b_task = new TimerTask() {

			@Override
			public void run() {

				m_timer.cancel();

				for (int i = 0; i < 16; i++) {
					Game1.db1[i].bt.setIcon(gumang);
				}

				Clock1.timethread.interrupt();
				Main.score[0] = Game1.myrank;//게임1 점수 저장
				
				Timer delay = new Timer(); // 게임 끝난 후
				TimerTask delayt = new TimerTask() {

					@Override
					public void run() {

						Game1.gameresult.setVisible(true);
						Game1.nextgame.bt.setVisible(true);
					}

				};

				delay.schedule(delayt, 1500); // 3초간 정지!!!
			}
		};

		b_timer.schedule(b_task, 30000); // 두더지 게임시간 @@@@@@@@@@@@@@@@@@

		TimerTask m_task = new TimerTask() {

			@Override
			public void run() {
				boolean yorn = r.nextBoolean();
				if (yorn != true) {
					bt.setIcon(dudu);
					bt.setDisabledIcon(dudu);
					bt.setEnabled(true);

					TimerTask d_task = new TimerTask() {
						@Override
						public void run() {
							if (bt.getIcon() == dudu) {
								bt.setEnabled(false);
								bt.setIcon(new ImageIcon("./image/구멍.png"));
								bt.setDisabledIcon(new ImageIcon("./image/구멍.png"));
							}

						}
					};
					m_timer.schedule(d_task, 2700);
				}
			}
		};
		m_timer.schedule(m_task, 1000, 3000);
		this.m_task = m_task;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		bt.setIcon(new ImageIcon("./image/내려가는두더지.gif"));
		bt.setDisabledIcon(new ImageIcon("./image/내려가는두더지.gif"));
		bt.setEnabled(false);// 여러번 x
		bt.setBorderPainted(false);// 테두리
		bt.setFocusPainted(false);// 눌렀을때 테두리
		bt.setContentAreaFilled(false);// 배경채우기

		Game1.myrank += 5;// 점수증가
		Game1.score.setText(Integer.toString(Game1.myrank));

		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {

			@Override
			public void run() {

				bt.setIcon(new ImageIcon("./image/구멍.png"));
				bt.setDisabledIcon(new ImageIcon("./image/구멍.png"));
				bt.setEnabled(false);
				bt.setOpaque(false);
			}
		};

		m_timer.schedule(m_task, 800);

	}
}