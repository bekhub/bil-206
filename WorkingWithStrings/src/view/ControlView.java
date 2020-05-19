package view;

import javax.swing.*;
import java.awt.*;
import util.GBC;

public class ControlView extends JPanel {

    private final JButton readFromFile;
    private final JButton enterText;
    private final JButton showTable;
    private final JButton writeToFile;
    private final JButton draw;

    public ControlView() {
        setLayout(new GridBagLayout());

        readFromFile = new JButton("Read from file");
        enterText = new JButton("Enter text");
        showTable = new JButton("Show table");
        draw = new JButton("Show chart");
        writeToFile = new JButton("Write to file");

        add(readFromFile, new GBC(0, 0).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL).setInsets(5));
        add(enterText, new GBC(0, 1).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL).setInsets(5));
        add(showTable, new GBC(0, 2).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL).setInsets(5));
        add(draw, new GBC(0, 3).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL).setInsets(5));
        add(writeToFile, new GBC(0, 4).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL).setInsets(5));
    }

    public JButton getReadFromFile() {
        return readFromFile;
    }

    public JButton getEnterText() {
        return enterText;
    }

    public JButton getShowTable() {
        return showTable;
    }

    public JButton getDraw() {
        return draw;
    }

    public JButton getWriteToFile() {
        return writeToFile;
    }
}