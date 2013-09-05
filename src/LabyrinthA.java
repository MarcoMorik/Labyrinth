
/**
 * @author Marco
 *
 */
public class LabyrinthA {
	Spielfeld[][] Labyrinth;
	int breite;
	int hoehe;
	int[] Start;
	int[] Ziel;

	public LabyrinthA(int breite, int hoehe){

		this.breite=breite;
		this.hoehe=hoehe;
		createLab();
		
		StartZielGenerator();
		ZufallsMauern();
		
	}
	
	private void createLab(){
		Spielfeld[][] Labyrinth;
		Labyrinth = new Spielfeld[breite][hoehe];
		for(int i=0; i<breite;i++){
			for(int j=0; j<hoehe;j++){
				Labyrinth[i][j] = new Spielfeld(i,j);
			}
		}
		for(int i=0; i<breite;i++){
			for(int j=0; j<hoehe;j++){
				Labyrinth[i][j].update(Labyrinth);
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
	public void ZufallsMauern(){
		int[] position;
		int seite;  // 0 links 1 oben 2 rechts 3 unten
		do{
			position = zufallskoordinate();
			seite = (int) Math.random() * 4;
			}while(Labyrinth[position[0]][position[1]].baueMauer(Labyrinth, seite));
		/**for(int i=0;i<(breite+hoehe);i++){
			position = zufallskoordinate();
			seite = (int) Math.random() * 4;
			Labyrinth[position[0]][position[1]].baueMauer(seite);
		} */
	}
	
	/** 1. Breite 2. Hoehe
	 */
	public int[] zufallskoordinate(){
		int h = (int ) Math.random() * hoehe;
		int b = (int) Math.random() * breite;
		int[] result = {b,h};
		return result;
	}
}

