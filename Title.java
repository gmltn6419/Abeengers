package aBeengers20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class Title extends JFrame implements ActionListener { 
	
	Music music; // ������Ǿ�����
	
	Title(){ 
		setTitle("ABEENGERS");
		setSize(1280, 720); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true); 
		
		music = new Music("Ÿ��Ʋ.mp3", true);//���Ҳ��� �־���
	    music.start();//����~
	    
		NextButton start = new NextButton("����.png");
		start.bt.setSize(400,120);
		start.bt.setPressedIcon(new ImageIcon("./image/��������.png"));
		start.bt.setLocation(460,600);
		start.bt.addActionListener(this);// <-�� ��ư�̰ſ� �����ʸ� �����Ѵ� 
		
		PngBackGroundPanel background = new PngBackGroundPanel(new ImageIcon("./image/Ÿ��Ʋ.jpg").getImage());
		
		add(start);
		add(background);
		pack();//add ������ ����δ°Ŷ� ���ٰ� ���� ��
	}
	
		@Override public void actionPerformed(ActionEvent e) { // �������̵�
			
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