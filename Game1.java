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

   NextButton round1; // 라운드1 그림
   NextButton next; // 라운드 "클릭" 투명 버튼
   Cursor cursor; // 마우스 커서 변경을 위해 사용
   Image img; // 마우스 커서 이미지
   ImageIcon icon; // 두더지 배경 이미지 저장하는 아이콘

   static Dubutton[] db1 = new Dubutton[16];

   static int myrank;
   static String rank;
   static JLabel score;
   static JLabel second;
   static NextButton nextgame;
   static PngBackGroundPanel gameresult;

   Game1() throws IOException {
      Dimension dim = new Dimension(1280, 750); // 프레임크기지정
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      JFrame frame = new JFrame(); // 프레임생성
      frame.setPreferredSize(dim); // 프레임크기 넣어주기
      frame.setTitle("ABEENGERS"); // 프레임의 타이틀
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 엑스 누르면 꺼지냐
      frame.setResizable(false);// 창크기 고정
      // frame.setLocationRelativeTo(null); // 창을 화면의 가운데에 띄우기
      frame.setLocation((screenSize.width - dim.width) / 2, (screenSize.height - dim.height) / 2);

      // 노래
      music = new Music("두더지.mp3", true);
      music.start();// 시작~

      // 마우스 변경
      Toolkit tk = Toolkit.getDefaultToolkit();
      img = tk.getImage("./image/두더지마우스.png");
      Point point = new Point(0, 0);
      cursor = tk.createCustomCursor(img, point, "corsor1");
      setCursor(cursor);

      // 두더지 배경(계속 떠있음), 게임 종료 결과 배경(게임 끝난 후 보여줌)
      icon = new ImageIcon("./image/두더지배경1.png");
      gameresult = new PngBackGroundPanel(new ImageIcon("./image/1라운드게임결과.png").getImage());
      gameresult.setVisible(false);

      // 두더지 배경 올라가는 패널
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
            setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
         }
      };

      // 다음 게임으로 넘어가는 버튼
      nextgame = new NextButton("이벤트두더지.png");
      nextgame.bt.setPreferredSize(new Dimension(1280, 720));
      nextgame.bt.setSize(150, 150);
      nextgame.bt.setLocation(950, 460); // 위치 설정
      // setPreferredSize, setSize 해줘야 버튼이 보임
      nextgame.bt.setVisible(false);
      nextgame.bt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            music.close();
            frame.setVisible(false);
            frame.dispose();

            try {
               new Change2(); // 전환2로 이동
            } catch (MalformedURLException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }

         }
      }); // 여기에 이벤트를 주겠따

      /*
      // 랭킹가져오기 ***************************
      NextButton ranking = new NextButton("작은두더지.png"); // 점수
      ranking.bt.addActionListener(this);
      ranking.bt.setPreferredSize(new Dimension(200, 0));// 버튼 위치 다시설정
      ranking.bt.setSize(200, 200);
      */

      Font font = new Font("헤움버블S", Font.BOLD, 100);
      Color color = new Color(229, 0, 0);
      
      myrank = 0; // 저장할점수
      score = new JLabel("0");
      score.setFont(font);
      score.setBounds(1050, 20, 250, 100);
      
      // 시간
      second = new JLabel("0");
      second.setFont(font);
      second.setForeground(color);
      second.setBounds(200, 20, 200, 100);

      // 시간이랑 점수 올라가는 패널
      JPanel panel2 = new JPanel();
      panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 내부에 10픽셀씩 공백
      panel2.setLayout(null); // FlowLayout과 똑같은데 자동 줄바꿈 안함. X_AXIS : 가로로 쭉 나열해줌
      panel2.setOpaque(false);// 판넬 배경을 투명하게함
      panel2.setPreferredSize(new Dimension(1280, 150));
      panel2.add(second);
      panel2.add(score);

      // 두더지들 올라감
      JPanel panel4 = new JPanel();
      panel4.setOpaque(false);// 판넬 배경을 투명하게함
      panel4.setLayout(new GridLayout(4, 4)); /////// 버튼만들기
      panel4.setPreferredSize(new Dimension(1250, 560));

      // 라운드1 두더지게임 설명 이미지
      round1 = new NextButton("라운드1.png");
      round1.bt.setSize(1280, 720);
      round1.bt.setLocation(0, 0);

      // 라운드 창 : 넥스트 버튼 - 액션 실행
      next = new NextButton("투명.png");
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
      }); // 여기에 이벤트를 주겠따

      JPanel panel3 = new JPanel();
      panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      panel3.setPreferredSize(new Dimension(1280, 600));
      panel3.setOpaque(false);// 판넬 배경을 투명하게함
      panel3.add(panel4, BorderLayout.SOUTH);

      JPanel panel1 = new JPanel();// 올려놓을 패널 (사실상 배경)
      panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
      panel1.setOpaque(false);// 판넬 배경을 투명하게함
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
      // 점수기록
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