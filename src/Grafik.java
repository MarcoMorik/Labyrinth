import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


class MyButtonFrame extends JFrame{
	
	public MyButtonFrame() {
		super("JFrame mit Button");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon meinBild = new ImageIcon("Kreuz.png");	//Bild einf�gen C:\\Users\\Maximus\\Dropbox\\eclipse_workspace\\MyFrame\\Bild.bmp
		
		JLabel meinLabel;									//Einf�gen in den Inhaltsspeicher des Fensters
		for (int i=0; i<10*10; i++) {
			meinLabel = new JLabel(meinBild);
			getContentPane().add(meinLabel);					
		}
		
		getContentPane().setLayout(new GridLayout(10,10));	
		
		//pack();											//ideale Gr��e einstellen
		setSize(500,500);
		setLocation(50,50);									//Ort festlegen
		setVisible(true);									//Fenster sichtbar machen(was es nicht so alles gibt...)
	}

}
