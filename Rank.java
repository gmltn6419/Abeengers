package aBeengers20;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class Rank extends JPanel{
	String ranks;
	Rank() throws IOException{
		JPanel pn = new JPanel();
		
		exin exins = new exin();
		this.ranks = exins.ranks();
		
	}
}
