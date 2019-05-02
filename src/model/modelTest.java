package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class modelTest {
    public static void main(String[] args){
        Piece whitePawn = new Pawn("p", 0);
        Piece blackPawn = new Pawn("P", 1);
        // simulate a check board
        Piece[] tempArr = new Piece[78];
        List<Piece> checkboard = Arrays.asList(tempArr);

        checkboard.set(63,whitePawn);
        checkboard.set(54, blackPawn);
        ArrayList<Integer> moves = whitePawn.getValidMoves(checkboard, 63);
        for(Integer pos : moves){
            System.out.print(pos+"  ");
        }

    }
}
