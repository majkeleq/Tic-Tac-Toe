package tictactoe;

import java.util.Scanner;

public class UserPlayer extends Player {


    public UserPlayer(Sign sign) {
        super(sign);
    }

    @Override
    public void move(Map map) {
        Scanner sc = new Scanner(System.in);
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
                    if (map.setField(c1, c2, super.sign.getSign())) {
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
}
