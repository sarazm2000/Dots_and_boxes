import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean end = false;
        Scanner scanner = new Scanner(System.in);
        int playerTurn = 0;

        ArrayList boxes = new ArrayList();
        ArrayList<Line> lines = new ArrayList();;

        int width = 3;
        int length = 4;
        int numOfPlayer = 2;

        ArrayList<Player> players = new ArrayList();
        for (int i = 0; i < numOfPlayer; i++) {
            Player player = new Player(i);
            players.add(player);
        }


        PlayGround playGround = new PlayGround(width, length, numOfPlayer);
        HashMap<Player, Integer> countOfPlayerBoxes = new HashMap<>();

        while (!end){

            if (boxes.size() == width * length) {
                end = true;
                int maxBoxes = 0;
                int winnerId = -1;
                for (int i = 0; i < countOfPlayerBoxes.size(); i++) {
                    if (countOfPlayerBoxes.get(i) > maxBoxes);
                    maxBoxes = countOfPlayerBoxes.get(i);
                    winnerId = i;
                }

                for (Player player : players) {
                    if (player.getPlayerId() == winnerId){
                        player.setWin(player.getWin() + 1);
                    }
                }
            }

            System.out.println("enter col1:");
            int col1 = scanner.nextInt();

            System.out.println("enter row1:");
            int row1 = scanner.nextInt();

            System.out.println("enter col2:");
            int col2 = scanner.nextInt();

            System.out.println("enter row2:");
            int row2 = scanner.nextInt();

            Line line = new Line(col1, row1, col2, row2);
            lines.add(line);

            if (checkForBoxes(line, lines)) {
                boxes.add(playerTurn);
            }

            playerTurn = (playerTurn + 1) % numOfPlayer;

        }
    }

    public static boolean checkForBoxes(Line line, ArrayList<Line> lines) {
        if (line.getCol1() == line.getCol2()) {

            Line leftUpperLine = new Line(line.getCol1() - 1,
                    line.getRow1(), line.getCol2(), line.getRow2() - 1);
            Line rightUpperLine = new Line(line.getCol1() + 1,
                    line.getRow1() + 1, line.getCol2(), line.getRow2());
            Line leftPara = new Line(line.getCol1() - 1,
                    line.getRow1(), line.getCol2() - 1, line.getRow2());
            Line rightPara = new Line(line.getCol1() + 1,
                    line.getRow1(), line.getCol2() + 1, line.getRow2());
            Line leftButton = new Line(line.getCol1() - 1,
                    line.getRow1() + 1, line.getCol2(), line.getRow2());
            Line rightButton = new Line(line.getCol1() + 1,
                    line.getRow1() + 1, line.getCol2(), line.getRow2());

            for (Line l : lines) {
                if (lines.contains(leftPara) && lines.contains(leftUpperLine) && lines.contains(leftButton) ||
                        (lines.contains(rightPara) && lines.contains(rightButton) && lines.contains(rightUpperLine))) {
                    return true;
                }

            }
        } else if (line.getRow1() == line.getRow2()) {
            Line leftButton = new Line(line.getCol1() - 1,
                    line.getRow1(), line.getRow2() - 1, line.getCol2());
            Line rightButton = new Line(line.getCol1() + 1,
                    line.getRow1(), line.getRow2() + 1, line.getCol2());

            Line paraButton = new Line(line.getCol1(),
                    line.getRow1() - 1, line.getCol2(), line.getRow2() - 1);

            Line paraUp = new Line(line.getCol1(),
                    line.getRow1() + 1, line.getCol2(), line.getRow2() + 1);

            Line leftButton1 = new Line(line.getCol1(), line.getRow1() - 1, line.getCol1(), line.getRow2());
            Line rightButton1 = new Line(line.getCol2(), line.getRow1(), line.getCol2(), line.getRow1() + 1);


        }
        return false;
    }
}
