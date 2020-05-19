import java.awt.*;
import java.util.*;
import java.util.List;

import static java.lang.Math.*;
import static java.lang.Math.round;

public class FGraph {

    float A;
    float B;
    float C;
    float step;
    float E;
    float xs;
    float xe;
    int index;
    private Method method;
    private int mH;
    float sX;
    float sY;
    private List<Float> arrX;
    private List<Float> arrY;
    private GraphPanel graphPanel;

    public FGraph(GraphPanel graphPanel) {
        this.graphPanel = graphPanel;
        this.arrX = new ArrayList<>();
        this.arrY = new ArrayList<>();
    }

    void init(FPanel p) {
        A = Float.parseFloat(p.a.getText());
        B = Float.parseFloat(p.b.getText());
        C = Float.parseFloat(p.c.getText());
        step = Float.parseFloat(p.step.getText());
        E = Float.parseFloat(p.E.getText());
        xs = Float.parseFloat(p.field1.getText());
        xe = Float.parseFloat(p.field2.getText());
        index = p.index;
        method = p.method;
    }

    void drawGraph(Graphics2D g2) {
        FCalc.setScales();
        FCalc.setArrays(arrX, arrY);
        float X, Y, dX, dY, maxY,minX;
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
        mH = round(fy);
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

    void drawRoot(Graphics2D g2) {
        Color c = g2.getColor();
        g2.setColor(Color.GREEN);
        float a = min(xs, xe);
        float b = max(xs, xe);
        float fx = arrX.get(0) - sX;
        double d;
        if(method == Method.BISECTION) d = FCalc.bisection(a, b);
        else d = FCalc.secant(a, b);
        g2.fillOval((int)round(sX * d - fx) - 2, mH - 3, 6, 6);
        g2.setColor(Color.BLACK);
        g2.drawString(String.format("(%.5f)", d),(int)round(sX * d - fx) + 5, mH);
        g2.setColor(c);
    }

    int getWidth() {
        return graphPanel.getWidth();
    }

    int getHeight() {
        return graphPanel.getHeight();
    }
}
