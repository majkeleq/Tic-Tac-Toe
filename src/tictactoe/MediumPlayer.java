package tictactoe;

import java.util.Random;

public class MediumPlayer extends Player {
    public MediumPlayer(Sign sign) {
        super(sign);
    }

    @Override
    public void move(Map map) {

        Random random = new Random();
        System.out.println("Making move level \"medium\"");
        if (!searchWinningMove(map)) {
            if (!searchBlockingMove(map)) {
                while (true) {
                    if (map.setField(random.nextInt(3), random.nextInt(3), super.sign.getSign())) break;
                }
            }
        }
    }

    public boolean searchWinningMove(Map map) {
        if (searchWinningRows(map)) return true;
        if (searchWinningColumns(map)) return true;
        if (searchWinningDiagonals(map)) return true;
        return false;
    }

    public boolean searchBlockingMove(Map map) {
        if (searchBlockingRows(map)) return true;
        if (searchBlockingColumns(map)) return true;
        if (searchBlockingDiagonals(map)) return true;
        return false;
    }

    public boolean searchWinningRows(Map map) {
        int nullCounter, mySignCounter;
        int nullJ = 0;
        Sign[] temp;
        for (int i = 0; i < map.getLength(); i++) {
            nullCounter = 0;
            mySignCounter = 0;
            temp = map.getRow(i);
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == null) {
                    nullCounter += 1;
                    nullJ = j;
                } else if (temp[j].getSign() == sign.getSign()) mySignCounter += 1;
            }
            if (mySignCounter == 2 && nullCounter == 1) {
                map.setField(i, nullJ, sign.getSign());
                return true;
            }
        }
        return false;
    }

    public boolean searchBlockingRows(Map map) {
        int nullCounter, mySignCounter, enemySignCounter;
        int nullJ = 0;
        Sign[] temp;
        for (int i = 0; i < map.getLength(); i++) {
            nullCounter = 0;
            enemySignCounter = 0;
            temp = map.getRow(i);
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == null) {
                    nullCounter += 1;
                    nullJ = j;
                } else if (temp[j].getSign() != sign.getSign()) enemySignCounter += 1;
            }
            if (enemySignCounter == 2 && nullCounter == 1) {
                map.setField(i, nullJ, sign.getSign());
                return true;
            }
        }
        return false;
    }

    public boolean searchWinningColumns(Map map) {
        int nullCounter, mySignCounter;
        int nullI = 0;
        Sign[] temp;
        for (int j = 0; j < map.getLength(); j++) {
            nullCounter = 0;
            mySignCounter = 0;
            temp = map.getColumn(j);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == null) {
                    nullCounter += 1;
                    nullI = i;
                } else if (temp[i].getSign() == sign.getSign()) mySignCounter += 1;
            }
            if (mySignCounter == 2 && nullCounter == 1) {
                map.setField(nullI, j, sign.getSign());
                return true;
            }
        }
        return false;
    }

    public boolean searchBlockingColumns(Map map) {
        int nullCounter, enemySignCounter;
        int nullI = 0;
        Sign[] temp;
        for (int j = 0; j < map.getLength(); j++) {
            nullCounter = 0;
            enemySignCounter = 0;
            temp = map.getColumn(j);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == null) {
                    nullCounter += 1;
                    nullI = i;
                } else if (temp[i].getSign() != sign.getSign()) enemySignCounter += 1;
            }
            if (enemySignCounter == 2 && nullCounter == 1) {
                map.setField(nullI, j, sign.getSign());
                return true;
            }
        }
        return false;
    }

    public boolean searchWinningDiagonals(Map map) {
        int nullCounter, mySignCounter;
        int nullField = 0;
        nullCounter = 0;
        mySignCounter = 0;
        for (int i = 0; i < map.getLength(); i++) {
            if (map.getField(i, i) == null) {
                nullCounter += 1;
                nullField = i;
            } else if (map.getField(i, i).getSign() == sign.getSign()) mySignCounter += 1;
        }
        if (mySignCounter == 2 && nullCounter == 1) {
            map.setField(nullField, nullField, sign.getSign());
            return true;
        }
        nullCounter = 0;
        mySignCounter = 0;
        for (int i = 0; i < map.getLength(); i++) {
            if (map.getField(i, map.getLength() - 1 - i) == null) {
                nullCounter += 1;
                nullField = i;
            } else if (map.getField(i, map.getLength() - 1 - i).getSign() == sign.getSign()) mySignCounter += 1;
        }
        if (mySignCounter == 2 && nullCounter == 1) {
            map.setField(nullField,map.getLength() - 1 - nullField, sign.getSign());
            return true;
        }
        return false;
    }

    public boolean searchBlockingDiagonals(Map map) {
        int nullCounter, enemySignCounter;
        int nullField = 0;
        nullCounter = 0;
        enemySignCounter = 0;
        for (int i = 0; i < map.getLength(); i++) {
            if (map.getField(i, i) == null) {
                nullCounter += 1;
                nullField = i;
            } else if (map.getField(i, i).getSign() != sign.getSign()) enemySignCounter += 1;
        }
        if (enemySignCounter == 2 && nullCounter == 1) {
            map.setField(nullField, nullField, sign.getSign());
            return true;
        }
        nullCounter = 0;
        enemySignCounter = 0;
        for (int i = 0; i < map.getLength(); i++) {
            if (map.getField(i, map.getLength() - 1 - i) == null) {
                nullCounter += 1;
                nullField = i;
            } else if (map.getField(i, map.getLength() - 1 - i).getSign() != sign.getSign()) enemySignCounter += 1;
        }
        if (enemySignCounter == 2 && nullCounter == 1) {
            map.setField(nullField, map.getLength() - 1 - nullField, sign.getSign());
            return true;
        }
        return false;
    }
}
