import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Grafik extends Canvas {
	
	public Grafik(LabyrinthA lab) {
		
		//lab.Labyrinth[i][j].PositionX == 2;
		setBackground(Color.pink); // weisser Hintergrund


		JFrame frame = new JFrame("Labyrinth"); 	// Fenster erzeugen   
		frame.getContentPane().add("Center", this); // ins Fenster
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(190, 190);
	}


	public void paint(Graphics g) {
		g.drawLine(0,0,190,190);
	}
}