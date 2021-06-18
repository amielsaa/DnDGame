public class Enemy extends Unit {
    int exp;
    protected Enemy(char tile, String name, int healthCapacity, int attack, int defense,int exp) {
        super(tile, name, healthCapacity, attack, defense);
        this.exp=exp;
    }


    @Override
    public void processStep() {


    }

    @Override
    public void onDeath() {
        messageCallback.send("enemy"+this.name+"has been defeated");
        deathCallback.call();

    }

    @Override
    public void visit(Player p) {
    messageCallback.send(p.name+" have engaged in battle with "+this.name+ "\n");

        int damage =this.resource.getCurrentHealth()-attack()+defend();
        this.resource.setCurrentHealth(damage);
        messageCallback.send(this.name+" have recieved "+damage+" damage "+"\n");

    }

    @Override
    public void visit(Enemy e) {

    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }

    public void acceptAbility(int abilityDamage){

    }

}
