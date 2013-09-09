import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Grafik extends Canvas {
	
	int hoehe;
	int breite;
	Labyrinth lab;
	int Faktor = 4;
	//int startZielUmfang = (int)(Faktor*0.75);
	
	public Grafik(Labyrinth lab) {
		
		this.lab = lab;
		hoehe  = lab.hoehe;
		breite = lab.breite;
		
		//lab.Labyrinth[i][j].PositionX == 2;
		setBackground(Color.green); // weisser Hintergrund


		JFrame frame = new JFrame("Labyrinth"); 	// Fenster erzeugen   
		frame.getContentPane().add("Center", this); // ins Fenster
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(this.hoehe*Faktor, this.breite*Faktor);
	}


	public void paint(Graphics g) {
		
		g.fillOval(lab.Start[0],lab.Start[1],Faktor,Faktor);
		
		for(int i=0; i < breite; i++){
			for(int j=0;j < hoehe; j++){
				if (lab.Labyrinth[i][j].obererN == null  || lab.Labyrinth[i][j].obererN == Spielfeld.Rand)
					g.drawLine(Faktor*i,Faktor*j,Faktor*i+Faktor,Faktor*j);
				
				if (lab.Labyrinth[i][j].untererN == null || lab.Labyrinth[i][j].untererN == Spielfeld.Rand)
					g.drawLine(Faktor*i,Faktor*j+Faktor-1,i*Faktor+Faktor,j*Faktor+Faktor-1);
				 
				if (lab.Labyrinth[i][j].linkerN == null || lab.Labyrinth[i][j].linkerN == Spielfeld.Rand)
					g.drawLine(Faktor*i,Faktor*j,i*Faktor,j*Faktor+Faktor);
				
				if (lab.Labyrinth[i][j].rechterN == null || lab.Labyrinth[i][j].rechterN == Spielfeld.Rand)
					g.drawLine(Faktor*i+Faktor-1,j*Faktor,i*Faktor+Faktor-1,j*Faktor+Faktor);
			}
		}
	}
}





