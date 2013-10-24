import java.util.ArrayList;


public class LabyrinthC extends Labyrinth {
	public LabyrinthC(int breite, int hoehe){
		this.breite=breite;
		this.hoehe=hoehe;
		createLab();
		
		StartGenerator();
		baueWege();
		
	}
	
	private void createLab(){
		Labyrinth = new Spielfeld[breite][hoehe];
		for(int i=0; i<breite;i++){
			for(int j=0; j<hoehe;j++){
				Labyrinth[i][j] = new Spielfeld(i,j);
			}
		}

		for(int i=0;i<breite;i++){
			for(int j=0;j<hoehe;j++){
				Labyrinth[i][j].updateNurRand(Labyrinth);
			}
		}
		
		
		
	}
	public void StartGenerator(){
		this.Start = zufallskoordinate();

		Labyrinth[Start[0]][Start[1]].erzeugeStart();
	}
	
	// Rekursiv Backtracker Algorithmus
	public void baueWege(){
		ArrayList<Integer> moeglichkeit;
		Spielfeld current;
		int passiert=0;
		int[] next = {0,0};
		ArrayList<Spielfeld> stack = new ArrayList<Spielfeld>();
		stack.add(Labyrinth[Start[0]][Start[1]]);
		while(!(stack.isEmpty())){
			current=  stack.get(stack.size()-1);
			moeglichkeit = current.unbesuchteN(Labyrinth);
			if(moeglichkeit.isEmpty()){
				if(passiert==0){
					Labyrinth[next[0]][next[1]].erzeugeZiel();
					this.Ziel= next;
					passiert=1;
				}
				stack.remove(stack.size()-1);
			}
			else{
				next =current.baueWeg(Labyrinth, moeglichkeit.get((int) (Math.random() * moeglichkeit.size())));
				stack.add(Labyrinth[next[0]][next[1]]);
			}
			 
		
		}
		
		
	}
	public int[] zufallskoordinate(){
		int h = (int )( Math.random() * this.hoehe);
		int b = (int)( Math.random() * this.breite);
		int[] result = {b,h};
		return result;
	}

	
	}

