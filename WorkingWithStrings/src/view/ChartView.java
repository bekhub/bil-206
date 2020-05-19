package view;

import util.SetMap;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;


public class ChartView extends JPanel
{
    private SetMap<String> words;

    public ChartView() {
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if(words != null) drawChart(g2);
    }

    private void drawChart(Graphics2D g2) {
        Color c = g2.getColor();

        int max = Collections.max(words.values());
        int x = 10, i = 0;
        for (var word : words)
        {
            i++;
            int value = words.get(word);
            int height = (int)((getHeight()-75) * ((double)value / max));
            int width = word.length() * 10 + 10;
            g2.setColor(Color.getHSBColor(12, 12, 12));
            g2.fillRect(x, getHeight() - height - 25, width, height);
            g2.setColor(Color.black);
            g2.drawString(Integer.toString(value), x + 5, getHeight() - height - 30);
            g2.drawString(word, x + 5, getHeight() - 10);
            if(i == 10) break;
            x += (width + 10);
        }
        setPreferredSize(new Dimension(x, 400));
        setMinimumSize(new Dimension(x, 400));
        setMaximumSize(new Dimension(x, 400));
        setSize(new Dimension(x, 400));
        g2.setColor(c);
    }

    public void setWords(SetMap<String> words) {
        this.words = words;
        repaint();
    }
}