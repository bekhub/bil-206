package view;

import javax.swing.*;
import java.awt.*;

public class TableDialog extends JDialog {

    public TableDialog(JFrame owner) {
        super(owner);
    }

    public void init(Object[][] cells) {
        String[] columnNames = {"Word", "Quantity"};
        final JTable table = new JTable(cells, columnNames);
        add(new JScrollPane(table), BorderLayout.CENTER);
        setSize(400, 500);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width/2 - 200, dimension.height/2 - 250);
    }
}
