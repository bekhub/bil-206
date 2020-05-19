package view;

import javax.swing.*;
import java.awt.*;

public class TextDialog extends JDialog {

    JTextArea area;
    JButton enter;

    public TextDialog(JFrame owner) {
        super(owner, "Enter text", true);
        area = new JTextArea(20, 500);
        enter = new JButton("Enter");
        area.setLineWrap(true);
        add(new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        add(enter, BorderLayout.SOUTH);
        setSize(400, 500);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width/2 - 200, dimension.height/2 - 250);
    }

    public JTextArea getArea() {
        return area;
    }

    public JButton getEnter() {
        return enter;
    }
}
