package aBeengers20;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EndResult extends JFrame implements ActionListener {

   Music music;
   JLabel j; // �ְ��� ��, �׳� �� �׸� ��� ��
   Icon icon; // �ְ��� ��, �׳� �� ������
   JButton bt; // ���÷��� ��ư
   PngBackGroundPanel background;
   

   EndResult() {
      // ������ ����
      setTitle("ABEENGERS");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      Dimension dim = new Dimension(1280, 750); // ������ũ������
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);
      // setLocationRelativeTo(null);
      setPreferredSize(dim);
      setVisible(true);

      PngBackGroundPanel background = new PngBackGroundPanel(new ImageIcon("./image/�Ѱ��Ӱ��.png").getImage());

      j = new JLabel();

      // �ӽ�**************************
      icon = new ImageIcon("./image/�Ѱ��Ӱ��_�ְ�����.png");
      j.setIcon(icon);
      j.setSize(936, 366);
      j.setLocation(170, 220);
      music = new Music("�ְ�������.mp3", true);
      // �ӽ�**************************
      // **********************************��������
      int myScore  = 0;
         for(int i = 0; i<4; i++) {
            myScore += Main.score[i];
         }
         
         try {
            new exread(myScore);
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
      // **********************************��������
      
      /*
       * if(�������� >= ���� ����) {
       *       icon = new ImageIcon("./image/�Ѱ��Ӱ��_�ְ�����.png");
       *       j.setIcon(icon); 
       *       j.setSize(936, 366); 
       *       j.setLocation(170, 220); 
       *       music = new Music("�ְ�������.mp3", true);
       * }
       * 
       * else { 
       * icon = new ImageIcon("./image/�Ѱ��Ӱ��_�׳���.png"); 
       *       j.setIcon(icon);
       *       j.setSize(978, 370); 
       *       j.setLocation(165, 220); 
       *       music = new Music("�׳�����.mp3", true);
       * }
       */

      bt = new JButton(new ImageIcon("./image/Exit.png"));
      bt.setBorderPainted(false); // ��ư �ܰ��� ������.
      bt.setContentAreaFilled(false); // ��ư ���� ���� ä��� ����.
      bt.setFocusPainted(false); // ���õ��� �� ����� �׵θ� ����.
      bt.addActionListener(this);
      bt.setSize(227, 68);
      bt.setLocation(900, 565);
      bt.setVisible(true);
      
      music.start();

      

      add(bt);
      add(j);
      add(background);
      pack();
   }

   @Override
   public void actionPerformed(ActionEvent e) {

      music.close();
      setVisible(false);
      dispose();
      
      System.exit(0);
   }
}