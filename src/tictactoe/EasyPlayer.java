package tictactoe;

import java.util.Random;

public class EasyPlayer extends Player {

    public EasyPlayer(Sign sign) {
        super(sign);
    }

    @Override
    public void move(Map map) {
        Random random = new Random();
        System.out.println("Making move level \"easy\"");
        while(true) {
            if (map.setField(random.nextInt(3), random.nextInt(3), super.sign.getSign())) break;
        }
    }
}
