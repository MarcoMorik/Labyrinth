import java.util.ArrayList;


public class Spielfeld {
	Spielfeld linkerN;
	Spielfeld rechterN;
	Spielfeld obererN;
	Spielfeld untererN;
	private int eigenschaft;
	static final int NORMAL = 0;
	static final int STARTFELD = 1;
	static final int ENDFELD = 2;
	static final int BESUCHT = 3;
	static final int RANDFELD = 4 ;
	int PositionX;
	int PositionY;
	int Markiert;
	static final Spielfeld Rand = new Spielfeld(-1,-1);
	
	public Spielfeld(int x,int y){
		this.eigenschaft = NORMAL;
		this.PositionX = x;
		this.PositionY = y;
		this.Markiert=0;
		
	}
	public void update(Spielfeld[][] lab){
		if (this.PositionX == 0) this.linkerN = Rand ;
		else this.linkerN = lab[this.PositionX-1][this.PositionY];
		if (this.PositionY == 0) this.obererN = Rand;
		else this.obererN = lab[this.PositionX][this.PositionY-1];
		if (this.PositionX == lab.length-1) this.rechterN = Rand;
		else this.rechterN = lab[this.PositionX+1][this.PositionY];
		if (this.PositionY == lab[0].length-1) this.untererN = Rand;
		else this.untererN = lab[this.PositionX][this.PositionY+1];
	}

	public void updateNurRand(Spielfeld[][] lab){

		if (this.PositionX == 0) this.linkerN = Rand ;
		else this.linkerN = null;
		if (this.PositionY == 0) this.obererN = Rand;
		else this.obererN = null;
		if (this.PositionX == lab.length-1) this.rechterN = Rand;
		else this.rechterN = null;
		if (this.PositionY == lab[0].length-1) this.untererN = Rand;
		else this.untererN = null;
	}
	public ArrayList<Spielfeld> schritte(){
		ArrayList<Spielfeld> result = new ArrayList<>();
		if(linkerN != null && linkerN != Rand) result.add(linkerN);
		if(rechterN != null && rechterN != Rand) result.add(rechterN);
		if(obererN != null && obererN != Rand) result.add(obererN);
		if(untererN != null && untererN != Rand) result.add(untererN);
		return result;
		
	}
	public int[] koordinaten(){
		int[] result = {PositionX,PositionY};
		return result;
	}
	public void erzeugeStart(){
		this.eigenschaft = STARTFELD;
	}
	public void erzeugeZiel(){
		this.eigenschaft = ENDFELD;
	}
	public ArrayList<Integer> unbesuchteN(Spielfeld[][] lab){
		ArrayList<Integer> nachbarn = new ArrayList<Integer>();
		if(this.linkerN != Rand){
			if (lab[this.PositionX-1][this.PositionY].eigenschaft == NORMAL) nachbarn.add(0);}
		if(this.obererN != Rand){
			if (lab[this.PositionX][this.PositionY-1].eigenschaft == NORMAL) nachbarn.add(1);}
		if(this.rechterN != Rand){
			if (lab[this.PositionX+1][this.PositionY].eigenschaft == NORMAL) nachbarn.add(2);}
		if(this.untererN != Rand){
			if (lab[this.PositionX][this.PositionY+1].eigenschaft == NORMAL) nachbarn.add(3);}
			
		return nachbarn;
	}
	public boolean baueMauer(Spielfeld[][] lab,int seite){
		switch(seite){  //Seite: 0 links 1 oben 2 rechts 3 unten
			case 0: if(linkerN != null && linkerN != Rand){
				 linkerN = null;
				 lab[this.PositionX-1][this.PositionY].rechterN = null;
				 return true;
			}
			else return false;
			case 1:if(obererN != null && obererN != Rand){
				 obererN = null;
				 lab[this.PositionX][this.PositionY-1].untererN = null;
				 return true;
			}
			else return false;
			case 2:if(rechterN != null && rechterN != Rand){
				 rechterN = null;
				 lab[this.PositionX+1][this.PositionY].linkerN = null;
				 return true;
			}
			else return false;
			case 3:if(untererN != null && untererN != Rand){
				 untererN = null;
				 lab[this.PositionX][this.PositionY+1].obererN = null;
				 return true;
			}
			default:
				return false;
		}
	}
	// 0: links 1 : oben 2: rechts 3 : unten
	public int[] baueWeg(Spielfeld[][] lab, int seite){
		switch(seite){ 
		case 0: if(linkerN == null){
			 linkerN = lab[this.PositionX-1][this.PositionY];
			 lab[this.PositionX-1][this.PositionY].rechterN = this ;
			 linkerN.eigenschaft = BESUCHT;
			 return linkerN.koordinaten();
		}
		else return this.koordinaten();
		case 1:if(obererN == null){
			 obererN = lab[this.PositionX][this.PositionY-1];
			 lab[this.PositionX][this.PositionY-1].untererN = this ;
			 obererN.eigenschaft = BESUCHT;
			 return obererN.koordinaten();
		}
		else return this.koordinaten();
		case 2:if(rechterN == null){
			 rechterN = lab[this.PositionX+1][this.PositionY];
			 lab[this.PositionX+1][this.PositionY].linkerN = this;
			 rechterN.eigenschaft = BESUCHT;
			 return rechterN.koordinaten();
		}
		else return this.koordinaten();
		case 3:if(untererN == null){
			 untererN = lab[this.PositionX][this.PositionY+1];
			 lab[this.PositionX][this.PositionY+1].obererN = this;
			 untererN.eigenschaft = BESUCHT;
			 return untererN.koordinaten();
		}
		default:
			return this.koordinaten();
	}
	}
}
