package arasinav.view;

import javax.swing.*;
import java.awt.*;
import arasinav.util.GBC;

public class ControlView extends JPanel {

    private JRadioButton point;
    private JRadioButton line;
    private JButton left;
    private JButton right;
    private JButton up;
    private JButton down;
    private JButton readFromFile;
    private JButton writeToFile;

    public ControlView() {
        setLayout(new GridBagLayout());

        point = new JRadioButton("Point");
        line = new JRadioButton("Line");
        left = new JButton("Left");
        right = new JButton("Right");
        up = new JButton("Up");
        down = new JButton("Down");
        readFromFile = new JButton("Read");
        writeToFile = new JButton("Write");
        var buttonGroup = new ButtonGroup();
        buttonGroup.add(point);
        buttonGroup.add(line);

        add(point, new GBC(0, 0, 2, 1).setAnchor(GBC.WEST));
        add(line, new GBC(0, 1, 2, 1).setAnchor(GBC.WEST).setInsets(0,0,10,0));
        add(up, new GBC(0, 2, 2, 1).setFill(GBC.HORIZONTAL));
        add(left, new GBC(0, 3).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL));
        add(right, new GBC(1, 3).setAnchor(GBC.EAST).setFill(GBC.HORIZONTAL));
        add(down, new GBC(0, 4, 2, 1).setFill(GBC.HORIZONTAL).setInsets(0,0,10,0));
        add(readFromFile, new GBC(0, 5).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL));
        add(writeToFile, new GBC(1, 5).setAnchor(GBC.EAST).setFill(GBC.HORIZONTAL));
    }

    public JRadioButton getPoint() {
        return point;
    }

    public JRadioButton getLine() {
        return line;
    }

    public JButton getLeft() {
        return left;
    }

    public JButton getRight() {
        return right;
    }

    public JButton getUp() {
        return up;
    }

    public JButton getDown() {
        return down;
    }

    public JButton getReadFromFile() {
        return readFromFile;
    }

    public JButton getWriteToFile() {
        return writeToFile;
    }
}
