package aBeengers20;

import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import javax.swing.*;

public class ArrowButton extends JPanel{

   JButton bt;
   
   ArrowButton(String name){
      bt = new JButton(new ImageIcon("./image/" + name));
      
      bt.setContentAreaFilled(false);// ���ä���
      bt.setBorderPainted(false);// �׵θ�
      bt.setFocusPainted(false);// �������� �׵θ�
      bt.setSize(100, 100);
      
      add(bt);
      
   }

}