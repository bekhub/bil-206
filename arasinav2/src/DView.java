import javax.swing.*;
import java.awt.*;

public class DView extends JPanel{
    private static final long serialVersionUID = 1L;
    public boolean bas = false;
    public int scalex,scaley;
    Circle circle;
    public Color lc;
    public DView (){
        setBackground(new Color(32, 32, 32));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setOpaque(true);
        lc = new Color(74, 74, 74);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        scalex = getWidth() / 20;
        scaley = getHeight() / 20;
        int xAxis = Math.round(scalex * 10);
        int yAxis = Math.round(scaley * 10);
        for (int i = 0; i < getWidth() / scalex + 1; i++) {
            g.setColor(lc);
            g.drawLine(i * scalex, 0, i * scalex, getHeight());
        }
        for (int i = 0; i < getHeight() / scaley + 1; i++) {
            g.setColor(lc);
            g.drawLine(0, i * scaley, getWidth(), i * scaley);
            if (i == (getHeight() / scaley + 1) / 2){
                g.setColor(Color.GRAY);
                g.drawLine(0, i * scaley, getWidth(), i * scaley);
            }
        }
        g.setColor(Color.GREEN);
        g.drawLine(0, yAxis, getWidth(), yAxis);
        g.drawLine(xAxis, 0, xAxis, getHeight());
        g.setColor(Color.yellow);
        if(bas) {
            int rX = circle.radius * scalex;
            int rY = circle.radius * scaley;
            int x = (circle.x * scalex + xAxis) - rX;
            int y = (yAxis - circle.y * scaley) - rY;
            g.drawOval(x, y, rX * 2, rY * 2);
        }
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
        bas = true;
    }
}