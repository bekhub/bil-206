import java.awt.*;
import javax.swing.*;

/**
 * GraphPanel
 * @author Bekjan Bubakanov
 */
public class GraphPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Action action = Action.RESET;
    private final FGraph fGraph;
    private final SGraph sGraph;
    private final TGraph tGraph;

    GraphPanel() {
        setBackground(Color.WHITE);
        fGraph = new FGraph(this);
        sGraph = new SGraph(this);
        tGraph = new TGraph(this);
    }

    public void setFGraph(FPanel fPanel) {
        fGraph.init(fPanel);
    }

    public void setSGraph(SPanel sPanel) {
        sGraph.init(sPanel);
    }

    public void setTGraph(TPanel tPanel) {
        tGraph.init(tPanel);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (action) {
            case FDRAW:
                FCalc.init(fGraph);
                fGraph.drawGraph(g2);
                break;
            case FRESULT:
                FCalc.init(fGraph);
                fGraph.drawGraph(g2);
                fGraph.drawRoot(g2);
                break;
            case SDRAW:
                SCalc.init(sGraph);
                sGraph.drawGraph(g2);
                break;
            case SRESULT:
                SCalc.init(sGraph);
                sGraph.drawGraph(g2);
                sGraph.drawResult(g2);
                break;
            case TDRAW:
                tGraph.drawGraph(g2);
                break;
            default:
                break;
        }
    }

    void setAction(Action action) {
        this.action = action;
        repaint();
    }
}