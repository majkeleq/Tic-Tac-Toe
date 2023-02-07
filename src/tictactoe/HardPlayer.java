package tictactoe;

public class HardPlayer extends Player{

    public HardPlayer(Sign sign) {
        super(sign);
    }

    @Override
    public void move(Map map) {
        System.out.println("Making move level \"hard\"");
        minimax(map, this.sign.getSign(), 1);
    }

    public int minimax(Map map, char sign, int depth) {
        //if map is won
        if (map.isWon() != null) {
            //if AI won
            if (map.isWon().getSign() == this.sign.getSign()) {
                return 10;
            } else { //else Opponent WON
                return -10;
            }
        } else if (map.isDraw()) { //Draw
            return 0;
        }
        //MAX
        //AI move - we are selecting first move which result is 10. if there is no score 10 moves then goes for draw
        int bestI = 0;
        int bestJ = 0;
        int bestValue;
        int result;
        if (this.sign.getSign() == sign) {
            bestValue = -100;
            for (int i = 0; i < map.getLength(); i++) {
                for (int j = 0; j < map.getLength(); j++) {
                    if (!map.isFieldOccupied(i, j)) {
                        map.setField(i, j, sign);
                        if (sign == 'X') {
                            result = minimax(map, 'O', depth + 1);
                        } else {
                            result = minimax(map, 'X', depth + 1);
                        }
                        map.emptyField(i, j);
                        if (result > bestValue) {
                            bestValue = result;
                            bestI = i;
                            bestJ = j;
                        }
                    }
                }
            }
        }
        //MIN
        //opponent move. looking for first result = -10
        // (this.sign.getSign() == sign)
        else {
            bestValue = 100;
            for (int i = 0; i < map.getLength(); i++) {
                for (int j = 0; j < map.getLength(); j++) {
                    if (!map.isFieldOccupied(i, j)) {
                        map.setField(i, j, sign);
                        if (sign == 'X') {
                            result = minimax(map, 'O', depth + 1);
                        } else {
                            result = minimax(map, 'X', depth + 1);
                        }
                        map.emptyField(i, j);
                        if (result < bestValue) {
                            bestValue = result;
                            bestI = i;
                            bestJ = j;
                        }
                    }
                }
            }
        }
        //making first best move
        if (depth == 1) {
            map.setField(bestI, bestJ, sign);
        }
        return bestValue;
    }
}
