package oscarblancarte.ipd.memento;

import oscarblancarte.ipd.memento.gui.EmployeeGUI;

public class MementoMain {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeGUI().setVisible(true);
            }
        });
    }
}
