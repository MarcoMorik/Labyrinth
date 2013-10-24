
public class Hauptklasse {
	
	public static void main(String args[]){
		int faktor= 16;
		System.out.println("Starte");
		Labyrinth lab = new LabyrinthC(80,40);
		new Grafik(lab,faktor);
		System.out.println("Fertig");
	}
}
