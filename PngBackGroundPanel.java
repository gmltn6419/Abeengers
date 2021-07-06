package aBeengers20;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PngBackGroundPanel extends JPanel{
	
	private Image img; //�̹���������ü
	
	public PngBackGroundPanel(Image img) {
		this.img = img;//�ؿ� �ֵ��� �̹��� ũ�� �޾ƿ��¾ֵ�
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null); // ���̾ƿ��� ���� ���ڴ�.
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null); // img�� 0,0�� ����ִ°�
	}
}

