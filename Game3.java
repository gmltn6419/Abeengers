package aBeengers20;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Game3 extends JFrame implements ActionListener {

	Music music, music1;

	int count; // 100회
	ImageIcon icon; // TV 배경
	JButton tv; // TV 지지직
	JButton r; // 리모컨
	NextButton round3;
	NextButton next;
	NextButton nextgame;
	PngBackGroundPanel gameresult;
	JLabel c_label;// 카운트(채널)표시

	static int myrank;
	static String rank;
	static JLabel score;
	static JLabel second; // (화면에 표시) 시간-초

	Game3() {
		Dimension dim = new Dimension(1280, 750); // 프레임크기지정
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame(); // 프레임생성
		frame.setPreferredSize(dim); // 프레임크기 넣어주기
		frame.setTitle("ABEENGERS"); // 프레임의 타이틀
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 엑스 누르면 꺼지냐
		frame.setResizable(false);// 창크기 고정
		// frame.setLocationRelativeTo(null); // 창을 화면의 가운데에 띄우기
		frame.setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);

		music = new Music("티비.mp3", true);// 뭐할껀지 넣어줌
		music.start();// 시작~

		icon = new ImageIcon("./image/티비배경.png");
		gameresult = new PngBackGroundPanel(new ImageIcon("./image/3라운드게임결과.png").getImage());
		gameresult.setVisible(false);

		// 다음 게임으로 넘어가는 버튼
		nextgame = new NextButton("다음게임클릭용TV.png");
		nextgame.bt.setPreferredSize(new Dimension(1280, 720));
		nextgame.bt.setSize(200, 150);
		nextgame.bt.setLocation(900, 460); // 위치 설정
		// setPreferredSize, setSize 해줘야 버튼이 보임
		nextgame.bt.setVisible(false);
		nextgame.bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				music.close();
				frame.setVisible(false);
				frame.dispose();

				try {
					new Change4();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
			}
		}); // 여기에 이벤트를 주겠따

		count = 0;
		myrank = 0;

		second = new JLabel("0");
		Font font = new Font("헤움버블S", Font.BOLD, 100);
		Color color = new Color(229, 0, 0);
		second.setFont(font);
		second.setForeground(color);
		second.setBounds(1100, 20, 200, 150);

		// 배경화면 패널
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		// 라운드 창
		round3 = new NextButton("라운드3.png");
		round3.bt.setSize(1280, 720);
		round3.bt.setLocation(0, 0);

		// 라운드 창 : 넥스트 버튼 - 액션 실행
		next = new NextButton("투명.png");
		next.bt.setSize(150, 150);
		next.bt.setLocation(567, 508);
		next.bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				round3.bt.setVisible(false);
				next.bt.setVisible(false);
			}
		}); // 여기에 이벤트를 주겠따

		// TV 지지직
		tv = new JButton(new ImageIcon("./image/안켜짐.png"));
		tv.setContentAreaFilled(false);// 배경채우기
		tv.setBorderPainted(false);// 테두리
		tv.setFocusPainted(false);// 눌렀을때 테두리
		tv.setBounds(302, 51, 662, 342);
		this.tv = tv;

		// 리모컨 버튼
		r = new JButton(new ImageIcon("./image/그냥버튼.png"));
		r.setContentAreaFilled(false);// 배경채우기
		r.setBorderPainted(false);// 테두리
		r.setFocusPainted(false);// 눌렀을때 테두리
		r.addActionListener(this);
		r.setPressedIcon(new ImageIcon("./image/공백.png"));
		this.r = r;

		// 누른횟수 == 채널
		c_label = new JLabel("0");
		Font c_font = new Font("헤움버블S", Font.BOLD, 60);
		c_label.setFont(c_font);
		c_label.setForeground(color);
		c_label.setBounds(835, 35, 200, 100);
		c_label.setVisible(false);

		// ***************************************************패널만들기 시작~!!!
		// TV 지지직 올린 패널
		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);// 판넬 배경을 투명하게함
		panel2.setPreferredSize(new Dimension(1280, 450));
		panel2.setLayout(null);
		panel2.add(c_label);// 카운트 == 채널표시
		panel2.add(tv);
		panel2.add(second);

		// 리모컨 버튼 올린 패널
		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);// 판넬 배경을 투명하게함
		panel3.setPreferredSize(new Dimension(1280, 250));
		panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 443, 15));
		panel3.add(r, BorderLayout.CENTER);

		// 올려놓을 패널 (사실상 배경)
		JPanel panel1 = new JPanel();
		// panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setOpaque(false);// 판넬 배경을 투명하게함
		panel1.add(panel2);
		panel1.add(panel3);
		panel1.setPreferredSize(new Dimension(1280, 750));
		background.add(panel1, BorderLayout.CENTER);

		frame.add(nextgame);
		frame.add(gameresult);
		frame.add(next);
		frame.add(round3);
		frame.add(background, BorderLayout.CENTER);
		// frame.setBackground(background);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		count++;

		Music bts = new Music("버튼누름소리.mp3", false);
		bts.start();

		if (count == 1) {
			Clock3 ck = new Clock3();
		}

		c_label.setVisible(true);
		c_label.setText(Integer.toString(count)); // 채널 숫자 표시

		tv.setIcon(new ImageIcon("./image/지지직.png"));

		if (count == 100) {
			tv.setIcon(new ImageIcon("./image/공백.png"));
			r.setDisabledIcon(new ImageIcon("./image/그냥버튼.png"));
			r.setEnabled(false);// 여러번 x

			// 브금 꺼주고 TV 소리 켜줌
			music.close();
			music1 = new Music("티비켜지면나는소리.mp3", false);
			music1.start();

			Clock3.timethread.interrupt();
			Main.score[2] = 300 - (Integer.parseInt(second.getText()) * 10);//게임3 점수 저장

			Timer t = new Timer();
			TimerTask tt = new TimerTask() {

				@Override
				public void run() {
					// 결과창 뜨면 TV소리 꺼줌
					music1.close();

					gameresult.setVisible(true);
					nextgame.bt.setVisible(true);
				}
			};

			t.schedule(tt, 3350); // 2초간 티비 볼 시간 ^^
		}
	}
}