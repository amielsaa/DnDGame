package Backend;

import Backend.Tiles.Unit;
import Backend.Utils.Position;

public abstract class Tile implements Comparable<Tile> {
    protected char tile;
    public Position position;

    protected Tile(char tile, Position position){
        this.tile = tile;
        this.position=position;
    }

    public Tile (char tile){
        this.tile = tile;
    }

    public void initialize(Position position){
        this.position = position;
    }

    public char getTile() {
        return tile;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void accept(Unit unit);

    @Override
    public int compareTo(Tile tile) {
        return getPosition().compareTo(tile.getPosition());
    }

    @Override

    public String toString() {
        return String.valueOf(tile);
    }

   public  void SwitchPosition(Tile tile){
        Position p=tile.position;
        tile.setPosition(this.position);
        this.setPosition(p);
    }
}
