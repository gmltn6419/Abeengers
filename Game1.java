package aBeengers20;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.Border;

public class Game1 extends JFrame implements ActionListener {

   Music music;

   NextButton round1; // ����1 �׸�
   NextButton next; // ���� "Ŭ��" ���� ��ư
   Cursor cursor; // ���콺 Ŀ�� ������ ���� ���
   Image img; // ���콺 Ŀ�� �̹���
   ImageIcon icon; // �δ��� ��� �̹��� �����ϴ� ������

   static Dubutton[] db1 = new Dubutton[16];

   static int myrank;
   static String rank;
   static JLabel score;
   static JLabel second;
   static NextButton nextgame;
   static PngBackGroundPanel gameresult;

   Game1() throws IOException {
      Dimension dim = new Dimension(1280, 750); // ������ũ������
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      JFrame frame = new JFrame(); // �����ӻ���
      frame.setPreferredSize(dim); // ������ũ�� �־��ֱ�
      frame.setTitle("ABEENGERS"); // �������� Ÿ��Ʋ
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� ������ ������
      frame.setResizable(false);// âũ�� ����
      // frame.setLocationRelativeTo(null); // â�� ȭ���� ����� ����
      frame.setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);

      // �뷡
      music = new Music("�δ���.mp3", true);
      music.start();// ����~

      // ���콺 ����
      Toolkit tk = Toolkit.getDefaultToolkit();
      img = tk.getImage("./image/�δ������콺.png");
      Point point = new Point(0, 0);
      cursor = tk.createCustomCursor(img, point, "corsor1");
      setCursor(cursor);

      // �δ��� ���(��� ������), ���� ���� ��� ���(���� ���� �� ������)
      icon = new ImageIcon("./image/�δ������1.png");
      gameresult = new PngBackGroundPanel(new ImageIcon("./image/1������Ӱ��.png").getImage());
      gameresult.setVisible(false);

      // �δ��� ��� �ö󰡴� �г�
      JPanel background = new JPanel() {
         public void paintComponent(Graphics g) {
            // Approach 1: Dispaly image at at full size
            g.drawImage(icon.getImage(), 0, 0, null);
            // Approach 2: Scale image to size of component
            // Dimension d = getSize();
            // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            // Approach 3: Fix the image position in the scroll pane
            // Point p = scrollPane.getViewport().getViewPosition();
            // g.drawImage(icon.getImage(), p.x, p.y, null);
            setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
            super.paintComponent(g);
         }
      };

      // ���� �������� �Ѿ�� ��ư
      nextgame = new NextButton("�̺�Ʈ�δ���.png");
      nextgame.bt.setPreferredSize(new Dimension(1280, 720));
      nextgame.bt.setSize(150, 150);
      nextgame.bt.setLocation(950, 460); // ��ġ ����
      // setPreferredSize, setSize ����� ��ư�� ����
      nextgame.bt.setVisible(false);
      nextgame.bt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            music.close();
            frame.setVisible(false);
            frame.dispose();

            try {
               new Change2(); // ��ȯ2�� �̵�
            } catch (MalformedURLException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }

         }
      }); // ���⿡ �̺�Ʈ�� �ְڵ�

      /*
      // ��ŷ�������� ***************************
      NextButton ranking = new NextButton("�����δ���.png"); // ����
      ranking.bt.addActionListener(this);
      ranking.bt.setPreferredSize(new Dimension(200, 0));// ��ư ��ġ �ٽü���
      ranking.bt.setSize(200, 200);
      */

      Font font = new Font("������S", Font.BOLD, 100);
      Color color = new Color(229, 0, 0);
      
      myrank = 0; // ����������
      score = new JLabel("0");
      score.setFont(font);
      score.setBounds(1050, 20, 250, 100);
      
      // �ð�
      second = new JLabel("0");
      second.setFont(font);
      second.setForeground(color);
      second.setBounds(200, 20, 200, 100);

      // �ð��̶� ���� �ö󰡴� �г�
      JPanel panel2 = new JPanel();
      panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // ���ο� 10�ȼ��� ����
      panel2.setLayout(null); // FlowLayout�� �Ȱ����� �ڵ� �ٹٲ� ����. X_AXIS : ���η� �� ��������
      panel2.setOpaque(false);// �ǳ� ����� �����ϰ���
      panel2.setPreferredSize(new Dimension(1280, 150));
      panel2.add(second);
      panel2.add(score);

      // �δ����� �ö�
      JPanel panel4 = new JPanel();
      panel4.setOpaque(false);// �ǳ� ����� �����ϰ���
      panel4.setLayout(new GridLayout(4, 4)); /////// ��ư�����
      panel4.setPreferredSize(new Dimension(1250, 560));

      // ����1 �δ������� ���� �̹���
      round1 = new NextButton("����1.png");
      round1.bt.setSize(1280, 720);
      round1.bt.setLocation(0, 0);

      // ���� â : �ؽ�Ʈ ��ư - �׼� ����
      next = new NextButton("����.png");
      next.bt.setSize(150, 150);
      next.bt.setLocation(567, 508);
      next.bt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Clock1 ck = new Clock1();
            
            next.bt.setVisible(false);
            round1.bt.setVisible(false);

            for (int i = 0; i < 16; i++) {
               db1[i] = new Dubutton();
               db1[i].setOpaque(false);
               panel4.add(db1[i]);
            }
         }
      }); // ���⿡ �̺�Ʈ�� �ְڵ�

      JPanel panel3 = new JPanel();
      panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      panel3.setPreferredSize(new Dimension(1280, 600));
      panel3.setOpaque(false);// �ǳ� ����� �����ϰ���
      panel3.add(panel4, BorderLayout.SOUTH);

      JPanel panel1 = new JPanel();// �÷����� �г� (��ǻ� ���)
      panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
      panel1.setOpaque(false);// �ǳ� ����� �����ϰ���
      panel1.add(panel2);
      panel1.add(panel3);

      background.add(panel1, BorderLayout.CENTER);
      frame.add(next);
      frame.add(round1);
      gameresult.add(nextgame);
      frame.add(gameresult);
      frame.add(background, BorderLayout.CENTER);
      // frame.setBackground(background);
      frame.pack();
      frame.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      // �������
      try {
         new exread(myrank);
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      exin exins = new exin();
      try {
         exins.start();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}