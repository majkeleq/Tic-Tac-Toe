package tictactoe;

public class Map {
    private final Sign[][] map = new Sign[3][3];

    public int getLength() {
        return map.length;
    }

    public Sign getField(int i, int j) {
        return map[i][j];
    }
    public Sign[] getRow(int i) {
        return map[i];
    }

    public Sign[] getColumn(int j) {
        Sign[] column = new Sign[3];
        for (int i = 0; i < map.length; i++) {
            column[i] = map[i][j];
        }
        return column;
    }

    @Deprecated
    public void setMap(String chars) {
        for (int i = 0; i < 9; i++) {
            if (chars.charAt(i) == 'X') {
                map[i / 3][i % 3] = new SignX(i / 3, i % 3);
            } else if (chars.charAt(i) == 'O') {
                map[i / 3][i % 3] = new SignO(i / 3, i % 3);
            }
        }
    }

    public void emptyField(int firstCoord, int secondCoord) {
        map[firstCoord][secondCoord] = null;
    }

    public boolean setField(int firstCoord, int secondCoord, char sign) {
        if (!isFieldOccupied(firstCoord, secondCoord)) {
            if (sign == 'X') {
                map[firstCoord][secondCoord] = new SignX(firstCoord, secondCoord);
            } else {
                map[firstCoord][secondCoord] = new SignO(firstCoord, secondCoord);
            }
            //printMap();
            return true;
        } else {
            //System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
    }

    public void printMap() {
        System.out.println("---------");
        for (int i = 0; i < map.length; i++) {
            System.out.print("|");
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.printf(" %c", map[i][j].getSign());
                }
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    public boolean isFieldOccupied(int firstCoord, int secondCoord) {
        return map[firstCoord][secondCoord] != null;
    }

    //if there are less X or equal then true. If there are less O then false
    @Deprecated
    public boolean signXStarts() {
        int counterX = 0, counterY = 0;
        for (int i = 0; i < 9; i++) {
            if (map[i / 3][i % 3] != null) {
                if (map[i / 3][i % 3].getSign() == 'X') {
                    counterX += 1;
                } else if (map[i / 3][i % 3].getSign() == 'O') {
                    counterY += 1;
                }
            }
        }
        return counterX <= counterY;
    }

    public Sign isWon() {
        if (map[0][0] != null && map[0][1] != null && map[0][2] != null
                && map[0][0].getSign() == map[0][1].getSign() && map[0][0].getSign() == map[0][2].getSign()) {
            return map[0][0];
        }
        if (map[1][0] != null && map[1][1] != null && map[1][2] != null
        && map[1][0].getSign() == map[1][1].getSign() && map[1][0].getSign() == map[1][2].getSign()) {
            return map[1][0];
        }
        if (map[2][0] != null && map[2][1] != null && map[2][2] != null
        && map[2][0].getSign() == map[2][1].getSign() && map[2][0].getSign() == map[2][2].getSign()) {
            return map[2][0];
        }
        if (map[0][0] != null && map[1][0] != null && map[2][0] != null
        && map[0][0].getSign() == map[1][0].getSign() && map[0][0].getSign() == map[2][0].getSign()) {
            return map[0][0];
        }
        if (map[0][1] != null && map[1][1] != null && map[2][1] != null
        && map[0][1].getSign() == map[1][1].getSign() && map[0][1].getSign() == map[2][1].getSign()) {
            return map[0][1];
        }
        if (map[0][2] != null && map[1][2] != null && map[2][2] != null
        && map[0][2].getSign() == map[1][2].getSign() && map[0][2].getSign() == map[2][2].getSign()) {
            return map[0][2];
        }
        if (map[0][0] != null && map[1][1] != null && map[2][2] != null
                && map[0][0].getSign() == map[1][1].getSign() && map[1][1].getSign() == map[2][2].getSign()) {
            return map[1][1];
        }
        if (map[2][0] != null && map[1][1] != null && map[0][2] != null
                && map[2][0].getSign() == map[1][1].getSign() && map[1][1].getSign() == map[0][2].getSign()) {
            return map[1][1];
        }
        return null;
    }

    public boolean isDraw() {
        for (int i = 0; i < 9; i++) {
            if (map[i / 3][i % 3] == null) return false;
        }
        return true;
    }
}
