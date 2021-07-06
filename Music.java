package aBeengers20;

import java.io.*;

import javazoom.jl.player.Player;

public class Music extends Thread { // ������ : �ϳ��� ���� ���α׷�
   private Player player;
   private boolean isLoop; //���� ���� ���ѹݺ����� �ѹ��� �������
   private File file;
   private FileInputStream fis;
   private BufferedInputStream bis;
   
   public Music(String name, boolean isLoop) {
      try {
         this.isLoop = isLoop;
         file = new File("./music/" + name); //���� ��������
         fis = new FileInputStream(file);
         bis = new BufferedInputStream(fis);
         player = new Player(bis);
      } catch(Exception e) { //����ó�� 
         System.out.println(e.getMessage());
      }
   }
   public int getTime() { //�ð��м�
      if(player == null)
         return 0;
      return player.getPosition();
   }
   public void close() { // �� ����
      isLoop  = false;
      player.close();
      this.interrupt(); // ������ �������·� ����
   }
   
   @Override
   public void run() 
   { //������ ��� �� ������ ����
      try 
      {
         do 
         {
            player.play();//�� ����
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
         } while(isLoop); //isLoop���� True�� ��� ���ѹݺ�
      } 
      
      catch(Exception e) 
      {
         
      }
   }
}