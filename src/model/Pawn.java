package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Pawn Class inherited from the piece
 *
 */
public class Pawn extends Piece{

	public Pawn(String color){
		super(color);
		setId((getColor() == 0)? "P" :"p"); //white is uppercase P, black is p.)
	}
//	public Pawn(String color, int[] pos, Piece myKing){
//		super(color, pos, myKing);
//	}

	@Override
	public ArrayList<Integer> getValidMoves(List<Piece> state, int pos)
	{
		//Pawn can move only one step except the first chance when it may move 2 steps
		//It can move in a diagonal line only for attacking a piece of opposite color
		//It cannot move backward or move forward to attack a piece
		/*
		validMoves.clear();

		if(getColor()==0) //white
		{
			if (state.get(pos + N) == null) { //move one step upward.
				validMoves.add(pos + N);
			}
			if (state.get(pos + N + E)!= null && state.get(pos + N + E).getColor() != getColor()) { //capture the northeast
				validMoves.add(pos + N + E);
			}
			if (state.get(pos + N + W)!=null && state.get(pos + N + W).getColor() != getColor()) { //capture the northwest
				validMoves.add(pos + N + W);
			}
			if (pos % 60 >= 1 && pos % 60 <= 8)//first move, P on pos 61-68
			{
				if (state.get(pos + N + N) == null) {
					validMoves.add(pos + N + N);
				}
			}
		}

		if(getColor()==1) //black
		{
			if (state.get(pos + S) == null) { //move one step upward.
				validMoves.add(pos + S);
			}
			if (state.get(pos + S + E)!=null && state.get(pos + S + E).getColor() != getColor()) { //capture the northeast
				validMoves.add(pos + S + E);
			}
			if (state.get(pos + S + W)!=null && state.get(pos + S + W).getColor() != getColor()) { //capture the northwest
				validMoves.add(pos + S + W);
			}
			if (pos % 10 >= 1 && pos % 10 <= 8)//first move which p on pos 11-18.
			{
				if (state.get(pos + N + N) == null) {
					validMoves.add(pos + N + N);
				}
			}
		}*/

		return validMoves;
	}

	@Override
	public String toString() {
		return getId();
	}
}
