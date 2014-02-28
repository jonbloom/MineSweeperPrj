package package1;

import java.util.Random;

/**
 * Created by jon on 1/27/14.
 */
public class MineSweeperGame {
    //instance variables
    private Cell[][] board;
    private GameStatus status;
    private int size = 10;
    private int totalMineCount = 10;
    private int flaggedMineCount = 0;

    /**
     * constructor for MineSweeperGame
     * @param pSize width of a side
     * @param pMines number of mines
     */
    public MineSweeperGame(int pSize, int pMines) {
        size = pSize;
        totalMineCount = pMines;
        status = GameStatus.NOT_OVER_YET;
        board = new Cell[size][size];
        for (int row = 0; row < size; row++)
            for (int col = 0; col < size; col++)
                board[row][col] = new Cell();
        Random random = new Random();
        int mineCount = 0;
        while (mineCount < totalMineCount) {
            int col = random.nextInt(size);
            int row = random.nextInt(size);

            if (!board[row][col].isMine()) {
                board[row][col].setMine(true);
                mineCount++;
            }
        }
        for (int row = 0; row < size; row++)
            for (int col = 0; col < size; col++)
                board[row][col].setMineCount(getAdjacentMintCount(row, col));
    }

    /**
     * selects the cell
     * @param row row to select
     * @param col col to select
     */
    public void select(int row, int col) {
        if (board[row][col].isExposed()) {
            return;
        }
        if (board[row][col].isMine()) {
            status = GameStatus.LOST;
            return;
        }
        if (!board[row][col].isFlagged()) {
            board[row][col].setExposed(true);
            //recursive selection for surrounding empty cells
            if (board[row][col].getMineCount() == 0) {
                try {
                    if (!board[row][col - 1].isMine()) select(row, col - 1);
               } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (!board[row - 1][col].isMine()) select(row - 1, col);
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (!board[row + 1][col].isMine()) select(row + 1, col);
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (!board[row][col + 1].isMine()) select(row, col + 1);
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
    }

    /**
     * set cell as flagged if user thinks it's a mine
     * @param row row to flag
     * @param col col to flag
     */
    public void flag(int row, int col) {
        if (board[row][col].isFlagged()) {
            board[row][col].setFlagged(false);
            if (board[row][col].isMine()) {
                flaggedMineCount--;
            }
            return;
        }
        if (board[row][col].isExposed()) {
            return;
        }

        board[row][col].setFlagged(true);
        if (board[row][col].isMine()) {
            flaggedMineCount++;
        }
        //this is how you win
        if (flaggedMineCount == totalMineCount) {
            status = GameStatus.WON;
        }
    }

    /**
     * gets the game status
     * @return game status
     */
    public GameStatus getGameStatus() {
        return status;
    }

    /**
     * returns the cell requested
     * @param row row to return
     * @param col col to return
     * @return Cell requested
     */
    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    /**
     *
     * @param r row to query
     * @param c col to query
     * @return adjacent mine count
     */
    private int getAdjacentMintCount(int r, int c) {
        //ArrayIndexOutOfBounds exceptions are just ignored to handle edge cells
        int count = 0;
        try {
            if (board[r][c - 1].isMine()) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if (board[r - 1][c].isMine()) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if (board[r - 1][c - 1].isMine()) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if (board[r + 1][c + 1].isMine()) {
                count++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if (board[r + 1][c - 1].isMine()) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if (board[r - 1][c + 1].isMine()) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if (board[r + 1][c].isMine()) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if (board[r][c + 1].isMine()) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return count;
    }
}


