public class Mage extends Player {

    protected Mage(String name, int healthCapacity, int attack, int defense) {
        super(name, healthCapacity, attack, defense);
    }

    @Override
    public void CastAbility() {
    messageCallback.send(this.name+"have used Blizzard");
    }
    @Override
    public void processStep() {

    }


}
