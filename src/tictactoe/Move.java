package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Move {
    public void userMove(Scanner sc, Map map) {
        int c1, c2;
        map.printMap();
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                c1 = sc.nextInt();
                c2 = sc.nextInt();
                sc.nextLine();
                if (c1 > 3 || c2 > 3 || c1 < 1 || c2 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (map.setField(c1, c2)) {
                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                sc.nextLine();
            }
        }
    }
    public void computerRandomMove(Map map) {
        Random random = new Random();
        System.out.println("Making move level \"easy\"");
        while(true) {
            if (map.setField(random.nextInt(3) + 1, random.nextInt(3) + 1)) break;
        }
    }
}
