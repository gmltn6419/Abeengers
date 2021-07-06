package aBeengers20;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NextButton extends JPanel implements ActionListener{

	JButton bt; // 버튼에 이미지를 넣어서 객체 생성
	
	public NextButton(String name)
	{
		bt = new JButton(new ImageIcon("./image/" + name));
		
		setSize(1280, 720); // 창 크기에 맞춰서 Panel 생성
		setPreferredSize(new Dimension(1280, 720)); // 창 크기에 맞춰서 Panel 생성
		setOpaque(false); // Panel을 투명하게 함
        setLayout(null); // 내가 레이아웃을 만들어 사용함
        
        bt.setBorderPainted(false); // 버튼 외곽선 없애줌.
        bt.setContentAreaFilled(false); // 버튼 내용 영역 채우기 안함.
        bt.setFocusPainted(false); // 선택됐을 때 생기는 테두리 안함.
        bt.addActionListener(this);
		bt.setVisible(true);
		
        add(bt);
	}
	@Override public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		}
	}

