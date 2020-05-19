import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * SPanel
 * @author Bekjan Bubakanov
 */
public class SPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JTextField fieldA11;
    JTextField fieldA12;
    JTextField fieldA21;
    JTextField fieldA22;
    JTextField fieldB1;
    JTextField fieldB2;
    JTextField startX;
    JTextField endX;
    private final JButton buttonDraw;
    private final JButton buttonResult;
    private final JButton buttonReset;

    public SPanel() {
        setLayout(new GridBagLayout());

        fieldA11 = new JTextField(5);
        fieldA12 = new JTextField( 5);
        fieldA21 = new JTextField( 5);
        fieldA22 = new JTextField( 5);
        fieldB1 = new JTextField( 5);
        fieldB2 = new JTextField( 5);
        startX = new JTextField(5);
        endX = new JTextField(5);
        buttonDraw = new JButton("Draw");
        buttonResult = new JButton("Find Result");
        buttonReset = new JButton("Reset");

        var sXLabel = new JLabel("X-start");
        var eXLabel = new JLabel("X-end");
        var panelA = new JPanel();
        var panelB = new JPanel();

        panelA.setLayout(new GridBagLayout());
        panelB.setLayout(new GridBagLayout());
        panelA.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "A"));
        panelB.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "B"));

        panelA.add(fieldA11, new GBC(0, 0).setInsets(4));
        panelA.add(fieldA12, new GBC(1, 0));
        panelA.add(fieldA21, new GBC(0, 1));
        panelA.add(fieldA22, new GBC(1, 1));
        panelB.add(fieldB1, new GBC(0, 0).setInsets(4));
        panelB.add(fieldB2, new GBC(0, 1));

        add(panelA, new GBC(0, 0).setAnchor(GBC.WEST).setInsets(0,0,7,0));
        add(panelB, new GBC(1, 0).setAnchor(GBC.EAST).setInsets(0,0,7,0));
        add(sXLabel, new GBC(0, 1, 2, 1).setAnchor(GBC.WEST));
        add(startX, new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(0, 0, 3, 0));
        add(eXLabel, new GBC(0, 2, 2, 1).setAnchor(GBC.WEST));
        add(endX, new GBC(1, 2).setFill(GBC.HORIZONTAL).setInsets(0, 0, 7, 0));
        add(buttonDraw, new GBC(0, 3).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL));
        add(buttonResult, new GBC(1, 3).setAnchor(GBC.EAST).setFill(GBC.HORIZONTAL));
        add(buttonReset, new GBC(0, 4, 2, 1).setFill(GBC.HORIZONTAL));
    }

    void setActions(GraphPanel gp) {

        buttonDraw.addActionListener(actionEvent -> {
            gp.setSGraph(this);
            gp.setAction(Action.SDRAW);
        });

        buttonResult.addActionListener(actionEvent -> {
            gp.setSGraph(this);
            gp.setAction(Action.SRESULT);
        });

        buttonReset.addActionListener(actionEvent -> gp.setAction(Action.RESET));
    }
}
