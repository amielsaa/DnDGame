package Backend.Tiles.Units.Enemies;

import Backend.Tiles.Units.Enemy;

public class Monster extends Enemy {

    int vision;
    public Monster(char tile, String name, int healthCapacity, int attack, int defense,int vision,int exp) {
        super(tile, name, healthCapacity, attack, defense,exp);

        this.vision=vision;
    }
    public void processStep() {


    }
    public void inRange(){
        
    }
}
