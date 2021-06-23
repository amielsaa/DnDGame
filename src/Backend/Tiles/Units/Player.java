package Backend.Tiles.Units;

import Backend.Callbacks.MessageCallback;
import Backend.Callbacks.PlayerDeathCallback;
import Backend.Tiles.Unit;
import Backend.Utils.Position;
import Frontend.Action;
import Frontend.Input.InputProvider;

public abstract class Player extends Unit implements HeroicUnit {
    public static final char playerTile = '@';
    protected static final int REQ_EXP = 50;
    protected static final int ATTACK_BONUS = 4;
    protected static final int DEFENSE_BONUS = 1;
    protected static final int HEALTH_BONUS = 10;

    protected int level;
    protected int experience;

    protected PlayerDeathCallback deathCallback;
    protected InputProvider inputProvider;

    protected Player(String name, int healthCapacity, int attack, int defense) {
        super(playerTile, name, healthCapacity, attack, defense);
        this.level = 1;
        this.experience = 0;
    }


    public Player initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider){
        super.initialize(position, messageCallback);
        this.deathCallback = deathCallback;
        this.inputProvider = inputProvider;
        return this;
    }

    public void accept(Unit u){
        u.visit(this);
    }

    public void visit(Enemy e){
        messageCallback.send(e.name+" have engaged in battle with "+this.name+"\n");
        int damage =this.defend()-e.attack();
        if(damage>0) {
            this.resource.setCurrentHealth(resource.getCurrentHealth()-damage);
            messageCallback.send(this.name + " have recieved " + damage + " damage " + "\n");
        }
        else
            messageCallback.send(e.name+" have missed the attack against "+this.name+"\n");
        if(!alive()){
            onDeath();
        }
    }
    public void visit(Player p){

    }

    public Action getAction(){
        return inputProvider.getAction();
    }

    // Deals damage to the enemy with ability
    protected void abilityDamage(Enemy e, int abilityDamage) {
		e.acceptAbility(this,abilityDamage);
    }

    // When the player kills an enemy
    protected void onKill(Enemy e){
		e.deathCallback.call();
    }

    // When the player dies
    @Override
    public void onDeath() {
        messageCallback.send("You lost. but you can always try again");
        // Use deathCallback to alert the level manager
        PlayerDeathCallback.call();
    }

    // Backend.Tiles.Units.Player level up
    protected void levelUp( int defAdd, int attackAdd, int hpAdd){
        resource.setHealthCapacity(resource.getHealthCapacity()+gainHealth()+hpAdd);
        resource.setCurrentHealth(resource.getHealthCapacity());
        attack = attack+ gainAttack()+attackAdd;
        defense = defense +gainDefense()+defAdd;
        experience = experience-(levelUpRequirement());
        level = level+1;
    }

    @Override
    public String toString() {
        if(alive())
           return super.toString();
        return  "X";
    }
    public boolean alive(){
        return resource.getCurrentHealth()>0;
    }

    // Health / attack / defense gain when the player levels up - should be overriden by player subclasses and call super.gainHealth() for the base amount, then add the extra value
    protected int gainHealth(){
        return level * HEALTH_BONUS;
    }
    protected int gainAttack(){
        return level * ATTACK_BONUS;
    }
    protected int gainDefense(){
        return level * DEFENSE_BONUS;
    }

    private int levelUpRequirement(){
        return REQ_EXP * level;
    }

    public int getLevel() {
        return level;
    }
    public int getExperience() {
        return experience;
    }
    public void gaindExperience (int exp) {
        experience = experience+exp;
        if(experience>levelUpRequirement())
            this.levelUp();
    }
    public void levelUp()
    {
        System.out.println("not the right one");
    }



    public String describe() {
        return String.format("%s\t\tLevel: %d\t\tExperience: %d/%d", super.describe(), getLevel(), getExperience(), levelUpRequirement());
    }

    public String unitDescribe() {
        return super.describe();
    }

    public void setInputProvider(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }
}