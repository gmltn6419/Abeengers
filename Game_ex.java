package aBeengers20;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.*;
		
public class Game_ex extends JFrame implements ActionListener { 
	
	Music music;
	
	Game_ex(){ 
		setTitle("Game_ex");
		setSize(1280, 720); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true); 
		
		music = new Music("게임설명.mp3", true);//뭐할껀지 넣어줌
	    music.start();//시작~
		
		PngBackGroundPanel background = new PngBackGroundPanel(new ImageIcon("./image/게임설명.png").getImage());
		NextButton next = new NextButton("버튼_칠판콩이.png");
		next.bt.setSize(195, 245);
		next.bt.setLocation(910, 380);
		next.bt.addActionListener(this); 
		
		add(next);
		add(background);
		pack();
		
	}
	
	@Override public void actionPerformed(ActionEvent e) { // 오버라이드
		
		music.close();
		this.setVisible(false);
		this.dispose();
		
		try {
			new Game1();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//background 판넬이랑 버튼판넬이랑 둘 ㄷ ㅏ public같이 접근할수있게끔 설정해조야해
		//그래야 마지막에 같이 펼수있
	}
		
} 