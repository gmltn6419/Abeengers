package aBeengers20;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NextButton extends JPanel implements ActionListener{

	JButton bt; // ��ư�� �̹����� �־ ��ü ����
	
	public NextButton(String name)
	{
		bt = new JButton(new ImageIcon("./image/" + name));
		
		setSize(1280, 720); // â ũ�⿡ ���缭 Panel ����
		setPreferredSize(new Dimension(1280, 720)); // â ũ�⿡ ���缭 Panel ����
		setOpaque(false); // Panel�� �����ϰ� ��
        setLayout(null); // ���� ���̾ƿ��� ����� �����
        
        bt.setBorderPainted(false); // ��ư �ܰ��� ������.
        bt.setContentAreaFilled(false); // ��ư ���� ���� ä��� ����.
        bt.setFocusPainted(false); // ���õ��� �� ����� �׵θ� ����.
        bt.addActionListener(this);
		bt.setVisible(true);
		
        add(bt);
	}
	@Override public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		}
	}

