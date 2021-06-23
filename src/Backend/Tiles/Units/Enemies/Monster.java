package Backend.Tiles.Units.Enemies;

import Backend.Tile;
import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Utils.NumericGenerator;
import Backend.Utils.Position;
import Frontend.GameBoard;
import Frontend.GameLevel;

public class Monster extends Enemy {

    int vision;
    public Monster(char tile, String name, int healthCapacity, int attack, int defense,int vision,int exp) {
        super(tile, name, healthCapacity, attack, defense,exp);

        this.vision=vision;
    }
    public void processStep(Player p) {
        if(p.position.checkDistance(this.position)<vision) {
            inRange(p);
        }
        else{
            GameBoard gameBoard = GameLevel.getInstance().getBoard();
            switch ((int)(NumericGenerator.getInstance().nextDouble()*5)){
                case 1:
                    interact(this.position.getCol()-1,this.position.getRow(),gameBoard);
                case 2:
                    interact(this.position.getCol()+1,this.position.getRow(),gameBoard);
                case 3:
                    interact(this.position.getCol(),this.position.getRow()-1,gameBoard);
                case 4:
                    interact(this.position.getCol(),this.position.getRow()+1,gameBoard);
                default:
                    doNothing();
            }
        }

    }
    public void inRange(Player p ){
        int yDistance = this.position.getRow() - p.position.getRow();
        int xDistance = this.position.getCol() - p.position.getCol();
        GameBoard gameBoard = GameLevel.getInstance().getBoard();
        if(Math.abs(xDistance)>Math.abs(yDistance))
        {
            if(xDistance>0)
            { interact(this.position.getCol()-1,this.position.getRow(),gameBoard); }
            else
            { interact(this.position.getCol()+1,this.position.getRow(),gameBoard);}
        }
        else
        {
            if(yDistance>0)
            { interact(this.position.getCol(),this.position.getRow()+1,gameBoard); }
            else
            { interact(this.position.getCol(),this.position.getRow()-1,gameBoard);}
        }
    }
    private void interact(int colIndex, int rowIndex, GameBoard gameBoard){
        Tile tile = gameBoard.findTile(new Position(rowIndex,colIndex));
        tile.accept(this);
    }
    public void doNothing (){}
}
