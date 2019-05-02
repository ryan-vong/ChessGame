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

	private int color;
	private String id = null; //prnbqk are black pieces and PRNBQK are white pieces

	protected final int N = -10, S = 10, E = 1, W = -1;

	protected ArrayList<Integer> validMoves = new ArrayList();  //Protected (access from child classes)

	public abstract ArrayList<Integer> getValidMoves(List<Piece> state, int pos);  //Abstract Function. Must be overridden
	
	public void setId(String id)
	{
		this.id=id;
	}
	
	public void setColor(int c)
	{
		this.color=c;
	}
	
	public String getId()
	{
		return id;
	}
	
	public int getcolor()
	{
		return this.color;
	}

}