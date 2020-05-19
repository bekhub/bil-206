package arasinav.view;

import arasinav.util.Line;
import arasinav.util.Point;

import javax.swing.*;
import java.awt.*;

public class GraphView extends JPanel {

    private float scaleX;
    private float scaleY;
    private Point point;
    private Line line;
    private int mHeight;
    private int mWidth;
    private int isPoint = 2;

    public GraphView() {
        setBackground(Color.WHITE);
        point = new Point();
        line = new Line();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawCS(g2);
        Color c = g2.getColor();
        g2.setColor(Color.BLUE);
        int x, y, x1, y1;
        switch (isPoint) {
            case 0:
                x = Math.round(line.getX() * scaleX + mWidth);
                y = Math.round(mHeight - line.getY() * scaleY);
                x1 = Math.round(line.getX1() * scaleX + mWidth);
                y1 = Math.round(mHeight - line.getY1() * scaleY);
                g2.drawLine(x, y, x1, y1);
                break;
            case 1:
                x = Math.round(point.getX() * scaleX + mWidth);
                y = Math.round(mHeight - point.getY() * scaleY);
                g2.fillOval(x - 3, y - 3, 6, 6);
                break;
            default:
                break;
        }
        g2.setColor(c);
    }

    private void drawCS(Graphics2D g2) {
        setScales();
        Color c = g2.getColor();
        g2.setColor(Color.RED);

        mHeight = Math.round(10 * scaleY);
        mWidth = Math.round(10 * scaleX);
        g2.drawLine(0, mHeight, getWidth(), mHeight);
        g2.drawLine(mWidth, 0, mWidth, getHeight());
        g2.setColor(Color.GRAY);
        for(int i = 0; i < 20; i++) {
            if(i == 10) continue;
            g2.drawLine(0, Math.round(i * scaleY), getWidth(), Math.round(i * scaleY));
            g2.drawLine(Math.round(i * scaleX), 0, Math.round(i * scaleX), getHeight());
        }
        g2.setColor(Color.BLACK);
        for(int i = -10, j = 0, z = 0, y = 10; i <= 10; i++, j+=scaleX, z+=scaleY, y--) {
            g2.drawString(Integer.toString(i), j + Math.round(scaleX / 3), mHeight + Math.round(scaleY / 2));
            if(i == 0) continue;
            g2.drawString(Integer.toString(y), mWidth + Math.round(scaleX / 3), z + Math.round(scaleY / 2));
        }
        g2.setColor(c);
    }

    public void draw(Point point) {
        this.point = point;
        isPoint = 1;
        repaint();
    }

    public void draw(Line line) {
        this.line = line;
        isPoint = 0;
        repaint();
    }

    private void setScales() {
        scaleX = getWidth() / 20.0f;
        scaleY = getHeight() / 20.0f;
    }
}
