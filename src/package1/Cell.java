package package1;

/**
 * Created by jon on 1/27/14.
 */
public class Cell {

    //instance variables
    private int mineCount;
    private boolean isFlagged;
    private boolean isExposed;
    private boolean isMine;

    /**
     * Constructor for cell
     */
    public Cell() {
        this.mineCount = 0;
        this.isFlagged = false;
        this.isExposed = false;
        this.isMine = false;
    }

    /**
     * getter for mineCount
     * @return the count of adjacent mines
     */
    public int getMineCount() {
        return mineCount;
    }

    /**
     * setter for mine count
     * @param mineCount adjacent mines
     */
    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    /**
     * getter for isFlagged
     * @return isFlagged
     */
    public boolean isFlagged() {
        return isFlagged;
    }

    /**
     * setter for isFlagged
     * @param isFlagged is it flagged?
     */
    public void setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    /**
     * getter for isExposed
     * @return isExposed
     */
    public boolean isExposed() {
        return isExposed;
    }

    /**
     * setter for isExposed
     * @param isExposed is it exposed?
     */
    public void setExposed(boolean isExposed) {
        this.isExposed = isExposed;
    }

    /**
     * getter for isMine
     * @return isMine
     */
    public boolean isMine() {
        return isMine;
    }

    /**
     * setter for isMine
     * @param isMine is it a mine?
     */
    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }
}