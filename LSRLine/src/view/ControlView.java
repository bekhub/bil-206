package view;

import javax.swing.*;
import java.awt.*;
import util.GBC;

public class ControlView extends JPanel {

    private final JButton readFromFile;
    private final JButton draw;
    private final JLabel equation;
    private final JLabel r2;

    public ControlView() {
        setLayout(new GridBagLayout());

        readFromFile = new JButton("Read from file");
        draw = new JButton("Draw line");
        equation = new JLabel("y = kx + b");
        r2 = new JLabel("r2 = ?");

        add(readFromFile, new GBC(0, 0).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL).setInsets(5));
        add(draw, new GBC(0, 1).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL).setInsets(5));
        add(equation, new GBC(0, 2).setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5));
        add(r2, new GBC(0, 3).setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL));
    }

    public JButton getReadFromFile() {
        return readFromFile;
    }

    public JButton getDraw() {
        return draw;
    }

    public JLabel getEquation() {
        return equation;
    }

    public JLabel getR2() {
        return r2;
    }
}
