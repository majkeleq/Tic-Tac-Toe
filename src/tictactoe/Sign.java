package tictactoe;

public abstract class Sign {
    private final char sign;
    private int firstCoord;
    private int secondCoord;

    public Sign(char sign){
        this.sign = sign;
    }
    public Sign(char sign, int firstCoord, int secondCoord) {
        this.sign = sign;
        this.firstCoord = firstCoord;
        this.secondCoord = secondCoord;
    }

    public int getFirstCoord() {
        return firstCoord;
    }

    public int getSecondCoord() {
        return secondCoord;
    }

    public char getSign() {
        return sign;
    }
}
