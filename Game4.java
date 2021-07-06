package aBeengers20;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game4 extends JFrame implements ActionListener {

	Music music, haha;

	PngBackGroundPanel background; // ��� ȭ��
	NextButton round4; // ����4 ����
	NextButton next; // ���� â ����� ��ư
	NextButton startwait; // ���ð��� gif
	JPanel kong;
	Cursor cursor;
	Image img;

	KongButton[] kb = new KongButton[5]; // ���� 10����
	BlackButton[] bt = new BlackButton[150]; // �� �г� ���� �ö󰡴� ���� ��ư

	static int docount; // ���� ���� ��
	static int yetcount; // ���� ���� ��
	static String time; // �ɸ� �ð�
	static JLabel now; // ���� ��Ȳ (���� ����, ���� ����)
	static JPanel black; // ���� ��ư �ö� �г�
	static NextButton nextgame; // ���� �������� �̵�(�����������̶� ��������� �̵�)
	static PngBackGroundPanel gameresult; // ���� ��� â

	Game4() {
		setTitle("ABEENGERS");
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Dimension dim = new Dimension(1280, 750); // ������ũ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);
		// setLocationRelativeTo(null);
		setPreferredSize(dim);
		setVisible(true);

		music = new Music("����.mp3", true);// ���Ҳ��� �־���
		music.start();// ����~

		docount = 0;
		yetcount = 5;
		now = new JLabel("���� ���� : 0 ���� ���� : 5");
		Font font = new Font("������S", Font.BOLD, 50);
		Color color = new Color(255, 255, 0);
		now.setFont(font);
		now.setForeground(color);
		now.setBounds(650, 50, 600, 50);

		// ��׶��� ��� 2�� �� �������� �����
		Random random = new Random();
		int b = random.nextInt(2);

		if (b == 0) {
			background = new PngBackGroundPanel(new ImageIcon("./image/����1.jpg").getImage());
		}

		else {
			background = new PngBackGroundPanel(new ImageIcon("./image/����2.jpg").getImage());
		}

		// ���� â
		round4 = new NextButton("����4.png");
		round4.bt.setSize(1280, 720);
		round4.bt.setLocation(0, 0);

		// ���� â : �ؽ�Ʈ ��ư - �׼� ����
		next = new NextButton("����.png");
		next.bt.setSize(150, 150);
		next.bt.setLocation(567, 508);
		next.bt.addActionListener(this);

		// �ؽ�Ʈ ��ư Ŭ�� �� 2�ʵ��� gif���Ϸ� ���ð��ֱ�(?)
		startwait = new NextButton("����������.gif");
		startwait.bt.setSize(500, 500);
		startwait.bt.setLocation(390, 110);
		startwait.bt.setVisible(false);

		// ���Ӱ�� ȭ�� - ���� ������ ��
		gameresult = new PngBackGroundPanel(new ImageIcon("./image/4������Ӱ��.png").getImage());
		gameresult.setVisible(false);

		// ���� �������� �Ѿ�� ��ư
		nextgame = new NextButton("ĥ��_������.png");
		nextgame.bt.setPreferredSize(new Dimension(1280, 720));
		nextgame.bt.setSize(150, 150);
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
					new Change5();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); // ���⿡ �̺�Ʈ�� �ְڵ�

		// ���� �ö󰡴� �г�
		kong = new JPanel();
		kong.setSize(1280, 720);
		kong.setLocation(0, 0);
		kong.setOpaque(false);
		kong.setVisible(true);
		kong.setLayout(null);

		// ���� ��ư�� �ö󰡴� �г�
		black = new JPanel();
		black.setSize(1280, 720);
		black.setLocation(0, 0);
		black.setOpaque(false);
		black.setLayout(new GridLayout(8, 0, 0, 0));

		for (int i = 0; i < 5; i++) {
			kb[i] = new KongButton();
			kong.add(kb[i].bt);
		}

		for (int i = 0; i < 112; i++) {
			bt[i] = new BlackButton();
			black.add(bt[i].bt);
		}

		add(nextgame);
		add(gameresult);
		add(next);
		add(round4);
		add(startwait);
		add(now);
		add(black); // �� ��
		add(kong); // ���� ��
		add(background); // ���ȭ��
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// ���콺 �ٲٱ�
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("./image/������.png");
		Point point = new Point(0, 0);
		cursor = tk.createCustomCursor(img, point, "corsor1");
		setCursor(cursor);

		round4.bt.setVisible(false);
		next.bt.setVisible(false);

		startwait.bt.setVisible(true);
		
		//�������Ҷ� ����
		haha = new Music("�����Ҹ�.mp3", false);// ���Ҳ��� �־���
		haha.start();// ����~

		Timer t = new Timer();
		TimerTask tt = new TimerTask() {

			@Override
			public void run() {

				startwait.bt.setVisible(false);
				
				// �� ���� Ŭ����
				Clock4 ck = new Clock4();
			}

		};

		t.schedule(tt, 2000);// 2�ʵڿ� clock4 ����ǰ�
	}

}