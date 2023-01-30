package tictactoe;

import java.util.Scanner;

public class Gameplay {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Input command: ");
            String[] input = sc.nextLine().split(" ");
            if (input.length > 0 && input[0].equals("exit")) {
                break;
            } else if (input.length > 2 && input[0].equals("start")) {
                if((input[1].equals("user") || input[1].equals("easy"))
                && (input[2].equals("user") || input[2].equals("easy"))) {
                    start(sc, input[1], input[2]);
                } else {
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }
    public void start(Scanner sc, String player1, String player2) {
        Map map = new Map();
        Move move = new Move();
        while(true) {
            if (player1.equals("user")) move.userMove(sc, map);
            else move.computerRandomMove(map);
            if (isGameEnded(map)) break;
            if (player2.equals("user")) move.userMove(sc, map);
            else move.computerRandomMove(map);
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
}
