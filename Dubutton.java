package aBeengers20;

import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import javax.swing.*;

public class Dubutton extends JPanel implements ActionListener {
	JButton bt = new JButton(new ImageIcon("./image/����.png"));
	Random r = new Random();
	static Timer m_timer = new Timer();
	static TimerTask m_task;

	Dubutton() {
		bt.setContentAreaFilled(false);// ���ä���
		bt.setBorderPainted(false);// �׵θ�
		bt.setFocusPainted(false);// �������� �׵θ�
		bt.setVisible(true);
		bt.setDisabledIcon(new ImageIcon("./image/����.png"));
		bt.setEnabled(false);// ������ x
		bt.addActionListener(this);
		add(bt);

		ImageIcon dudu, gumang;
		dudu = new ImageIcon("./image/�ö�Դٳ������µδ���.gif");
		gumang = new ImageIcon("./image/����.png");

		// boolean yorn = r.nextBoolean();
		// if(yorn != 0)

		Timer b_timer = new Timer(); // ��ü ���� Ÿ�̸�
		TimerTask b_task = new TimerTask() {

			@Override
			public void run() {

				m_timer.cancel();

				for (int i = 0; i < 16; i++) {
					Game1.db1[i].bt.setIcon(gumang);
				}

				Clock1.timethread.interrupt();
				Main.score[0] = Game1.myrank;//����1 ���� ����
				
				Timer delay = new Timer(); // ���� ���� ��
				TimerTask delayt = new TimerTask() {

					@Override
					public void run() {

						Game1.gameresult.setVisible(true);
						Game1.nextgame.bt.setVisible(true);
					}

				};

				delay.schedule(delayt, 1500); // 3�ʰ� ����!!!
			}
		};

		b_timer.schedule(b_task, 30000); // �δ��� ���ӽð� @@@@@@@@@@@@@@@@@@

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
								bt.setIcon(new ImageIcon("./image/����.png"));
								bt.setDisabledIcon(new ImageIcon("./image/����.png"));
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

		bt.setIcon(new ImageIcon("./image/�������µδ���.gif"));
		bt.setDisabledIcon(new ImageIcon("./image/�������µδ���.gif"));
		bt.setEnabled(false);// ������ x
		bt.setBorderPainted(false);// �׵θ�
		bt.setFocusPainted(false);// �������� �׵θ�
		bt.setContentAreaFilled(false);// ���ä���

		Game1.myrank += 5;// ��������
		Game1.score.setText(Integer.toString(Game1.myrank));

		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {

			@Override
			public void run() {

				bt.setIcon(new ImageIcon("./image/����.png"));
				bt.setDisabledIcon(new ImageIcon("./image/����.png"));
				bt.setEnabled(false);
				bt.setOpaque(false);
			}
		};

		m_timer.schedule(m_task, 800);

	}
}