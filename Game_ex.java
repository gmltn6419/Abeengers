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
		
		music = new Music("���Ӽ���.mp3", true);//���Ҳ��� �־���
	    music.start();//����~
		
		PngBackGroundPanel background = new PngBackGroundPanel(new ImageIcon("./image/���Ӽ���.png").getImage());
		NextButton next = new NextButton("��ư_ĥ������.png");
		next.bt.setSize(195, 245);
		next.bt.setLocation(910, 380);
		next.bt.addActionListener(this); 
		
		add(next);
		add(background);
		pack();
		
	}
	
	@Override public void actionPerformed(ActionEvent e) { // �������̵�
		
		music.close();
		this.setVisible(false);
		this.dispose();
		
		try {
			new Game1();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//background �ǳ��̶� ��ư�ǳ��̶� �� �� �� public���� �����Ҽ��ְԲ� ������������
		//�׷��� �������� ���� �����
	}
		
} 