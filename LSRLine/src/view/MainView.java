package view;

import controller.Controller;
import model.Model;
import util.GBC;
import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public MainView(String title) {
        super(title);
        setLayout(new GridBagLayout());
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ControlView view = new ControlView();
        GraphView graphView = new GraphView();
        Model model = new Model();
        Controller controller = new Controller(model, view, graphView);

        add(view, new GBC(0, 0).setFill(GBC.BOTH).setWeight(10, 10));
        add(graphView, new GBC(1, 0).setFill(GBC.BOTH).setWeight(100, 100));

        pack();
        setSize(700, 500);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width/2 - 460, dimension.height/2 - 215);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}