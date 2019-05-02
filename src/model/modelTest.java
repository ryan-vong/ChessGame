package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class modelTest {
    public static void main(String[] args){
//        System.out.println("PRNBQK".indexOf("p"));
        Piece whitePawn = new Pawn("P");
        System.out.println(whitePawn.getColor());
        Piece blackPawn = new Pawn("p");
        System.out.println(blackPawn.getColor());
        // simulate a check board
        Piece[] tempArr = new Piece[78];
        List<Piece> checkboard = Arrays.asList(tempArr);

        checkboard.set(63,whitePawn);
        checkboard.set(54, blackPawn);
        ArrayList<Integer> moves = whitePawn.getValidMoves(checkboard, 63);
        System.out.println("Valid moves of white pawn on 63 are: 53, 43, 54");
        for(Integer pos : moves){
            System.out.print(pos+"  ");
        }

    }
}
