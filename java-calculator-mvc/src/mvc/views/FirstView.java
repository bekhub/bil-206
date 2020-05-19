package mvc.views;

import mvc.utils.GBC;

import javax.swing.*;
import java.awt.*;

/**
 * FPanel
 * @author Bekjan Bubakanov
 */
public class FirstView extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final JTextField startX;
    private final JTextField endX;
    private final JTextField a;
    private final JTextField b;
    private final JTextField c;
    private final JTextField step;
    private final JTextField E;
    private final JRadioButton[] radioButtons;
    private final JRadioButton bisectionMethod;
    private final JRadioButton secantMethod;
    private final JButton calculate;
    private final JButton findRoots;
    private final JButton reset;

    public FirstView() {
        setLayout(new GridBagLayout());

        startX = new JTextField("-5", 10);
        endX = new JTextField("5", 10);
        a = new JTextField("1", 10);
        b = new JTextField("0", 10);
        c = new JTextField("0", 10);
        step = new JTextField("0.1", 10);
        E = new JTextField("0.01", 10);
        ButtonGroup buttonGroup = new ButtonGroup();
        ButtonGroup buttonGroup2 = new ButtonGroup();
        radioButtons = new JRadioButton[]{
                new JRadioButton("y = ax + b + c"),
                new JRadioButton("y = ax^2 + bx + c"),
                new JRadioButton("y = ax^3 + bx^2 + cx")
        };
        for(var rb: radioButtons) buttonGroup.add(rb);
        bisectionMethod = new JRadioButton("Bisection method");
        secantMethod = new JRadioButton("Secant method");
        buttonGroup2.add(bisectionMethod);
        buttonGroup2.add(secantMethod);
        calculate = new JButton("Draw");
        findRoots= new JButton("Find Roots");
        reset = new JButton("Reset");

        var label1 = new JLabel("X-start");
        var label2 = new JLabel("X-end");
        var labelA = new JLabel("a");
        var labelB = new JLabel("b");
        var labelC = new JLabel("c");
        var labelStep = new JLabel("step");
        var labelE = new JLabel("E");

        add(label1, new GBC(0, 0, 2, 1).setAnchor(GBC.WEST));
        add(startX, new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(0, 0, 3, 0));
        add(label2, new GBC(0, 1, 2, 1).setAnchor(GBC.WEST));
        add(endX, new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(0, 0, 3, 0));
        add(radioButtons[0], new GBC(0,2,2,1).setAnchor(GBC.WEST).setWeight(0, 0));
        add(radioButtons[1], new GBC(0,3,2,1).setAnchor(GBC.WEST).setWeight(0, 0));
        add(radioButtons[2], new GBC(0,4,2,1).setAnchor(GBC.WEST).setWeight(0, 0));
        add(labelA, new GBC(0, 5).setAnchor(GBC.WEST));
        add(a, new GBC(1, 5).setFill(GBC.HORIZONTAL).setInsets(0, 0, 3, 0));
        add(labelB, new GBC(0, 6).setAnchor(GBC.WEST));
        add(b, new GBC(1, 6).setFill(GBC.HORIZONTAL).setInsets(0, 0, 3, 0));
        add(labelC, new GBC(0, 7).setAnchor(GBC.WEST));
        add(c, new GBC(1, 7).setFill(GBC.HORIZONTAL).setInsets(0, 0, 3, 0));
        add(labelStep, new GBC(0, 8).setAnchor(GBC.WEST));
        add(step, new GBC(1, 8).setFill(GBC.HORIZONTAL).setInsets(0, 0, 3, 0));
        add(labelE, new GBC(0, 9).setAnchor(GBC.WEST));
        add(E, new GBC(1, 9).setFill(GBC.HORIZONTAL).setInsets(0, 0, 3, 0));
        add(bisectionMethod, new GBC(0,10,2,1).setAnchor(GBC.WEST).setWeight(0, 0));
        add(secantMethod, new GBC(0,11,2,1).setAnchor(GBC.WEST).setWeight(0, 0));
        add(calculate, new GBC(0, 12).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL));
        add(findRoots, new GBC(1, 12).setAnchor(GBC.EAST).setFill(GBC.HORIZONTAL));
        add(reset, new GBC(0, 13, 2, 1).setFill(GBC.HORIZONTAL));
    }

    public JTextField getStartX() {
        return startX;
    }

    public JTextField getEndX() {
        return endX;
    }

    public JTextField getA() {
        return a;
    }

    public JTextField getB() {
        return b;
    }

    public JTextField getC() {
        return c;
    }

    public JTextField getStep() {
        return step;
    }

    public JTextField getE() {
        return E;
    }

    public JRadioButton[] getRadioButtons() {
        return radioButtons;
    }

    public JRadioButton getBisectionMethod() {
        return bisectionMethod;
    }

    public JRadioButton getSecantMethod() {
        return secantMethod;
    }

    public JButton getCalculate() {
        return calculate;
    }

    public JButton getFindRoots() {
        return findRoots;
    }

    public JButton getReset() {
        return reset;
    }
}