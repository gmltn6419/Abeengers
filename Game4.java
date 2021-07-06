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

	PngBackGroundPanel background; // 배경 화면
	NextButton round4; // 게임4 설명
	NextButton next; // 라운드 창 지우는 버튼
	NextButton startwait; // 대기시간용 gif
	JPanel kong;
	Cursor cursor;
	Image img;

	KongButton[] kb = new KongButton[5]; // 콩이 10마리
	BlackButton[] bt = new BlackButton[150]; // 블랙 패널 위에 올라가는 검은 버튼

	static int docount; // 잡은 콩이 수
	static int yetcount; // 남은 콩이 수
	static String time; // 걸린 시간
	static JLabel now; // 게임 상황 (남은 콩이, 잡은 콩이)
	static JPanel black; // 검은 버튼 올라간 패널
	static NextButton nextgame; // 다음 게임으로 이동(마지막게임이라서 최종결과로 이동)
	static PngBackGroundPanel gameresult; // 게임 결과 창

	Game4() {
		setTitle("ABEENGERS");
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Dimension dim = new Dimension(1280, 750); // 프레임크기지정
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);
		// setLocationRelativeTo(null);
		setPreferredSize(dim);
		setVisible(true);

		music = new Music("유령.mp3", true);// 뭐할껀지 넣어줌
		music.start();// 시작~

		docount = 0;
		yetcount = 5;
		now = new JLabel("잡은 콩이 : 0 남은 콩이 : 5");
		Font font = new Font("헤움버블S", Font.BOLD, 50);
		Color color = new Color(255, 255, 0);
		now.setFont(font);
		now.setForeground(color);
		now.setBounds(650, 50, 600, 50);

		// 백그라운드 배경 2개 중 랜덤으로 띄워줌
		Random random = new Random();
		int b = random.nextInt(2);

		if (b == 0) {
			background = new PngBackGroundPanel(new ImageIcon("./image/유령1.jpg").getImage());
		}

		else {
			background = new PngBackGroundPanel(new ImageIcon("./image/유령2.jpg").getImage());
		}

		// 라운드 창
		round4 = new NextButton("라운드4.png");
		round4.bt.setSize(1280, 720);
		round4.bt.setLocation(0, 0);

		// 라운드 창 : 넥스트 버튼 - 액션 실행
		next = new NextButton("투명.png");
		next.bt.setSize(150, 150);
		next.bt.setLocation(567, 508);
		next.bt.addActionListener(this);

		// 넥스트 버튼 클릭 시 2초동안 gif파일로 대기시간주기(?)
		startwait = new NextButton("스르륵콩이.gif");
		startwait.bt.setSize(500, 500);
		startwait.bt.setLocation(390, 110);
		startwait.bt.setVisible(false);

		// 게임결과 화면 - 게임 끝나면 뜸
		gameresult = new PngBackGroundPanel(new ImageIcon("./image/4라운드게임결과.png").getImage());
		gameresult.setVisible(false);

		// 다음 게임으로 넘어가는 버튼
		nextgame = new NextButton("칠판_잡힌콩.png");
		nextgame.bt.setPreferredSize(new Dimension(1280, 720));
		nextgame.bt.setSize(150, 150);
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
					new Change5();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); // 여기에 이벤트를 주겠따

		// 콩이 올라가는 패널
		kong = new JPanel();
		kong.setSize(1280, 720);
		kong.setLocation(0, 0);
		kong.setOpaque(false);
		kong.setVisible(true);
		kong.setLayout(null);

		// 검은 버튼들 올라가는 패널
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
		add(black); // 블랙 라벨
		add(kong); // 콩이 라벨
		add(background); // 배경화면
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 마우스 바꾸기
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("./image/손전등.png");
		Point point = new Point(0, 0);
		cursor = tk.createCustomCursor(img, point, "corsor1");
		setCursor(cursor);

		round4.bt.setVisible(false);
		next.bt.setVisible(false);

		startwait.bt.setVisible(true);
		
		//스르륵할때 음악
		haha = new Music("웃음소리.mp3", false);// 뭐할껀지 넣어줌
		haha.start();// 시작~

		Timer t = new Timer();
		TimerTask tt = new TimerTask() {

			@Override
			public void run() {

				startwait.bt.setVisible(false);
				
				// 초 세는 클래스
				Clock4 ck = new Clock4();
			}

		};

		t.schedule(tt, 2000);// 2초뒤에 clock4 실행되게
	}

}