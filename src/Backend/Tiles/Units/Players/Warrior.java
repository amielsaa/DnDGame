package Backend.Tiles.Units.Players;

import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;

public class Warrior extends Player {


    public Warrior(String name, int healthCapacity, int attack, int defense) {
        super(name, healthCapacity, attack, defense);

    }

    @Override
    public void CastAbility(Enemy e) {
      messageCallback.send(this.name+" have have used Avengers Shield"+"\n");



    }

    @Override
    public void processStep() {


    }
}
