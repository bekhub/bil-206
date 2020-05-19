import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

public class GUIView extends JPanel{
    private static final long serialVersionUID = 1L;
    public JButton read, write, left, right, up, down;
    public GUIView (){
        setBackground(new Color(41,41,41));
        setOpaque(true);
        read = new JButton("load");
        read.setBackground(new Color(212, 8, 96));
        read.setForeground(Color.WHITE);
        read.setOpaque(true);
        write = new JButton("write");
        write.setBackground(new Color(212, 8, 96));
        write.setForeground(Color.WHITE);
        write.setOpaque(true);
        left = new JButton("left");
        left.setBackground(new Color(212, 8, 96));
        left.setForeground(Color.WHITE);
        left.setOpaque(true);
        right = new JButton("right");
        right.setBackground(new Color(212, 8, 96));
        right.setForeground(Color.WHITE);
        right.setOpaque(true);
        up = new JButton("up");
        up.setBackground(new Color(212, 8, 96));
        up.setForeground(Color.WHITE);
        up.setOpaque(true);
        down = new JButton("down");
        down.setBackground(new Color(212, 8, 96));
        down.setForeground(Color.WHITE);
        down.setOpaque(true);
        add(left);
        add(right);
        add(up);
        add(down);
        add(read);
        add(write);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(80,getHeight());
    }
}