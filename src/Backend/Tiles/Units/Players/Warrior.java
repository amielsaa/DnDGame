package Backend.Tiles.Units.Players;

import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Utils.WarriorResource;

import java.util.List;

public class Warrior extends Player {

    public WarriorResource warriorResource;
    public Warrior(String name, int healthCapacity, int attack, int defense, int cooldown) {
        super(name, healthCapacity, attack, defense);
        warriorResource = new WarriorResource(healthCapacity,healthCapacity,cooldown);

    }

    @Override
    public void CastAbility(List<Enemy> e) {
      messageCallback.send(this.name+" have have used Avengers Shield"+"\n");



    }

    @Override
    public void processStep() {


    }
}
