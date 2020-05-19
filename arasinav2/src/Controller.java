import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

public class Controller implements ActionListener {
    GUIView guiView;
    DView dView;
    Model model;

    public Controller(GUIView guiView, DView dView) {
        this.guiView = guiView;
        this.dView = dView;
        guiView.read.addActionListener(this);
        guiView.write.addActionListener(this);
        guiView.left.addActionListener(this);
        guiView.right.addActionListener(this);
        guiView.up.addActionListener(this);
        guiView.down.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals("load")) {
            try {
                Scanner read = new Scanner(Path.of("input.txt"));
                int x = read.nextInt();
                int y = read.nextInt();
                int r = read.nextInt();
                model = new Model(new Circle(x, y, r));
                dView.setCircle(model.circle);
                dView.repaint();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        if(event.getActionCommand().equals("write")) {
            try {
                PrintWriter write = new PrintWriter("output.txt");
                write.println(model.circle.x + " " + model.circle.y + " " + model.circle.radius);
                write.close();
            } catch (FileNotFoundException| NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        try {
            if(event.getActionCommand().equals("left")) {
                model.circle.moveLeft();
                dView.setCircle(model.circle);
                dView.repaint();
            }
            if(event.getActionCommand().equals("right")) {
                model.circle.moveRight();
                dView.setCircle(model.circle);
                dView.repaint();
            }
            if(event.getActionCommand().equals("up")) {
                model.circle.moveUp();
                dView.setCircle(model.circle);
                dView.repaint();
            }
            if(event.getActionCommand().equals("down")) {
                model.circle.moveDown();
                dView.setCircle(model.circle);
                dView.repaint();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}