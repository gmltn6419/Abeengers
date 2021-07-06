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
   JLabel j; // 최고의 콩, 그냥 콩 그림 띄울 라벨
   Icon icon; // 최고의 콩, 그냥 콩 아이콘
   JButton bt; // 리플레이 버튼
   PngBackGroundPanel background;
   

   EndResult() {
      // 프레임 설정
      setTitle("ABEENGERS");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      Dimension dim = new Dimension(1280, 750); // 프레임크기지정
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);
      // setLocationRelativeTo(null);
      setPreferredSize(dim);
      setVisible(true);

      PngBackGroundPanel background = new PngBackGroundPanel(new ImageIcon("./image/총게임결과.png").getImage());

      j = new JLabel();

      // 임시**************************
      icon = new ImageIcon("./image/총게임결과_최고의콩.png");
      j.setIcon(icon);
      j.setSize(936, 366);
      j.setLocation(170, 220);
      music = new Music("최고의콩이.mp3", true);
      // 임시**************************
      // **********************************점수연산
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
      // **********************************점수연산
      
      /*
       * if(유저점수 >= 잘한 점수) {
       *       icon = new ImageIcon("./image/총게임결과_최고의콩.png");
       *       j.setIcon(icon); 
       *       j.setSize(936, 366); 
       *       j.setLocation(170, 220); 
       *       music = new Music("최고의콩이.mp3", true);
       * }
       * 
       * else { 
       * icon = new ImageIcon("./image/총게임결과_그냥콩.png"); 
       *       j.setIcon(icon);
       *       j.setSize(978, 370); 
       *       j.setLocation(165, 220); 
       *       music = new Music("그냥콩이.mp3", true);
       * }
       */

      bt = new JButton(new ImageIcon("./image/Exit.png"));
      bt.setBorderPainted(false); // 버튼 외곽선 없애줌.
      bt.setContentAreaFilled(false); // 버튼 내용 영역 채우기 안함.
      bt.setFocusPainted(false); // 선택됐을 때 생기는 테두리 안함.
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