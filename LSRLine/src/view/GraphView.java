package view;

import util.Point;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.*;

public class GraphView extends JPanel {

    private int scaleX;
    private int scaleY;
    private int borderX;
    private int borderY;
    private int mHeight;
    private int mWidth;
    private List<Point> points;
    private Point start, end;
    private int isPoint = 2;

    public GraphView() {
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (isPoint) {
            case 0:
                drawCS(g2);
                drawPoints(g2);
                break;
            case 1:
                drawCS(g2);
                drawPoints(g2);
                drawLine(g2);
                break;
            default:
        }
    }

    private void drawCS(Graphics2D g2) {
        setScales();
        Color c = g2.getColor();

        mHeight = getHeight() - scaleY * borderY;
        mWidth = scaleX * borderX;

        g2.setColor(Color.LIGHT_GRAY);
        for(int i = 0; i < getWidth(); i+=scaleX) {
            if(i == mWidth) continue;
            g2.drawLine(i, 0, i, getHeight());
        }
        for(int i = getHeight(); i > 0; i-=scaleY) {
            if(i == mHeight) continue;
            g2.drawLine(0, i, getWidth(), i);
        }
        g2.setColor(Color.RED);
        g2.drawLine(0, mHeight, getWidth(), mHeight);
        g2.drawLine(mWidth, 0, mWidth, getHeight());
        g2.setColor(Color.BLACK);
        for(int i = -borderX, j = 0; j < getWidth(); i+=2, j+=(scaleX*2)) {
            g2.drawString(Integer.toString(i), j - 10, mHeight + 10);
        }
        for(int i = -borderY, j = getHeight(); j > 0; i+=2, j-=(scaleX*2)) {
            if(i == 0) continue;
            g2.drawString(Integer.toString(i), mWidth - 15, j + 5);
        }
        g2.setColor(c);
    }

    public void draw(List<Point> points) {
        this.points = points;
        isPoint = 0;
        repaint();
    }

    public void draw(Point start, Point end) {
        isPoint = 1;
        this.start = start;
        this.end = end;
        repaint();
    }

    private void drawPoints(Graphics2D g2) {
        Color c = g2.getColor();
        g2.setColor(Color.BLUE);
        int x, y;
        for(var p: points) {
            x = (int) round(p.getX() * scaleX + mWidth);
            y = (int) round(mHeight - p.getY() * scaleY);
            g2.fillOval(x - 3, y - 3, 6, 6);
        }
        g2.setColor(c);
    }

    private void drawLine(Graphics2D g2) {
        Color c = g2.getColor();
        g2.setColor(Color.GREEN);
        int x, y, x1, y1;
        x = (int) round(start.getX() * scaleX + mWidth);
        y = (int) round(mHeight - start.getY() * scaleY);
        x1 = (int) round(end.getX() * scaleX + mWidth);
        y1 = (int) round(mHeight - end.getY() * scaleY);
        g2.drawLine(x, y, x1, y1);
        g2.setColor(c);
    }

    private void setScales() {
        scaleX = 20;
        scaleY = 20;
        double minX = Collections.min(points).getX();
        double minY = Collections.min(points,
                Comparator.comparingDouble(Point::getY)).getY();
        borderX = minX >= 0 ? 4: (int) round(abs(minX)) + 4;
        borderY = minY >= 0 ? 4: (int) round(abs(minY)) + 4;
    }
}
