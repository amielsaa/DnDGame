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
        String s="|------------------------------------------------------------------------------------------------------------|";
        List<Player> playerList = tileFactory.listPlayers();
        System.out.println("|------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                           Select Your Character                                            |");
        System.out.println("|------------------------------------------------------------------------------------------------------------|");
        for(int i=0;i<playerList.size();i++) {
            if (i == 0)
                System.out.println("|------------------------------------------------Warriors----------------------------------------------------|");
            if (i == 2)
                System.out.println("|-------------------------------------------------Mages------------------------------------------------------|");
            if (i == 4)
                System.out.println("|----------------------------------------- ------Rouges------------------------------------------------------|");

            Player p = playerList.get(i);
            String toprint = "| " + i + ". " + p.describe();
            System.out.print(toprint);
            if (toprint.length() < s.length()) {
                while (toprint.length()<86) {
                    System.out.print(" ");
                    toprint = toprint + " ";
                }
                if(i==0)
                    System.out.println(" |");
                else if(i==4)
                    System.out.println("   |");
                else
                    System.out.println("  |");


            }
        }
        System.out.println("|------------------------------------------------------------------------------------------------------------|");
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        GameLevel.getInstance().setPlayer(playerList.get(Integer.parseInt(input)));

    }

    public static void main(String[] args) {
        PlayerSelectionMenu k=new PlayerSelectionMenu();
        k.printMenu();
    }

}
