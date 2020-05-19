import java.awt.*;

/**
 * SGraph
 * @author Bekjan Bubakanov
 */
public class SGraph {

    float A11;
    float A12;
    float A21;
    float A22;
    float B1;
    float B2;
    float xs;
    float xe;
    float sX;
    float sY;
    private final GraphPanel graphPanel;

    SGraph(GraphPanel graphPanel) {
        this.graphPanel = graphPanel;
    }

    void init(SPanel sPanel) {
        A11 = Float.parseFloat(sPanel.fieldA11.getText());
        A12 = Float.parseFloat(sPanel.fieldA12.getText());
        A21 = Float.parseFloat(sPanel.fieldA21.getText());
        A22 = Float.parseFloat(sPanel.fieldA22.getText());
        B1 = Float.parseFloat(sPanel.fieldB1.getText());
        B2 = Float.parseFloat(sPanel.fieldB2.getText());
        xs = Float.parseFloat(sPanel.startX.getText());
        xe = Float.parseFloat(sPanel.endX.getText());
    }

    int getWidth() {
        return graphPanel.getWidth();
    }

    int getHeight() {
        return graphPanel.getHeight();
    }

    void drawGraph(Graphics2D g2) {
    }

    void drawResult(Graphics2D g2) {
    }

}
