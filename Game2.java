package aBeengers20;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Game2 extends JFrame implements ActionListener {

	Music music, bts, bbi;

	PngBackGroundPanel gameresult; // ���� ���� ���â
	NextButton nextgame; // ���� �������� �Ѿ�� ��ư
	NextButton round2; // ����2 �׸�
	NextButton next; // ���� "Ŭ��" ���� ��ư
	NextButton pan; // ȭ��ǥ���� �ö󰡴� �Ǵ��

	static int round;
	static int now;
	static JLabel second;
	static JPanel pan_panel; // �Ǵ�� �г�

	static int[] random_arrow = new int[27]; // �������� ���� ����(0~3)
	static ArrowButton[] arrow1 = new ArrowButton[27];// ȭ��ǥ ��� ����(0=��/1=�Ʒ�/2=��/3=��)

	static int myrank;
	static String rank;
	static JLabel score;

	Game2() throws MalformedURLException {
		// ������ ����
		setTitle("ABEENGERS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Dimension dim = new Dimension(1280, 750); // ������ũ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);
		// setLocationRelativeTo(null);
		setPreferredSize(dim);
		setVisible(true);

		second = new JLabel("0");
		Font font = new Font("������S", Font.BOLD, 100);
		Color color = new Color(229, 0, 0);
		second.setFont(font);
		second.setForeground(color);
		second.setBounds(1100, 20, 200, 100);

		// �뷡 ����
		music = new Music("�Ǵ�.mp3", true);
		music.start();// ����~

		// ���ȭ�� - ���x
		NextButton background = new NextButton("�Ǵ�.gif");
		background.bt.setSize(1280, 720);
		background.bt.setLocation(0, 0);

		// ���Ӱ�� ȭ�� - ���� ������ ��
		gameresult = new PngBackGroundPanel(new ImageIcon("./image/2������Ӱ��.png").getImage());
		gameresult.setVisible(false);

		// ���� �������� �Ѿ�� ��ư
		nextgame = new NextButton("Ŭ��_�̷���.png");
		nextgame.bt.setPreferredSize(new Dimension(1280, 720));
		nextgame.bt.setSize(200, 150);
		nextgame.bt.setLocation(930, 460); // ��ġ ����
		// setPreferredSize, setSize ����� ��ư�� ����
		nextgame.bt.setVisible(false);
		nextgame.bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				music.close();
				setVisible(false);
				dispose();

				try {
					new Change3(); // ��ȯ3���� �̵�
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}); // ���⿡ �̺�Ʈ�� �ְڵ�

		// ���� â
		round2 = new NextButton("����2.png");
		round2.bt.setSize(1280, 720);
		round2.bt.setLocation(0, 0);

		// ���� â : �ؽ�Ʈ ��ư - �׼� ����
		next = new NextButton("����.png");
		next.bt.setSize(150, 150);
		next.bt.setLocation(567, 508);
		next.bt.addActionListener(this);

		// �� - �׼� ����
		pan = new NextButton("�Ǵ��.png");
		pan.bt.setSize(993, 441);
		pan.bt.setLocation(143, 70);
		pan.bt.setVisible(false);

		// (��ɾ��¹�ư) pan ���� ���� ũ���� �г��� ����� ��. ���� ���� ȭ��ǥ �߰� ����
		pan_panel = new JPanel();
		pan_panel.setSize(993, 441);
		pan_panel.setLocation(143, 70);
		pan_panel.setLayout(new GridLayout(3, 9, 5, 10));
		pan_panel.setOpaque(false);
		pan_panel.setVisible(false);

		round = 9;
		this.now = 0;

		// **************************************************************
		// ȭ��ǥ ���� �����ؼ� ȭ�鿡 �ѷ��ֱ�

		Random random = new Random();

		for (int i = 0; i < round; i++) {
			random_arrow[i] = random.nextInt(4);
			this.random_arrow[i] = random_arrow[i];

			if (random_arrow[i] == 0) {
				arrow1[i] = new ArrowButton("ȭ��ǥ_��.png");
			}

			else if (random_arrow[i] == 1) {
				arrow1[i] = new ArrowButton("ȭ��ǥ_�Ʒ�.png");
			}

			else if (random_arrow[i] == 2) {
				arrow1[i] = new ArrowButton("ȭ��ǥ_��.png");
			}

			else {
				arrow1[i] = new ArrowButton("ȭ��ǥ_��.png");
			}

			this.arrow1[i] = arrow1[i];
		}

		// **************************************************************

		add(nextgame);
		add(gameresult);
		add(pan_panel);
		add(pan);
		add(next);
		add(round2);
		add(second);

		setFocusable(true);

		addKeyListener(new MyKeyListener());
		add(background); // gif..... ���� �ؿ� add�� ����� �� �������� �Ѥ�
		pack();
	}

	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				if (Game2.random_arrow[Game2.now] == 0) {
					Game2.arrow1[Game2.now].bt.setVisible(false);
					Game2.now++;
					bts = new Music("��ư�����Ҹ�.mp3",false);
	                bts.start();
				} 
				else for (int i = 0; i < Game2.arrow1.length; i++) {
						Game2.arrow1[i].bt.setVisible(true);
						Game2.now = 0;
						bbi = new Music("ȭ��ǥƲ��.mp3",false);
		                bbi.start();
					 }
				break;

			case KeyEvent.VK_DOWN:
				if (Game2.random_arrow[Game2.now] == 1) {
					Game2.arrow1[Game2.now].bt.setVisible(false);
					Game2.now++;
					bts = new Music("��ư�����Ҹ�.mp3",false);
	                bts.start();
				} 
				else for (int i = 0; i < Game2.arrow1.length; i++) {
						Game2.arrow1[i].bt.setVisible(true);
						Game2.now = 0;
						bbi = new Music("ȭ��ǥƲ��.mp3",false);
		                bbi.start();
					 }
				break;

			case KeyEvent.VK_LEFT:
				if (Game2.random_arrow[Game2.now] == 2) {
					Game2.arrow1[Game2.now].bt.setVisible(false);
					Game2.now++;
					bts = new Music("��ư�����Ҹ�.mp3",false);
	                bts.start();
				} 
				else for (int i = 0; i < Game2.arrow1.length; i++) {
						Game2.arrow1[i].bt.setVisible(true);
						Game2.now = 0;
						bbi = new Music("ȭ��ǥƲ��.mp3",false);
		                bbi.start();
					 }
				break;

			case KeyEvent.VK_RIGHT:
				if (Game2.random_arrow[Game2.now] == 3) {
					Game2.arrow1[Game2.now].bt.setVisible(false);
					Game2.now++;
					bts = new Music("��ư�����Ҹ�.mp3",false);
	                bts.start();
				} 
				else for (int i = 0; i < Game2.arrow1.length; i++) {
						Game2.arrow1[i].bt.setVisible(true);
						Game2.now = 0;
						bbi = new Music("ȭ��ǥƲ��.mp3",false);
		                bbi.start();
					 }
				break;
			}

			if (now == 27) {
				Clock2.timethread.interrupt();
				Main.score[1] = 300 - (Integer.parseInt(second.getText()) * 4);//����2 ���� ����
				pan.setVisible(false);

				Timer t = new Timer();
				TimerTask tt = new TimerTask() {

					@Override
					public void run() {
						gameresult.setVisible(true);
						nextgame.bt.setVisible(true);
					}
				};
				
				t.schedule(tt, 3000);
			}

			else if (now == round) {
				pan_panel.removeAll(); // �� �� ���� ȭ��ǥ ������
				round += 9;
				now = 0;

				Random random = new Random();

				for (int i = 0; i < round; i++) {
					random_arrow[i] = random.nextInt(4);
					Game2.random_arrow[i] = random_arrow[i];

					if (random_arrow[i] == 0) {
						arrow1[i] = new ArrowButton("ȭ��ǥ_��.png");
					}

					else if (random_arrow[i] == 1) {
						arrow1[i] = new ArrowButton("ȭ��ǥ_�Ʒ�.png");
					}

					else if (random_arrow[i] == 2) {
						arrow1[i] = new ArrowButton("ȭ��ǥ_��.png");
					}

					else {
						arrow1[i] = new ArrowButton("ȭ��ǥ_��.png");
					}
					Game2.arrow1[i] = arrow1[i];
				}

				for (int i = 0; i < round; i++) {
					pan_panel.add(arrow1[i].bt);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		next.bt.setVisible(false);
		round2.bt.setVisible(false);

		// ******************************************************************
		Timer see = new Timer();// 1��° Ÿ�̸� : ���� ���̰� �ϴ� Ÿ�̸�
		TimerTask seet = new TimerTask() {
			@Override
			public void run() {
				pan.bt.setVisible(true); // �� ���̰� ��
			}
		};

		see.schedule(seet, 2500); // 2.5�� �� ���� ����

		// 2��° Ÿ�̸� : ȭ��ǥ�� ���̰� �ϴ� Ÿ�̸�
		Timer arrowtimer = new Timer();
		TimerTask arrowtimersee = new TimerTask() {

			@Override
			public void run() {
				for (int i = 0; i < round; i++) {
					pan_panel.add(arrow1[i].bt);
				}

				pan_panel.setVisible(true);
			}
		};

		arrowtimer.schedule(arrowtimersee, 3500); // �� �߰� 1�� �� ��ư ����
		// ******************************************************************

		Timer time = new Timer();
		TimerTask timet = new TimerTask() {

			@Override
			public void run() {
				// �ð�ģ��
				Clock2 ck = new Clock2();
			}
		};

		time.schedule(timet, 3500); // 3.5��(�� �߰� ��ư ����)�� �ð� ��� ����
	}
}