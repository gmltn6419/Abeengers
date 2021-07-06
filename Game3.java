package aBeengers20;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Game3 extends JFrame implements ActionListener {

	Music music, music1;

	int count; // 100ȸ
	ImageIcon icon; // TV ���
	JButton tv; // TV ������
	JButton r; // ������
	NextButton round3;
	NextButton next;
	NextButton nextgame;
	PngBackGroundPanel gameresult;
	JLabel c_label;// ī��Ʈ(ä��)ǥ��

	static int myrank;
	static String rank;
	static JLabel score;
	static JLabel second; // (ȭ�鿡 ǥ��) �ð�-��

	Game3() {
		Dimension dim = new Dimension(1280, 750); // ������ũ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame(); // �����ӻ���
		frame.setPreferredSize(dim); // ������ũ�� �־��ֱ�
		frame.setTitle("ABEENGERS"); // �������� Ÿ��Ʋ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� ������ ������
		frame.setResizable(false);// âũ�� ����
		// frame.setLocationRelativeTo(null); // â�� ȭ���� ����� ����
		frame.setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);

		music = new Music("Ƽ��.mp3", true);// ���Ҳ��� �־���
		music.start();// ����~

		icon = new ImageIcon("./image/Ƽ����.png");
		gameresult = new PngBackGroundPanel(new ImageIcon("./image/3������Ӱ��.png").getImage());
		gameresult.setVisible(false);

		// ���� �������� �Ѿ�� ��ư
		nextgame = new NextButton("��������Ŭ����TV.png");
		nextgame.bt.setPreferredSize(new Dimension(1280, 720));
		nextgame.bt.setSize(200, 150);
		nextgame.bt.setLocation(900, 460); // ��ġ ����
		// setPreferredSize, setSize ����� ��ư�� ����
		nextgame.bt.setVisible(false);
		nextgame.bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				music.close();
				frame.setVisible(false);
				frame.dispose();

				try {
					new Change4();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
			}
		}); // ���⿡ �̺�Ʈ�� �ְڵ�

		count = 0;
		myrank = 0;

		second = new JLabel("0");
		Font font = new Font("������S", Font.BOLD, 100);
		Color color = new Color(229, 0, 0);
		second.setFont(font);
		second.setForeground(color);
		second.setBounds(1100, 20, 200, 150);

		// ���ȭ�� �г�
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		// ���� â
		round3 = new NextButton("����3.png");
		round3.bt.setSize(1280, 720);
		round3.bt.setLocation(0, 0);

		// ���� â : �ؽ�Ʈ ��ư - �׼� ����
		next = new NextButton("����.png");
		next.bt.setSize(150, 150);
		next.bt.setLocation(567, 508);
		next.bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				round3.bt.setVisible(false);
				next.bt.setVisible(false);
			}
		}); // ���⿡ �̺�Ʈ�� �ְڵ�

		// TV ������
		tv = new JButton(new ImageIcon("./image/������.png"));
		tv.setContentAreaFilled(false);// ���ä���
		tv.setBorderPainted(false);// �׵θ�
		tv.setFocusPainted(false);// �������� �׵θ�
		tv.setBounds(302, 51, 662, 342);
		this.tv = tv;

		// ������ ��ư
		r = new JButton(new ImageIcon("./image/�׳ɹ�ư.png"));
		r.setContentAreaFilled(false);// ���ä���
		r.setBorderPainted(false);// �׵θ�
		r.setFocusPainted(false);// �������� �׵θ�
		r.addActionListener(this);
		r.setPressedIcon(new ImageIcon("./image/����.png"));
		this.r = r;

		// ����Ƚ�� == ä��
		c_label = new JLabel("0");
		Font c_font = new Font("������S", Font.BOLD, 60);
		c_label.setFont(c_font);
		c_label.setForeground(color);
		c_label.setBounds(835, 35, 200, 100);
		c_label.setVisible(false);

		// ***************************************************�гθ���� ����~!!!
		// TV ������ �ø� �г�
		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);// �ǳ� ����� �����ϰ���
		panel2.setPreferredSize(new Dimension(1280, 450));
		panel2.setLayout(null);
		panel2.add(c_label);// ī��Ʈ == ä��ǥ��
		panel2.add(tv);
		panel2.add(second);

		// ������ ��ư �ø� �г�
		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);// �ǳ� ����� �����ϰ���
		panel3.setPreferredSize(new Dimension(1280, 250));
		panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 443, 15));
		panel3.add(r, BorderLayout.CENTER);

		// �÷����� �г� (��ǻ� ���)
		JPanel panel1 = new JPanel();
		// panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setOpaque(false);// �ǳ� ����� �����ϰ���
		panel1.add(panel2);
		panel1.add(panel3);
		panel1.setPreferredSize(new Dimension(1280, 750));
		background.add(panel1, BorderLayout.CENTER);

		frame.add(nextgame);
		frame.add(gameresult);
		frame.add(next);
		frame.add(round3);
		frame.add(background, BorderLayout.CENTER);
		// frame.setBackground(background);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		count++;

		Music bts = new Music("��ư�����Ҹ�.mp3", false);
		bts.start();

		if (count == 1) {
			Clock3 ck = new Clock3();
		}

		c_label.setVisible(true);
		c_label.setText(Integer.toString(count)); // ä�� ���� ǥ��

		tv.setIcon(new ImageIcon("./image/������.png"));

		if (count == 100) {
			tv.setIcon(new ImageIcon("./image/����.png"));
			r.setDisabledIcon(new ImageIcon("./image/�׳ɹ�ư.png"));
			r.setEnabled(false);// ������ x

			// ��� ���ְ� TV �Ҹ� ����
			music.close();
			music1 = new Music("Ƽ�������鳪�¼Ҹ�.mp3", false);
			music1.start();

			Clock3.timethread.interrupt();
			Main.score[2] = 300 - (Integer.parseInt(second.getText()) * 10);//����3 ���� ����

			Timer t = new Timer();
			TimerTask tt = new TimerTask() {

				@Override
				public void run() {
					// ���â �߸� TV�Ҹ� ����
					music1.close();

					gameresult.setVisible(true);
					nextgame.bt.setVisible(true);
				}
			};

			t.schedule(tt, 3350); // 2�ʰ� Ƽ�� �� �ð� ^^
		}
	}
}