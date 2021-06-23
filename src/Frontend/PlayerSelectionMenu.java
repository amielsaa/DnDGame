package Frontend;

import Backend.Tiles.Units.Player;

import java.util.List;
import java.util.Scanner;

public class PlayerSelectionMenu {

    private TileFactory tileFactory;

    public PlayerSelectionMenu() {
        tileFactory = new TileFactory();
    }


    public void printMenu(){
        List<Player> playerList = tileFactory.listPlayers();
        for(int i=0;i<playerList.size();i++){
            Player p = playerList.get(i);
            System.out.println(i+". "+p.unitDescribe());
        }
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        GameLevel.getInstance().setPlayer(playerList.get(Integer.parseInt(input)));

    }

}
