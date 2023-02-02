package tictactoe;

import java.util.Scanner;

public class Gameplay {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Input command: ");
            String[] input = sc.nextLine().split(" ");
            if (input.length > 0 && input[0].equals("exit")) {
                break;
            } else if (input.length > 2 && input[0].equals("start")) {
                if ((input[1].equals("user") || input[1].equals("easy") || input[1].equals("medium"))
                        && (input[2].equals("user") || input[2].equals("easy") || input[2].equals("medium"))) {
                    start(input[1], input[2]);
                } else {
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }

    public void start(String player1Type, String player2Type) {
        Map map = new Map();
        Player player1 = returnPlayer(player1Type, new SignX());
        Player player2 = returnPlayer(player2Type, new SignO());
        map.printMap();
        while (true) {
            player1.move(map);
            if (isGameEnded(map)) break;
            player2.move(map);
            if (isGameEnded(map)) break;
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

    private Player returnPlayer(String playerType,Sign sign) {
        if (playerType.equals("user")) return new UserPlayer(sign);
        if (playerType.equals("easy")) return new EasyPlayer(sign);
        if (playerType.equals("medium")) return new MediumPlayer(sign);
        return null;
    }
}
