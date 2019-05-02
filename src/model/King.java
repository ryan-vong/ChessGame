package model;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private List<Piece> attackers;
    public King(String color){
        super(color);
        setId((getColor() == 0)? "K" :"k"); //white is uppercase K, black is lower case k.
    }

    public boolean isChecked(List<List<Piece>> state) {
        int x = getPos().getRow();
        int y = getPos().getCol();
        checkEast(x, y, state);
        checkWest(x, y, state);
        List<Piece> northEast = new ArrayList<Piece>;
        checkNorthEast(x, y, state);
        checkSouthWest(x, y, state);

        return (attackers != null);
    }
    @Override
    public ArrayList<Integer> getValidMoves(List<Piece> state, int pos) {
        return null;
    }


    /* if there is enemy queen/ rook on the east side of the same row,
     * add it to the attackers list.
     */
    private void checkEast(int x, int y, List<List<Piece>> state){
        int stopCol = -1;
        List<Piece> row = state.get(x);
        for(int c = y; c < 8 && (row.get(c) == null); c++){ //checking east side
            stopCol = c;
        }
        if(stopCol != -1) {
            Piece stopper = row.get(stopCol);
            addAttacker(stopper, "E");
        }
    }
    /**
     * if there is enemy queen/ rook on the east side of the same row,
     * add it to the attackers list.
     */
    private void checkWest(int x, int y, List<List<Piece>> state){
        int stopCol = -1;
        List<Piece> row = state.get(x);
        for(int c = y; c <= 0 && (row.get(c) == null); c--){ //checking west side
            stopCol = c;
        }
        if(stopCol != -1) {
            Piece stopper = row.get(stopCol);
            addAttacker(stopper, "W");
        }
    }

    private void checkMarchingPawn(Piece stopper, int color){
        if(stopper != null){
            if(stopper.getColor())
        } getColor() == 0)
    }
    private void checkNorthEast(int x, int y, List<List<Piece>> state){
        Piece stopper = state.get(x - 1).get(y + 1); //the first Piece on NE direction;
        if(stopper != null && getColor() == 0 && isEnemyMarchingPawn(stopper)){ //white king be careful about NW/NE black pawn.
            attackers.add(stopper);
        }
        Pos stopPos = new Pos(-1, -1);

        for(int i = x -1 ; i >= 0; i--){
            for(int j = y + 1; j <= 7; j++){
                stopper = state.get(i).get(j);
                if(stopper != null){
                    stopPos = stopper.getPos();
                }
            }
        }
        if(stopPos.isValid()){
            addAttacker(stopper, "NE");
        }
    }
    private void checkSouthWest(int x, int y, List<List<Piece>> state){
        Pos stopPos = new Pos(-1, -1);
        Piece stopper = null;
        for(int i = x + 1 ; i <= 7; i++){
            for(int j = y - 1; j >= 0; j--){
                stopper = state.get(i).get(j);
                if(stopper != null){
                    stopPos = stopper.getPos();
                }
            }
        }
        if(stopPos.isValid()){
            addAttacker(stopper, "SW");
        }
    }
    private void checkNorthWest(int x, int y, List<List<Piece>> state){
        Piece stopper = state.get(x - 1).get(y -1); //the first Piece on NW direction;
        if(getColor() == 0 && isEnemyMarchingPawn(stopper)){ //white king be careful about NW/NE black pawn.
            attackers.add(stopper);
        }
        for(int i = x - 1 ; i >= 0; i--){
            for(int j = y - 1; j >= 0; j--){
                stopper = state.get(i).get(j);

                addAttacker(stopper,"NW");
                if(isEnemyQueenOrRook(stopper)){
                    attackers.add(stopper);
                }
            }
        }
    }

    private void addAttacker(List<Piece> row, int stopCol){
        Piece stopper = row.get(stopCol);
        if(stopper.getColor() != getColor()&& "QR".equalsIgnoreCase(stopper.toString())) {
                attackers.add(stopper);
        }
    }
    private boolean isEnemyQueenOrRook(Piece stopper){
        return (stopper.getColor() != getColor()&& "QR".equalsIgnoreCase(stopper.toString()));
    }
    private boolean isEnemyMarchingPawn(Piece stopper){
        return (stopper.getColor() != getColor()&& "P".equalsIgnoreCase(stopper.toString()));
    }

    /**
     * Check if the stopper piece is potential attacker. If so, add to the attackers list.
     * @param stopper
     * @param direct
     */
    private void addAttacker(Piece stopper, String direct){
//        stopper = row.get(stopCol);
        if(stopper.getColor() != getColor(){
            switch (direct) {
                //on direction of east/west, attackers are enemy queen and rook.
                case "E":
                case "W":
                    if ("QR".equalsIgnoreCase(stopper.toString())) {
                        attackers.add(stopper);
                    }
                    break;
                //on direction of NW/west, attackers are enemy queen and rook.
                case "NW":
                case "NE":
                case "SW":
                case "SE":
                    if ("QB".equalsIgnoreCase(stopper.toString())) {
                        attackers.add(stopper);
                    }
                    break;

            }//end switch
        } //end if


    }
}
