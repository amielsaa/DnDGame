package Backend.Utils;

public class Position  implements Comparable<Position>{
    private int row ;
    private int col ;

    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }



    public int compareTo(Position other) {
        if (other.row != row)
            return other.row - row;
        return other.col - col;
    }
}
