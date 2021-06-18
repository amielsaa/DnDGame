public abstract class Unit extends Tile {
    // A singleton object for generating numbers - NumericGenerator is an interface, implemented by a RandomGenerator and a DeterministicGenerator
    protected static final NumericGenerator r = NumericGenerator.getInstance();
    protected MessageCallback messageCallback;
    protected DeathCallback deathCallback;
    protected String name;
    protected Resource resource;
    protected int attack;
    protected int defense;

    public String getName() {
        return name;
    }

    public Resource getResource() {
        return resource;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    protected Unit(char tile, String name, int healthCapacity, int attack, int defense) {
        super(tile);
        this.name = name;
        this.resource = new Resource(healthCapacity, healthCapacity);
        this.attack = attack;
        this.defense = defense;
    }

    protected void initialize(Position position, MessageCallback messageCallback){
        super.initialize(position);
        this.messageCallback = messageCallback;
    }

    protected int attack(){
       return  (int)Math.round(attack*r.nextDouble());
    }

    public int defend(){
        return (int)Math.round(defense*r.nextDouble());
    }

    // Should be automatically called once the unit finishes its turn
    public abstract void processStep();


    // What happens when the unit dies
    public abstract void onDeath();

    public void interact(Tile tile){

        tile.accept(this);
    }

    public void visit(Empty e){
		this.SwitchPosition(e);
		System.out.print("player has marched succesfully");//for check

    }

    public abstract void visit(Player p);
    public abstract void visit(Enemy e);

    protected void battle(Unit u){
        messageCallback.send(this.getName()+"engaged in battle with "+u.getName());
    }


    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getResource().getCurrentHealth(), getAttack(), getDefense());
    }
    public void setDeathCallback(DeathCallback d){
        this.deathCallback=d;
    }

    public void setMessageCallback(MessageCallback m) {
        this.messageCallback =m;
    }
}
