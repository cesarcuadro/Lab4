import java.security.SecureRandom;
import java.util.Scanner;

public class GameGrid {
    public int[][] createGameGrid(int size, int chance) {
        int[][] grid = new int[size][size];
        SecureRandom randomNum = new SecureRandom();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (randomNum.nextInt(100) < chance) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        grid[0][0] = 0;
        return grid;
    };

    public void run() {
        int gridSize = 10;
        int wallChance = 30;

        int[][] gameGridArray = createGameGrid(gridSize, wallChance);

        int iUserRow = 0;
        int iUserCol = 0;
        boolean exitGame = false;
        Scanner scanner = new Scanner(System.in);

        while (!exitGame) {
            System.out.println("Press (D) for down. Press (R) for right.");
            char move = scanner.nextLine().toUpperCase().charAt(0);
            if (move == 'D') {
                iUserRow++;
            }

            if (move == 'R') {
                iUserCol++;
            }

            if (gameGridArray[iUserRow][iUserCol] == 1) {
                //tell the user they failed
                System.out.println("You lose!");
                //exit loop
                exitGame = true;
            }

            if (gameGridArray[iUserRow][iUserCol] != 1) {
                if (iUserRow == 9 || iUserCol == 9) {
                    System.out.println("You win!");
                    exitGame = true;
                }
            }
        }

        System.out.println("Here is the final grid:");
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (row == iUserRow && col == iUserCol) {
                    System.out.print("X ");
                } else {
                    System.out.print(gameGridArray[row][col] + " ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }



}
