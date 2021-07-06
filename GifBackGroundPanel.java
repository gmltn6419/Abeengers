package aBeengers20;

import java.awt.*;
import java.net.*;

import javax.swing.*;

public class GifBackGroundPanel extends JPanel{
	Image img;
	public GifBackGroundPanel(Image img) throws MalformedURLException{
		this.img = img;//�ؿ� �ֵ��� �̹��� ũ�� �޾ƿ��¾ֵ�
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null); // ���̾ƿ��� ���� ���ڴ�.
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(img != null) {
			g.drawImage(img, 0, 0, this);
		}
	}
}
