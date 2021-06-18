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
