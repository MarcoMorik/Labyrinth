
public class Hauptklasse {
	
	public static void main(String args[]){
		
		System.out.println("Starte");
		LabyrinthA lab = new LabyrinthA(30,30);
		new Grafik(lab);
		System.out.println("Fertig");
	}
}
