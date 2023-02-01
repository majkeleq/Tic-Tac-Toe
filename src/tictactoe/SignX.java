package tictactoe;

public class SignX extends Sign{

    public SignX() { super('X'); }
    public SignX(int firstCoord, int secondCoord) {
        super('X', firstCoord, secondCoord);
    }
}
