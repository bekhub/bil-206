package mvc.views;

import mvc.utils.GBC;

import javax.swing.*;
import java.awt.*;

public class ThirdView extends JPanel {

    private final JButton buttonDraw;
    private final JButton buttonFile;
    private final JButton buttonReset;

    public ThirdView() {
        setLayout(new GridBagLayout());

        buttonDraw = new JButton("Draw");
        buttonReset = new JButton("Reset");
        buttonFile = new JButton("Open file");

        add(buttonFile, new GBC(0, 0, 2, 1).setFill(GBC.HORIZONTAL));
        add(buttonDraw, new GBC(0, 1).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL));
        add(buttonReset, new GBC(1, 1).setAnchor(GBC.EAST).setFill(GBC.HORIZONTAL));
    }

    public JButton getButtonDraw() {
        return buttonDraw;
    }

    public JButton getButtonFile() {
        return buttonFile;
    }

    public JButton getButtonReset() {
        return buttonReset;
    }
}
