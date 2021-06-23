package Frontend;

import Backend.Tiles.Units.Player;

import java.util.List;
import java.util.Scanner;

public class PlayerSelectionMenu {

    private GameLevel gameLevel;

    public PlayerSelectionMenu() {
        gameLevel = GameLevel.getInstance();
    }


    public void printMenu(){
        List<Player> playerList = gameLevel.getFileParser().tileFactory.listPlayers();
        for(int i=0;i<playerList.size();i++){
            Player p = playerList.get(i);
            System.out.println(i+". " + p.getName() + " | "+p.getAttack() + " | "+ p.getDefense()+" | " + p.getResource().getHealthCapacity() );
        }
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        gameLevel.setPlayer(playerList.get(Integer.parseInt(input)));

    }

}
