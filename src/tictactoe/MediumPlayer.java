package tictactoe;

import java.util.Random;

public class MediumPlayer extends Player{
    public MediumPlayer(Sign sign) {
        super(sign);
    }

    @Override
    public void move(Map map) {

        Random random = new Random();
        System.out.println("Making move level \"medium\"");
        if (!searchRows(map)) {
            while (true) {
                if (map.setField(random.nextInt(3), random.nextInt(3), super.sign.getSign())) break;
            }
        }
    }
    public boolean searchRows(Map map){
        int nullCounter, mySignCounter, enemySignCounter;
        int nullJ = 0;
        Sign temp[];
        for (int i = 0; i < map.getLength(); i++){
            nullCounter = 0;
            mySignCounter = 0;
            enemySignCounter = 0;
            temp = map.getRow(i);
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == null) {
                    nullCounter += 1;
                    nullJ = j;
                }
                else if (temp[j].getSign() == sign.getSign()) mySignCounter += 1;
                else enemySignCounter += 1;
            }
            if (mySignCounter == 2 && nullCounter == 1) {
                map.setField(i, nullJ, sign.getSign());
                return true;
            }
            if (enemySignCounter == 2 && nullCounter == 1) {
                map.setField(i, nullJ, sign.getSign());
                return true;
            }
        }
        return false;
    }
}
