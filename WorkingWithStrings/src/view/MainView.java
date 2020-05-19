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
        ChartView chartView = new ChartView();
        Model model = new Model();
        Controller controller = new Controller(model, view, chartView);
        controller.registerFrame(this);

        add(view, new GBC(0, 0).setFill(GBC.BOTH).setWeight(10, 10));
        add(new JScrollPane(chartView),
                new GBC(1, 0).setFill(GBC.BOTH).setWeight(100, 100));

        pack();
        setSize(800, 500);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width/2 - 400, dimension.height/2 - 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}