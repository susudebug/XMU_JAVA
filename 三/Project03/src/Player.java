public class Player extends Person{
    boolean isBlack;
    Player() {
        isBlack = false;
    }
    Player(String name, boolean isBlack) {
        super(name);
        this.isBlack = isBlack;
    }
    public int makeDrop(Board b, int x, int y) {
        return b.drop(this.isBlack, x, y);
    }
}
