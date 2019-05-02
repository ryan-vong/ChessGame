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
        checkNorthEast(x, y, state);
        checkSouthEast(x, y, state);
        checkSouthWest(x, y, state);
        checkNorthWest(x, y, state);

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

    private boolean isEnemyPawn(Piece stopper){
        if(stopper != null){
            if((getColor() == 0 && stopper.getColor() == 1) ||
                (getColor() == 1 && stopper.getColor() == 0)) {
                attackers.add(stopper);
                return true;
            }
        }
        return false;
    }

    private void checkNorthEast(int x, int y, List<List<Piece>> state){
        Piece stopper = state.get(x - 1).get(y + 1); //the first Piece on NE direction;
        if(isEnemyPawn(stopper)){
            return;
        }
        Pos stopPos = new Pos(-1, -1);

        for(int i = x -1 ; i >= 0; i--){
            for(int j = y + 1; j <= 7; j++){
                stopper = state.get(i).get(j);
                if(stopper != null){
                    stopPos = stopper.getPos();
                    i = -1;
                    break;
                }
            }
        }
        if(stopPos.isValid()){
            addAttacker(stopper, "NE");
        }
    }
    private void checkSouthWest(int x, int y, List<List<Piece>> state){
        Piece stopper = state.get(x - 1).get(y + 1); //the first Piece on NE direction;
        if(isEnemyPawn(stopper)){
            return;
        }
        Pos stopPos = new Pos(-1, -1);
        for(int i = x + 1 ; i <= 7; i++){
            for(int j = y - 1; j >= 0; j--){
                stopper = state.get(i).get(j);
                if(stopper != null){
                    stopPos = stopper.getPos();
                    i = -1;
                    break;
                }
            }
        }
        if(stopPos.isValid()){
            addAttacker(stopper, "SW");
        }
    }//end checkSouthWest

    private void checkSouthEast(int x, int y, List<List<Piece>> state){
        Piece stopper = state.get(x + 1).get(y + 1); //the first Piece on SE direction;
        if(isEnemyPawn(stopper)){
            return;
        }
        Pos stopPos = new Pos(-1, -1);
        for(int i = x + 1 ; i <= 7; i++){
            for(int j = y + 1; j <= 7; j++){
                stopper = state.get(i).get(j);
                if(stopper != null){
                    stopPos = stopper.getPos();
                    i = -1;
                    break;
                }
            }
        }
        if(stopPos.isValid()){
            addAttacker(stopper, "SE");
        }
    }//end checkSouthEast

    private void checkNorthWest(int x, int y, List<List<Piece>> state){
        Piece stopper = state.get(x - 1).get(y -1); //the first Piece on NW direction;
        if(isEnemyPawn(stopper)){
            return;
        }
        Pos stopPos = new Pos(-1, -1);
        for(int i = x - 1 ; i >= 0; i--){
            for(int j = y - 1; j >= 0; j--){
                stopper = state.get(i).get(j);
                if(stopper != null){
                    stopPos = stopper.getPos();
                    i = -1;
                    break;
                }
            }
        }
        if(stopPos.isValid()){
            addAttacker(stopper, "NW");
        }
    }//end checkNorthWest

    /**
     * Check if the stopper piece is potential attacker. If so, add to the attackers list.
     * @param stopper
     * @param direct
     */
    private void addAttacker(Piece stopper, String direct){
//        stopper = row.get(stopCol);
        if(stopper.getColor() != getColor()){ //if stopper is not enemy, then do nothing.
            switch (direct) {
                //on direction of east/west, attackers are enemy queen and rook.
                case "E":
                case "W":
                    if ("QR".indexOf(stopper.toString().charAt(0)) >=0) {
                        attackers.add(stopper);
                    }
                    break;
                //on direction of NW/west, attackers are enemy queen and rook.
                case "NW":
                case "NE":
                case "SW":
                case "SE":
                    if ("QB".indexOf(stopper.toString().charAt(0)) >=0) {
                        attackers.add(stopper);
                    }
                    break;

            }//end switch
        } //end if
    }//addAttacker


}
