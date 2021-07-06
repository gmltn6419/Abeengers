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
      
      bt.setContentAreaFilled(false);// 배경채우기
      bt.setBorderPainted(false);// 테두리
      bt.setFocusPainted(false);// 눌렀을때 테두리
      bt.setSize(100, 100);
      
      add(bt);
      
   }

}