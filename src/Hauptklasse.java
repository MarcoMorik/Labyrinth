
public class Hauptklasse {
	
	public static void main(String args[]){
		
		System.out.println("Starte");
		LabyrinthB lab = new LabyrinthB(300,300);
		new Grafik(lab);
		System.out.println("Fertig");
	}
}
