package oscarblancarte.ipd.state;

import javax.swing.JFrame;
import oscarblancarte.ipd.state.gui.ServerPanel;

public class StateMain {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("State pattern");
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        frame.add(new ServerPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
