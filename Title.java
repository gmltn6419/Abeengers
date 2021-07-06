package aBeengers20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class Title extends JFrame implements ActionListener { 
	
	Music music; // 배경음악쓸꺼임
	
	Title(){ 
		setTitle("ABEENGERS");
		setSize(1280, 720); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true); 
		
		music = new Music("타이틀.mp3", true);//뭐할껀지 넣어줌
	    music.start();//시작~
	    
		NextButton start = new NextButton("시작.png");
		start.bt.setSize(400,120);
		start.bt.setPressedIcon(new ImageIcon("./image/누른시작.png"));
		start.bt.setLocation(460,600);
		start.bt.addActionListener(this);// <-이 버튼이거에 리스너를 연결한다 
		
		PngBackGroundPanel background = new PngBackGroundPanel(new ImageIcon("./image/타이틀.jpg").getImage());
		
		add(start);
		add(background);
		pack();//add 끝내고 가방싸는거랑 같다고 보면 됨
	}
	
		@Override public void actionPerformed(ActionEvent e) { // 오버라이드
			
			music.close();
			this.setVisible(false);
			this.dispose();
			
			try {
				new Change1();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	} 
} 