import java.util.ArrayList;

// Labyrinth mit dem verschiedenen Startpunkten
public class LabyrinthB {
	Spielfeld[][] Labyrinth;
	int breite;
	int hoehe;

	int[] Start;
	int[] Ziel;
	public LabyrinthB(int breite, int hoehe){
		this.breite=breite;
		this.hoehe=hoehe;
		createLab();
		StartZielGenerator();
		baueWege(breite);
		
	}
	
	private void createLab(){
		Spielfeld[][] Labyrinth;
		Labyrinth = new Spielfeld[breite][hoehe];
		for(int i=0; i<breite;i++){
			for(int j=0; j<hoehe;j++){
				Labyrinth[i][j] = new Spielfeld(i,j);
			}
		}
		
		
	}
	public void StartZielGenerator(){
		this.Start = zufallskoordinate();
		this.Ziel = zufallskoordinate();
		while(Ziel[0] == Start[0] && Ziel[1] == Start[1]){
			Ziel = zufallskoordinate();
		}

		Labyrinth[Start[0]][Start[1]].erzeugeStart();
		Labyrinth[Ziel[0]][Ziel[1]].erzeugeZiel();
	}
	
	// Es werden Anzahl viele Felder markiert, von denen aus Zufällige wege ausgehen
	public void baueWege(int Anzahl){
		ArrayList<int[]> Wurmer = new ArrayList<int[]>();
		for(int i=0;i<Anzahl;i++){
			if(i<Anzahl-2)	Wurmer.add(zufallskoordinate());
			else if(i== (Anzahl-2)) Wurmer.add(Ziel);
			else Wurmer.add(Start);
			Labyrinth[Wurmer.get(i)[0]][Wurmer.get(i)[1]].Markiert=1;
		}
		while(Wurmer.size()>=1){
			for(int[] wurm : Wurmer){
				int richtung = (int) Math.random() * 4;
				wurm = Labyrinth[wurm[0]][wurm[1]].baueWeg(Labyrinth, richtung);
				if(Labyrinth[wurm[0]][wurm[1]].Markiert==0){
					Labyrinth[wurm[0]][wurm[1]].Markiert=1;
				}
				else{
					Wurmer.remove(wurm);
				}
			}
		}
		
	}
	public int[] zufallskoordinate(){
		int h = (int ) Math.random() * hoehe;
		int b = (int) Math.random() * breite;
		int[] result = {b,h};
		return result;
	}

	
	}
