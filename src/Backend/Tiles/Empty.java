package Backend.Tiles;

import Backend.Callbacks.MovementCallback;
import Backend.Tile;
import Backend.Tiles.Unit;
import Backend.Utils.Position;

public class Empty extends Tile {

    public Empty(Position position) {
        super('.',position);
    }

    @Override
    public void accept(Unit unit) {
        Position t=unit.getPosition();
        unit.setPosition(this.position);
        setPosition(t);
    }

}
