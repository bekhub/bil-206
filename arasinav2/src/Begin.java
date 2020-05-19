import javax.swing.*;
import java.awt.*;

public class Begin extends JFrame {
    private static final long serialVersionUID = 6928003205361240909L;
    public GUIView guiView;
    public DView dView;
    public Controller controller;

    public Begin() {
        setTitle("Word Graph");
        setSize(640, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(30, 30, 30));

        setLayout(new BorderLayout());

        guiView = new GUIView();
        dView = new DView();

        controller = new Controller(guiView, dView);

        add(dView, BorderLayout.CENTER);
        add(guiView, BorderLayout.WEST);

        setVisible(true);
    };
    public static void main(String[] args) {
        new Begin();
    }
}