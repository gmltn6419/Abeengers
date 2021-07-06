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

	JButton bt = new JButton(new ImageIcon("./image/��������.png"));
	Music music;

	KongButton() {
		Random random = new Random();
		int x = random.nextInt(1230); // 1280 - ����ũ��(50�ȼ�)
		int y = random.nextInt(670); // 720 - ����ũ��(50�ȼ�)
		// int size = random.nextInt(50 - 20 + 1) + 20; // �ּ� 20 ~ �ִ� 50 �ȼ�

		bt.setBorderPainted(false); // ��ư �ܰ��� ������.
		bt.setContentAreaFilled(false); // ��ư ���� ���� ä��� ����.
		bt.setFocusPainted(false); // ���õ��� �� ����� �׵θ� ����.
		bt.setBounds(x, y, 50, 50); // x��ǥ, y��ǥ, w, h
		bt.setDisabledIcon(new ImageIcon("./image/��������.png"));

		bt.addMouseListener(this);
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bt.setEnabled(false);
				Game4.docount++;
				Game4.yetcount--;
				Game4.now.setText("���� ���� : " + Game4.docount + " ���� ���� : " + Game4.yetcount);
				
				if (Game4.yetcount == 0) {
					Game4.black.setVisible(false);
					Clock4.timethread.interrupt();
					Main.score[3] = 400 - (Integer.parseInt(Game4.time) * 4);//����4 ���� ����
					Game4.now.setText(Game4.time);

					// �� ������ 3�� ���� ��� �����ϻ�
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
		 * �ϴ� Layout�� ����� �κп����� setPreffersize�� ��� �����մϴ�. ���̾ƿ��Ŵ����� ���ڴ�� ��ġ�ϰ� ũ�⵵ �ֹ����ŵ��
		 * ������ Layout�� ����� �� ������ setPreffersize���� �ƹ�ȿ�� �����ϴ�. setLocation +
		 * setPreffersize �ϸ� ũ�Ⱑ 0�̶� �Ⱥ�����. setBounds �� ���ô��� setLocation + setSize��
		 * ���ž��մϴ�.
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
		this.music = new Music("�����Ҹ�.mp3", true);// ���Ҳ��� �־���
		music.start();// ����~
	}

	@Override
	public void mouseExited(MouseEvent e) {
		music.close();
	}
}
