package mvc;

import mvc.controllers.FirstController;
import mvc.controllers.SecondController;
import mvc.controllers.ThirdController;
import mvc.models.FirstModel;
import mvc.models.Model;
import mvc.models.ThirdModel;
import mvc.utils.GBC;
import mvc.views.FirstView;
import mvc.views.GraphPanel;
import mvc.views.SecondView;
import mvc.views.ThirdView;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    MainView(String title) {
        super(title);
        setLayout(new GridBagLayout());
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FirstView firstView = new FirstView();
        SecondView secondView = new SecondView();
        ThirdView thirdView = new ThirdView();
        FirstModel firstModel = new FirstModel();
        GraphPanel graphPanel = new GraphPanel();
        FirstController firstController = new FirstController(firstModel, firstView, graphPanel);
        firstController.initController();
        Model thirdModel = new ThirdModel();
        ThirdController thirdController = new ThirdController(thirdModel, thirdView, graphPanel);
        thirdController.initController();
        SecondController secondController = new SecondController(thirdModel, secondView, graphPanel);
        secondController.initController();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("First", firstView);
        tabbedPane.addTab("Second", secondView);
        tabbedPane.addTab("Third", thirdView);

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
