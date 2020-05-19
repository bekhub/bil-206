import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.*;
import static java.lang.Math.ceil;

public class TGraph {

    private final GraphPanel graphPanel;
    private List<Float> panArrX;
    private List<Float> panArrY;
    private final List<Float> arrX;
    private final List<Float> arrY;
    float sX;
    float sY;

    TGraph(GraphPanel graphPanel) {
        this.graphPanel = graphPanel;
        arrX = new ArrayList<>();
        arrY = new ArrayList<>();
    }

    void init(TPanel tPanel) {
        panArrX = tPanel.arrX;
        panArrY = tPanel.arrY;
    }

    void drawGraph(Graphics2D g2) {
        setArrays();
        float X, Y, dX, dY, maxY, minX;
        maxY = Collections.max(arrY);
        minX = Collections.min(arrX);
        Color c = g2.getColor();
        g2.setColor(Color.BLUE);
        Y = arrY.get(0);
        X = arrX.get(0);
        float fy = maxY + sY;
        float fx = minX - sX;
        Y = fy - Y;
        X = X - fx;
        int mW = round(sX - minX);
        int mH = round(fy);
        g2.setColor(Color.BLACK);
        g2.drawString(String.format("(%d, %d)", round(ceil(arrX.get(0)/sX)), round(ceil(arrY.get(0)/sY))), X, Y);
        g2.drawString("(0, 0)", mW + 5, mH + 15);
        g2.setColor(Color.RED);
        g2.drawLine(0, mH, getWidth(), mH);
        g2.drawLine(mW, 0, mW, getHeight());
        g2.setColor(Color.BLUE);
        for (int i = 1; i < arrX.size(); i++) {
            dX = arrX.get(i) - fx;
            dY = fy - arrY.get(i);
            g2.drawLine(round(X), round(Y), round(dX), round(dY));
            X = dX;
            Y = dY;
        }
        g2.setColor(Color.BLACK);
        g2.drawString(String.format("(%d, %d)", round(ceil((X + fx)/sX)), round(ceil((fy - Y)/sY))),
                X - 40, Y + 15);
        g2.setColor(c);
    }

    void setScales() {
        try {
            float rX, rY;
            rX = Collections.max(panArrX) - Collections.min(panArrX) + 2;
            rY = Collections.max(panArrY) - Collections.min(panArrY) + 2;
            sX = getWidth()/rX;
            sY = getHeight()/rY;
        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Неправильный формат данных!",
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
    }

    void setArrays() {
        setScales();
        arrX.clear();
        arrY.clear();
        for(int i = 0; i < panArrX.size(); i++) {
            arrX.add(panArrX.get(i) * sX);
            arrY.add(panArrY.get(i) * sY);
        }
    }

    int getWidth() {
        return graphPanel.getWidth();
    }

    int getHeight() {
        return graphPanel.getHeight();
    }
}
