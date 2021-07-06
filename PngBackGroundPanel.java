package aBeengers20;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PngBackGroundPanel extends JPanel{
	
	private Image img; //이미지파일자체
	
	public PngBackGroundPanel(Image img) {
		this.img = img;//밑에 애들이 이미지 크기 받아오는애들
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null); // 레이아웃을 만들어서 쓰겠다.
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null); // img를 0,0에 띄워주는것
	}
}

