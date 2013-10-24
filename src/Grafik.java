import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Grafik extends Canvas {
	
	int hoehe;
	int breite;
	Labyrinth lab;
	int faktor;
	//int startZielUmfang = (int)(Faktor*0.75);
	
	public Grafik(Labyrinth lab, int fak) {
		
		this.lab = lab;
		faktor =fak;
		hoehe  = lab.hoehe;
		breite = lab.breite;
		//lab.Labyrinth[i][j].PositionX == 8;
		setBackground(Color.green); // weisser Hintergrund


		JFrame frame = new JFrame("Labyrinth"); 	// Fenster erzeugen   
		frame.getContentPane().add("Center", this); // ins Fenster
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(this.breite*faktor, this.hoehe*faktor);
	}


	public void paint(Graphics g) {
		g.fillOval(lab.Start[0]*faktor, lab.Start[1]*faktor, faktor, faktor);
		g.fillOval(lab.Ziel[0]*faktor, lab.Ziel[1]*faktor, faktor, faktor);
		
		for(int i=0; i < breite; i++){
			for(int j=0;j < hoehe; j++){
				if (lab.Labyrinth[i][j].obererN == null  || lab.Labyrinth[i][j].obererN == Spielfeld.Rand)
					g.drawLine(faktor*i,faktor*j,faktor*i+faktor,faktor*j);
				
				if (lab.Labyrinth[i][j].untererN == null || lab.Labyrinth[i][j].untererN == Spielfeld.Rand)
					g.drawLine(faktor*i,faktor*j+faktor-1,i*faktor+faktor,j*faktor+faktor-1);
				 
				if (lab.Labyrinth[i][j].linkerN == null || lab.Labyrinth[i][j].linkerN == Spielfeld.Rand)
					g.drawLine(faktor*i,faktor*j,i*faktor,j*faktor+faktor);
				
				if (lab.Labyrinth[i][j].rechterN == null || lab.Labyrinth[i][j].rechterN == Spielfeld.Rand)
					g.drawLine(faktor*i+faktor-1,j*faktor,i*faktor+faktor-1,j*faktor+faktor);
			}
		}
	}
}





