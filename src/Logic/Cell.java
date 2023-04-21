package Logic;

public class Cell {
    public enum Owner {
        NONE, PLAYER1, PLAYER2
    }
    private final int x;
    private final int y;
    private Owner owner;
    Cell(int pX, int pY) {
        this.x = pX;
        this.y = pY;
        this.owner = Owner.NONE;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
