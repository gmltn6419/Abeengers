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

	PngBackGroundPanel gameresult; // 게임 종료 결과창
	NextButton nextgame; // 다음 게임으로 넘어가는 버튼
	NextButton round2; // 라운드2 그림
	NextButton next; // 라운드 "클릭" 투명 버튼
	NextButton pan; // 화살표들이 올라가는 판대기

	static int round;
	static int now;
	static JLabel second;
	static JPanel pan_panel; // 판대기 패널

	static int[] random_arrow = new int[27]; // 랜덤으로 숫자 저장(0~3)
	static ArrowButton[] arrow1 = new ArrowButton[27];// 화살표 모양 저장(0=위/1=아래/2=좌/3=우)

	static int myrank;
	static String rank;
	static JLabel score;

	Game2() throws MalformedURLException {
		// 프레임 설정
		setTitle("ABEENGERS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Dimension dim = new Dimension(1280, 750); // 프레임크기지정
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);
		// setLocationRelativeTo(null);
		setPreferredSize(dim);
		setVisible(true);

		second = new JLabel("0");
		Font font = new Font("헤움버블S", Font.BOLD, 100);
		Color color = new Color(229, 0, 0);
		second.setFont(font);
		second.setForeground(color);
		second.setBounds(1100, 20, 200, 100);

		// 노래 ㄱㄱ
		music = new Music("탭댄스.mp3", true);
		music.start();// 시작~

		// 배경화면 - 기능x
		NextButton background = new NextButton("탭댄스.gif");
		background.bt.setSize(1280, 720);
		background.bt.setLocation(0, 0);

		// 게임결과 화면 - 게임 끝나면 뜸
		gameresult = new PngBackGroundPanel(new ImageIcon("./image/2라운드게임결과.png").getImage());
		gameresult.setVisible(false);

		// 다음 게임으로 넘어가는 버튼
		nextgame = new NextButton("클릭_미러볼.png");
		nextgame.bt.setPreferredSize(new Dimension(1280, 720));
		nextgame.bt.setSize(200, 150);
		nextgame.bt.setLocation(930, 460); // 위치 설정
		// setPreferredSize, setSize 해줘야 버튼이 보임
		nextgame.bt.setVisible(false);
		nextgame.bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				music.close();
				setVisible(false);
				dispose();

				try {
					new Change3(); // 전환3으로 이동
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}); // 여기에 이벤트를 주겠따

		// 라운드 창
		round2 = new NextButton("라운드2.png");
		round2.bt.setSize(1280, 720);
		round2.bt.setLocation(0, 0);

		// 라운드 창 : 넥스트 버튼 - 액션 실행
		next = new NextButton("투명.png");
		next.bt.setSize(150, 150);
		next.bt.setLocation(567, 508);
		next.bt.addActionListener(this);

		// 판 - 액션 없음
		pan = new NextButton("판대기.png");
		pan.bt.setSize(993, 441);
		pan.bt.setLocation(143, 70);
		pan.bt.setVisible(false);

		// (기능없는버튼) pan 위에 같은 크기의 패널을 만들어 줌. 여기 위에 화살표 뜨게 ㄱㄱ
		pan_panel = new JPanel();
		pan_panel.setSize(993, 441);
		pan_panel.setLocation(143, 70);
		pan_panel.setLayout(new GridLayout(3, 9, 5, 10));
		pan_panel.setOpaque(false);
		pan_panel.setVisible(false);

		round = 9;
		this.now = 0;

		// **************************************************************
		// 화살표 랜덤 생성해서 화면에 뿌려주기

		Random random = new Random();

		for (int i = 0; i < round; i++) {
			random_arrow[i] = random.nextInt(4);
			this.random_arrow[i] = random_arrow[i];

			if (random_arrow[i] == 0) {
				arrow1[i] = new ArrowButton("화살표_위.png");
			}

			else if (random_arrow[i] == 1) {
				arrow1[i] = new ArrowButton("화살표_아래.png");
			}

			else if (random_arrow[i] == 2) {
				arrow1[i] = new ArrowButton("화살표_좌.png");
			}

			else {
				arrow1[i] = new ArrowButton("화살표_우.png");
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
		add(background); // gif..... 제일 밑에 add해 줘야함 다 가려버림 ㅡㅡ
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
					bts = new Music("버튼누름소리.mp3",false);
	                bts.start();
				} 
				else for (int i = 0; i < Game2.arrow1.length; i++) {
						Game2.arrow1[i].bt.setVisible(true);
						Game2.now = 0;
						bbi = new Music("화살표틀림.mp3",false);
		                bbi.start();
					 }
				break;

			case KeyEvent.VK_DOWN:
				if (Game2.random_arrow[Game2.now] == 1) {
					Game2.arrow1[Game2.now].bt.setVisible(false);
					Game2.now++;
					bts = new Music("버튼누름소리.mp3",false);
	                bts.start();
				} 
				else for (int i = 0; i < Game2.arrow1.length; i++) {
						Game2.arrow1[i].bt.setVisible(true);
						Game2.now = 0;
						bbi = new Music("화살표틀림.mp3",false);
		                bbi.start();
					 }
				break;

			case KeyEvent.VK_LEFT:
				if (Game2.random_arrow[Game2.now] == 2) {
					Game2.arrow1[Game2.now].bt.setVisible(false);
					Game2.now++;
					bts = new Music("버튼누름소리.mp3",false);
	                bts.start();
				} 
				else for (int i = 0; i < Game2.arrow1.length; i++) {
						Game2.arrow1[i].bt.setVisible(true);
						Game2.now = 0;
						bbi = new Music("화살표틀림.mp3",false);
		                bbi.start();
					 }
				break;

			case KeyEvent.VK_RIGHT:
				if (Game2.random_arrow[Game2.now] == 3) {
					Game2.arrow1[Game2.now].bt.setVisible(false);
					Game2.now++;
					bts = new Music("버튼누름소리.mp3",false);
	                bts.start();
				} 
				else for (int i = 0; i < Game2.arrow1.length; i++) {
						Game2.arrow1[i].bt.setVisible(true);
						Game2.now = 0;
						bbi = new Music("화살표틀림.mp3",false);
		                bbi.start();
					 }
				break;
			}

			if (now == 27) {
				Clock2.timethread.interrupt();
				Main.score[1] = 300 - (Integer.parseInt(second.getText()) * 4);//게임2 점수 저장
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
				pan_panel.removeAll(); // 이 전 라운드 화살표 지워줌
				round += 9;
				now = 0;

				Random random = new Random();

				for (int i = 0; i < round; i++) {
					random_arrow[i] = random.nextInt(4);
					Game2.random_arrow[i] = random_arrow[i];

					if (random_arrow[i] == 0) {
						arrow1[i] = new ArrowButton("화살표_위.png");
					}

					else if (random_arrow[i] == 1) {
						arrow1[i] = new ArrowButton("화살표_아래.png");
					}

					else if (random_arrow[i] == 2) {
						arrow1[i] = new ArrowButton("화살표_좌.png");
					}

					else {
						arrow1[i] = new ArrowButton("화살표_우.png");
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
		Timer see = new Timer();// 1번째 타이머 : 판이 보이게 하는 타이머
		TimerTask seet = new TimerTask() {
			@Override
			public void run() {
				pan.bt.setVisible(true); // 판 보이게 함
			}
		};

		see.schedule(seet, 2500); // 2.5초 후 판이 보임

		// 2번째 타이머 : 화살표가 보이게 하는 타이머
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

		arrowtimer.schedule(arrowtimersee, 3500); // 판 뜨고 1초 후 버튼 생김
		// ******************************************************************

		Timer time = new Timer();
		TimerTask timet = new TimerTask() {

			@Override
			public void run() {
				// 시간친구
				Clock2 ck = new Clock2();
			}
		};

		time.schedule(timet, 3500); // 3.5초(판 뜨고 버튼 생김)에 시간 기록 시작
	}
}