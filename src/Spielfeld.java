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
	int PositionX;
	int PositionY;
	
	
	
	public Spielfeld(int x,int y){
		this.eigenschaft = NORMAL;
		this.PositionX = x;
		this.PositionY = y;
		
	}
	public void update(Spielfeld[][] lab){
		if (this.PositionX == 0) this.linkerN = null;
		else this.linkerN = lab[this.PositionX-1][this.PositionY];
		if (this.PositionY == 0) this.obererN = null;
		else this.obererN = lab[this.PositionX][this.PositionY-1];
		if (this.PositionX == lab.length-1) this.rechterN = null;
		else this.rechterN = lab[this.PositionX+1][this.PositionY];
		if (this.PositionY == lab[0].length-1) this.untererN = null;
		else this.untererN = lab[this.PositionX][this.PositionY+1];
	}
	public ArrayList<Spielfeld> schritte(){
		ArrayList<Spielfeld> result = new ArrayList<>();
		if(linkerN != null) result.add(linkerN);
		if(rechterN != null) result.add(rechterN);
		if(obererN != null) result.add(obererN);
		if(untererN != null) result.add(untererN);
		return result;
		
	}
	public void erzeugeStart(){
		this.eigenschaft = STARTFELD;
	}
	public void erzeugeZiel(){
		this.eigenschaft = ENDFELD;
	}
	public boolean baueMauer(Spielfeld[][] lab,int seite){
		switch(seite){  //Seite: 0 links 1 oben 2 rechts 3 unten
			case 0: if(linkerN != null){
				 linkerN = null;
				 lab[this.PositionX-1][this.PositionY].rechterN = null;
				 return true;
			}
			else return false;
			case 1:if(obererN != null){
				 obererN = null;
				 lab[this.PositionX][this.PositionY-1].untererN = null;
				 return true;
			}
			else return false;
			case 2:if(rechterN != null){
				 rechterN = null;
				 lab[this.PositionX+1][this.PositionY].linkerN = null;
				 return true;
			}
			else return false;
			case 3:if(untererN != null){
				 untererN = null;
				 lab[this.PositionX][this.PositionY+1].obererN = null;
				 return true;
			}
			default:
				return false;
		}
	}
}
