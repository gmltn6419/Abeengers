package aBeengers20;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Clock1 extends JFrame implements Runnable {
   static Thread timethread;

   public Clock1() {
      // TODO Auto-generated method stub
      if (timethread == null) {
         timethread = new Thread(this);
         timethread.start();
      }
   }

   @Override
   public void run() { //게임시간표시
      // TODO Auto-generated method stub
      try {
         long time1 = System.currentTimeMillis();

         while (true) {
            long time2 = System.currentTimeMillis();

            String result;
            result = String.valueOf((int) ((time2 - time1) / 1000.0));

            Game1.second.setText(result);

            Thread.sleep(1000);// 1초 경과

         }

      } catch (InterruptedException e) {
         e.printStackTrace();
      }

   }

}