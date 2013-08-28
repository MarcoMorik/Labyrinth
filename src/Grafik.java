//import java.awt.*;
import javax.swing.JFrame;


public class Grafik {

	public static void zeige() {
	
		
		JFrame frame = new JFrame("FrameDemo"); 				//Objekt der Klasse JFrame erstellen.
		frame.setTitle("Labyrinth");							//Name festlegen

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//Das Fenster mit X schließen können

		//...create emptyLabel...
		//frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

		frame.pack();											//Größe festlegen
		frame.setSize(länge*5,breite*5);
		frame.setLocation(50,50);

		frame.setVisible(true);									//Fenster sichtbar machen (was es nicht alles so gibt...)
	}

}
