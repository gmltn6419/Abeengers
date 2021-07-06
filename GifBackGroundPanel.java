package aBeengers20;

import java.awt.*;
import java.net.*;

import javax.swing.*;

public class GifBackGroundPanel extends JPanel{
	Image img;
	public GifBackGroundPanel(Image img) throws MalformedURLException{
		this.img = img;//밑에 애들이 이미지 크기 받아오는애들
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null); // 레이아웃을 만들어서 쓰겠다.
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(img != null) {
			g.drawImage(img, 0, 0, this);
		}
	}
}
