package aBeengers20;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BlackButton implements ActionListener {

   JButton bt = new JButton();
   
   BlackButton()
   {
      bt.setPreferredSize(new Dimension(100, 100));
       bt.setBorderPainted(false); // ¹öÆ° ¿Ü°û¼± ¾ø¾ÖÁÜ.
       bt.setBackground(Color.BLACK);
       bt.setFocusPainted(false);
       bt.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      JButton j = new JButton();
      j = (JButton)e.getSource();
      j.setVisible(false);
   }
}