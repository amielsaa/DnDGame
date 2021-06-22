package Backend.Tiles;

import Backend.Tile;
import Backend.Tiles.Unit;
import Backend.Utils.Position;

public class Wall extends Tile {

    public Wall(Position position) {
        super('#',position);
    }

    @Override
    public void accept(Unit unit) {

    }
}
