package Frontend;

import Backend.Tile;
import Backend.Tiles.Empty;
import Backend.Tiles.Units.Enemies.Monster;
import Backend.Tiles.Units.Enemy;
import Backend.Tiles.Units.Player;
import Backend.Tiles.Units.Players.Warrior;
import Backend.Utils.Position;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.stream.Collectors;


public class GameLevel {

    private GameBoard gameBoard;
    private Player player;
    public List<Enemy> enemies;
    public static FileParser fileParser;

    private static GameLevel instance;


    private GameLevel() {
        fileParser = new FileParser();
        enemies = new ArrayList<>();
    }

    public static GameLevel getInstance() {
        if(instance == null) {
            instance = new GameLevel();
        }
        return instance;
    }
    public FileParser getFileParser(){
        return fileParser;
    }

    public void tick(String action){
        cheatShit(action);
        Position nextPosition = getInteractPosition(action);
        if(action.length()==1 && nextPosition!=null){
            player.setInputProvider(()-> action.charAt(0));

            //cast ability
            if(nextPosition.getCol()==0&nextPosition.getRow()==0){
                player.CastAbility(enemies);
            }
            else{ //moving
                Tile tileToInteract = gameBoard.findTile( new Position(player.getPosition().getRow()+nextPosition.getRow(),player.getPosition().getCol()+nextPosition.getCol()) );
                player.interact(tileToInteract);
                if(tileToInteract.isEmpty()){
                    gameBoard.SwitchPositions(tileToInteract,player);
                }
            }
            player.updateResources();
            enemyProcessStep();
            System.out.println(player.tickDescribe());
            gameBoard.Printall();
        }

    }

    private void cheatShit(String cheat) {
        //for gay pride month
        if(cheat.equals("GAYPOWER")) {
            player.setAttack(player.getAttack()+500);
            player.setDefense(player.getDefense()+500);
            player.setHealth(player.getResource().getHealthCapacity()+1000);
            player.heal(player.getResource().getCurrentHealth()+1000);
        }

    }

    public void onMovementCall(Position pos1,Position pos2) {
        gameBoard.SwitchPositions(gameBoard.findTile(pos1),gameBoard.findTile(pos2));
    }

    public void onVisibilityCall(char enemy,Enemy e) {
        e.setTile(enemy);
    }

    private void enemyProcessStep() {
        for(int i =0;i<enemies.size();i++) {
            enemies.get(i).processStep(player);
        }

    }


    public void onPlayerDeath(){

    }



    public void onEnemyDeath(Enemy e){
        Tile toRemove = gameBoard.findTile(e.getPosition());
        int index = gameBoard.getIndex(e);
        Position dotPos = new Position(toRemove.getPosition().getRow(),toRemove.getPosition().getCol());
        Tile dot = new Empty(dotPos);
        enemies.remove(e);
        gameBoard.remove(toRemove);
        gameBoard.add(dot,index);
    }

    public Player getPlayer(){
        return player;
    }
    public GameBoard getBoard() {
        return gameBoard;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Position getInteractPosition(String action) {
        switch (action.toLowerCase().charAt(0)) {
            case 'a':
                return new Position(0,-1);
            case 'd':
                return new Position(0,1);
            case 's':
                return new Position(1,0);
            case 'w':
                return new Position(-1,0);
            case 'e':
                return new Position(0,0);
            default:
                return null;
        }
    }
    public void loadLevel(File level) {


        gameBoard = fileParser.parseLevel(level, player);
        gameBoard.Printall();




    }

    @Override
    public String toString() {
        return String.format("%s\n%s", gameBoard, player.describe());
    }


}
