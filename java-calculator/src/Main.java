import javax.swing.*;
import java.awt.*;

/**
 * Calculator
 * @author Bekjan Bubakanov
 */
class Calculator extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    Calculator(String title) {
        super(title);
        setLayout(new GridBagLayout());
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }


        FPanel fPanel = new FPanel();
        SPanel sPanel = new SPanel();
        TPanel tPanel = new TPanel();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("First", fPanel);
        tabbedPane.addTab("Second", sPanel);
        tabbedPane.addTab("Third", tPanel);
        GraphPanel graphPanel = new GraphPanel();
        fPanel.setActions(graphPanel);
        sPanel.setActions(graphPanel);
        tPanel.setActions(graphPanel);

        add(tabbedPane, new GBC(0, 0).setFill(GBC.BOTH).setWeight(10, 10));
        add(graphPanel, new GBC(1, 0).setFill(GBC.BOTH).setWeight(100, 100));
        pack();
        setSize(910, 430);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width/2 - 460, dimension.height/2 - 215);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

/**
 * Main
 * @author Bekjan Bubakanov
 */
public class Main {
    public static void main(String ...args) {
        SwingUtilities.invokeLater(() -> new Calculator("Calculator"));
    }
}