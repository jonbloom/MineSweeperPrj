package package1;

import javax.swing.*;

/**
 * Created by jon on 1/27/14.
 */
public class MineSweeper {
    /**
     * create new panel, display it
     * @param args
     */
    public static void main(String args[]) {
        JFrame frame = new JFrame("MineSweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MineSweeperPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
