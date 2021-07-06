package aBeengers20;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KongButton implements MouseListener {

	JButton bt = new JButton(new ImageIcon("./image/유령콩이.png"));
	Music music;

	KongButton() {
		Random random = new Random();
		int x = random.nextInt(1230); // 1280 - 콩이크기(50픽셀)
		int y = random.nextInt(670); // 720 - 콩이크기(50픽셀)
		// int size = random.nextInt(50 - 20 + 1) + 20; // 최소 20 ~ 최대 50 픽셀

		bt.setBorderPainted(false); // 버튼 외곽선 없애줌.
		bt.setContentAreaFilled(false); // 버튼 내용 영역 채우기 안함.
		bt.setFocusPainted(false); // 선택됐을 때 생기는 테두리 안함.
		bt.setBounds(x, y, 50, 50); // x좌표, y좌표, w, h
		bt.setDisabledIcon(new ImageIcon("./image/잡힌콩이.png"));

		bt.addMouseListener(this);
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bt.setEnabled(false);
				Game4.docount++;
				Game4.yetcount--;
				Game4.now.setText("잡은 콩이 : " + Game4.docount + " 남은 콩이 : " + Game4.yetcount);
				
				if (Game4.yetcount == 0) {
					Game4.black.setVisible(false);
					Clock4.timethread.interrupt();
					Main.score[3] = 400 - (Integer.parseInt(Game4.time) * 4);//게임4 점수 저장
					Game4.now.setText(Game4.time);

					// 다 끝나고 3초 정도 배경 구경하삼
					Timer t = new Timer();
					TimerTask tt = new TimerTask() {

						@Override
						public void run() {
							Game4.gameresult.setVisible(true);
							Game4.nextgame.bt.setVisible(true);
						}
					};

					t.schedule(tt, 3000);
				}
			}
		});

		/*
		 * 일단 Layout이 적용된 부분에서는 setPreffersize만 사용 가능합니다. 레이아웃매니저가 지멋대로 배치하고 크기도 주물르거든요
		 * 하지만 Layout이 적용안 된 곳에서 setPreffersize쓰면 아무효과 없습니다. setLocation +
		 * setPreffersize 하면 크기가 0이라 안보여요. setBounds 를 쓰시던지 setLocation + setSize를
		 * 쓰셔야합니다.
		 */
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.music = new Music("웃음소리.mp3", true);// 뭐할껀지 넣어줌
		music.start();// 시작~
	}

	@Override
	public void mouseExited(MouseEvent e) {
		music.close();
	}
}
