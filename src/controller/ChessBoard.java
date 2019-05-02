package controller;

import model.King;
import model.Pawn;
import model.Piece;
import model.Pos;

import java.util.ArrayList;
import java.util.List;

/**
 * the checkBoard simulates a check board
 * whose rows are from 0 to 7 and columns are from 0 to 7.?????????
 */
public class ChessBoard {
    private List<List<Piece>> state;
//    private


    public ChessBoard(){
        //create the board space as 8 rows and 8 columns.
        for(int r = 0; r < 8; r++){
            List<Piece> row = new ArrayList<>(8);
            for(int c = 0; c < 8; c++){
                row.add(null);
            }
            state.add(row);
        }
        //initiate 32 pieces and fill the board
        initiatePawns();
        initiateKings();



    }

    /**
     * precondition: des is in the list of pos's valid moves
     */
    public void moves(Pos from, Pos to){
        Piece des = state.get(to.getRow()).get(to.getCol());
        Piece cur = state.get(from.getRow()).get(from.getCol());
//        if(des !=null){ //capture or pure move
            des = cur;
            cur = null;

    }

    private void initiateKings(){
        King K = new King("w");
        King k = new King("b");
        state.get(0).add(4,k); //rnbqkbnr
        state.get(7).add(4,k); //RNBQKBNR

    }

    private void initiatePawns(){
        //8 black pawns on row[1]: ppppppp
        int row = 1;
        for(int c = 0; c < 8; c++) {
            Pos pos = new Pos(row, c);
            Piece pawn = new Pawn("b");
            pawn.setPos(pos);
            state.get(row).add(pawn);
        }
        //8 white pawns on row[6]: PPPPPPPP
        row = 6;
        for(int c = 0; c < 8; c++) {
            Pos pos = new Pos(row, c);
            Piece pawn = new Pawn("w");
            pawn.setPos(pos);
            state.get(row).add(pawn);
        }
    }

    /**
     * Still Working On It.
     * Like fen 4kb1r/p2rqppp/5n2/1B2p1B1/4P3/1Q6/PPP2PPP/2K4R w k - 0 14
     * @return
     */
    public String converToFen(){
        String fen = "";
        for(int r = 0; r < 8; r++){
            List<Piece> row = state.get(r);
            int emptySquare = 0;
            for(int c = 0; c < 8; c++){
                Piece piece = row.get(c);
                if(piece != null){
                    if(emptySquare != 0){
                        fen += emptySquare;
                    }
                    fen += piece.toString();
                }else{
                    emptySquare++;
                }
                if(c == 7){
                    fen += "/";
                }
            }
        }
        return fen;
    }

}
