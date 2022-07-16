public class PlayGround {
    private int width;
    private int length;
    private int numOfPlayer;

    public PlayGround(int width, int length, int numOfPlayer) {
        this.width = width;
        this.length = length;
        this.numOfPlayer = numOfPlayer;
    }

    public PlayGround() {

    }

    public int getNumOfPlayer() {
        return numOfPlayer;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
}
