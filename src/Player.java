public class Player {
    private int playerId;
    private int win;

    public Player(int playerId) {
        this.playerId = playerId;
        this.win = 0;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }
}
