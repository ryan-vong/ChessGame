package model;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the Piece Class. It is an abstract class from which all the actual pieces are inherited.
 * It defines all the function common to all the pieces
 * The move() function an abstract function that has to be overridden in all the inherited class
 * It implements Cloneable interface as a copy of the piece is required very often
 */
public abstract class Piece {

	private int color; // 0 = white, 1 = black
	private String id = null; //prnbqk are black pieces and PRNBQK are white pieces
	private  Pos pos;
	private Piece myKing;

//	protected final int N = -10, S = 10, E = 1, W = -1;

	public Piece(String color){
		setColor(color);

	}
//	public Piece(String color, int[] pos, Piece myKing){
//	setColor(color);
//	this.pos = pos;
//	this.myKing = myKing;
//	}


	protected ArrayList<Integer> validMoves = new ArrayList();  //Protected (access from child classes)

	public abstract ArrayList<Integer> getValidMoves(List<Piece> state, int pos);  //Abstract Function. Must be overridden
	
//	public void setId(String id)
//	{
//		this.id=id;
//	}
	
	public String getId()
	{
		return id;
	}

	private void setColor(String color){
		if(color.equalsIgnoreCase("w")){
			this.color = 0;
		}else {
			this.color = 1;
		}
	}
	public int getColor() {
		return color;
	}
   	public Pos getPos(){
		return pos;
	}

	public void setPos(Pos pos){
		this.pos = pos;
	}
	public Piece getMyKing() {
		return myKing;
	}
	public void setMyKing(Piece king){
		this.myKing = king;
	}

	protected void setId(String id){
		this.id = id;
	}

}