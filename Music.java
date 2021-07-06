package aBeengers20;

import java.io.*;

import javazoom.jl.player.Player;

public class Music extends Thread { // 스레드 : 하나의 작은 프로그램
   private Player player;
   private boolean isLoop; //현재 곡이 무한반복인지 한번만 재생인지
   private File file;
   private FileInputStream fis;
   private BufferedInputStream bis;
   
   public Music(String name, boolean isLoop) {
      try {
         this.isLoop = isLoop;
         file = new File("./music/" + name); //파일 가져오기
         fis = new FileInputStream(file);
         bis = new BufferedInputStream(fis);
         player = new Player(bis);
      } catch(Exception e) { //예외처리 
         System.out.println(e.getMessage());
      }
   }
   public int getTime() { //시간분석
      if(player == null)
         return 0;
      return player.getPosition();
   }
   public void close() { // 곡 정지
      isLoop  = false;
      player.close();
      this.interrupt(); // 스레드 중지상태로 만듬
   }
   
   @Override
   public void run() 
   { //스레드 상속 시 무조건 실행
      try 
      {
         do 
         {
            player.play();//곡 실행
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
         } while(isLoop); //isLoop값이 True일 경우 무한반복
      } 
      
      catch(Exception e) 
      {
         
      }
   }
}