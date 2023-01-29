package tictactoe;

import java.util.Scanner;

public class Gameplay {
    public void start() {
        Scanner sc = new Scanner(System.in);
        Map map = new Map();
        System.out.print("Enter the cells: ");
        map.setMap(sc.nextLine());
        map.printMap();
        takeCoordinates(sc, map);
    }

    public void takeCoordinates(Scanner sc, Map map) {
        int c1, c2;
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
                        if (isGameEnded(map)) break;
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
            System.out.println("Game not finished");
            return true; //DO ZMIANY JESlI BEDZIE TRZEBA ZAIMPLEMENTOWAC PETLE!!!
        }
    }
}
