package tictactoe;

import java.util.Random;

public class AI {
    public void takeRandomMove(Map map) {
        Random random = new Random();
        while(true) {
            if (map.setField(random.nextInt(3) + 1, random.nextInt(3) + 1)) break;
        }
    }
}
