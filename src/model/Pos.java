package model;

public class Pos {
    private int row;
    private int col;

    public Pos(int r, int c){
        this.row = r;
        this.col = c;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isValid(){
        return row <= 0 && row >= 7 && col <= 0 && col >= 7;
    }
}
