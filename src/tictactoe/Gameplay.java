package tictactoe;

import java.util.Scanner;

public class Gameplay {
    public void start() {
        Scanner sc = new Scanner(System.in);
        Map map = new Map();
        AI playerAI = new AI();
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
                        //map.printMap();
                        if (isGameEnded(map)) break;
                        System.out.println("Making move level \"easy\"");
                        playerAI.takeRandomMove(map);
                        //map.printMap();
                        if (isGameEnded(map)) break;
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

    private boolean isGameEnded(Map map) {
        Sign winningSign = map.isWon();
        if (winningSign != null) {
            System.out.println(winningSign.getSign() + " wins");
            return true;
        } else if (map.isDraw()) {
            System.out.println("Draw");
            return true;
        } else {
            //System.out.println("Game not finished");
            return false;
        }
    }
}
