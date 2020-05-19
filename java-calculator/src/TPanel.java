import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

/**
 * SPanel
 * @author Bekjan Bubakanov
 */
public class TPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JFileChooser fileChooser;
    private final JButton buttonDraw;
    private final JButton buttonReset;
    private final JButton buttonFile;
    List<Float> arrX;
    List<Float> arrY;

    TPanel() {
        setLayout(new GridBagLayout());

        buttonDraw = new JButton("Draw");
        buttonReset = new JButton("Reset");
        buttonFile = new JButton("Open file");
        fileChooser = new JFileChooser();
        arrX = new ArrayList<>();
        arrY = new ArrayList<>();

        add(buttonFile, new GBC(0, 0, 2, 1).setFill(GBC.HORIZONTAL));
        add(buttonDraw, new GBC(0, 1).setAnchor(GBC.WEST).setFill(GBC.HORIZONTAL));
        add(buttonReset, new GBC(1, 1).setAnchor(GBC.EAST).setFill(GBC.HORIZONTAL));
    }

    private void fileResponse() {
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            try {
                arrX.clear();
                arrY.clear();
                Scanner reader = new Scanner(fileChooser.getSelectedFile());
                while (reader.hasNext()) {
                    float x = reader.nextFloat();
                    float y = reader.nextFloat();
                    arrX.add(x);
                    arrY.add(y);
                }
                if(arrX.isEmpty() || arrY.isEmpty()) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null,
                                "Неправильный формат данных!",
                                "Error", JOptionPane.ERROR_MESSAGE));
            } catch (Exception e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null,
                                e.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE));
            }
        }
    }

    void setActions(GraphPanel gp) {

        buttonFile.addActionListener(actionEvent -> fileResponse());

        buttonDraw.addActionListener(actionEvent -> {
            gp.setTGraph(this);
            gp.setAction(Action.TDRAW);
        });

        buttonReset.addActionListener(actionEvent -> gp.setAction(Action.RESET));
    }
}
