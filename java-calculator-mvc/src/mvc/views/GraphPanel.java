package mvc.views;

import mvc.models.Model;
import mvc.utils.Action;
import mvc.utils.*;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

/**
 * GraphPanel
 * @author Bekjan Bubakanov
 */
public class GraphPanel extends JPanel implements GraphObserver {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final GraphPoints points;
    private Model model;
    private Function function;
    private int mHeight;
    private float scaleX;
    private float scaleY;
    private Method method;
    private Action action = Action.RESET;
    private PreparePoints preparePoints;

    public GraphPanel() {
        setBackground(Color.WHITE);
        points = new GraphPoints();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (action) {
            case DRAW:
                preparePoints.prepare();
                drawGraph(g2);
                break;
            case RESULT:
                function = model.getFunction();
                preparePoints.prepare();
                drawGraph(g2);
                drawRoot(g2);
                break;
            default: break;
        }

    }

    @Override
    public void updateGraph() {
        repaint();
    }

    public void drawGraph(Graphics2D g2) {
        Color c = g2.getColor();
        g2.setColor(Color.BLUE);

        float X, Y, dX, dY, maxY, minX;
        maxY = points.maxY();
        minX = points.minX();
        Y = points.getY(0);
        X = points.getX(0);
        float fy = maxY + scaleY;
        float fx = minX - scaleX;
        Y = fy - Y;
        X = X - fx;
        int mWidth = round(scaleX - minX);
        mHeight = round(fy);
        g2.setColor(Color.BLACK);
        g2.drawString(String.format("(%d, %d)",
                round(ceil(points.getX(0)/scaleX)), round(ceil(points.getY(0)/scaleY))), X, Y);
        g2.drawString("(0, 0)", mWidth + 5, mHeight + 15);
        g2.setColor(Color.RED);
        g2.drawLine(0, mHeight, getWidth(), mHeight);
        g2.drawLine(mWidth, 0, mWidth, getHeight());
        g2.setColor(Color.BLUE);
        for (int i = 1; i < points.size(); i++) {
            dX = points.getX(i) - fx;
            dY = fy - points.getY(i);
            g2.drawLine(round(X), round(Y), round(dX), round(dY));
            X = dX;
            Y = dY;
        }
        g2.setColor(Color.BLACK);
        g2.drawString(String.format("(%d, %d)", round(ceil((X + fx)/scaleX)), round(ceil((fy - Y)/scaleY))),
                X - 40, Y + 15);
        g2.setColor(c);
    }

    void drawRoot(Graphics2D g2) {
        Color c = g2.getColor();
        g2.setColor(Color.GREEN);
        float a = model.getPoints().minX();
        float b = model.getPoints().maxX();
        float fx = points.getX(0) - scaleX;
        double d;
        if(method == Method.BISECTION) d = Functions.bisection(a, b, model.getE(), function);
        else d = Functions.secant(a, b, model.getE(), function);
        g2.fillOval((int)round(scaleX * d - fx) - 2, mHeight - 3, 6, 6);
        g2.setColor(Color.BLACK);
        g2.drawString(String.format("(%.5f)", d),(int)round(scaleX * d - fx) + 5, mHeight);
        g2.setColor(c);
    }

    public void setScales() {
        GraphPoints points = model.getPoints();
        float rX = points.maxX() - points.minX() + 2;
        float rY = points.maxY() - points.minY() + 2;
        scaleX = getWidth() / rX;
        scaleY = getHeight() / rY;
    }

    public void setModel(Model model) {
        this.model = model;
        this.model.registerObserver(this);
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setPreparePoints(PreparePoints preparePoints) {
        this.preparePoints = preparePoints;
    }

    public float getScaleX() {
        return scaleX;
    }

    public float getScaleY() {
        return scaleY;
    }

    public GraphPoints getPoints() {
        return points;
    }
}