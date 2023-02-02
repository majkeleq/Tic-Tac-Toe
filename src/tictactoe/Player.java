package tictactoe;

public abstract class Player {
    Sign sign;

    public Player(Sign sign) {
        this.sign = sign;
    }

    public abstract void move(Map map);
}
