package arasinav;

import arasinav.util.Line;
import arasinav.util.Point;
import arasinav.view.ControlView;
import arasinav.view.GraphView;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    ControlView view;
    Model model;
    GraphView graphView;

    public Controller(ControlView view, Model model, GraphView graphView) {
        this.view = view;
        this.model = model;
        this.graphView = graphView;
    }

    public void initController() {
        view.getReadFromFile().addActionListener(actionEvent -> inputFile());
        view.getWriteToFile().addActionListener(actionEvent -> outputFile());
        view.getUp().addActionListener(actionEvent -> up());
        view.getDown().addActionListener(actionEvent -> down());
        view.getLeft().addActionListener(actionEvent -> left());
        view.getRight().addActionListener(actionEvent -> right());
    }

    private void draw() {
        if(view.getPoint().isSelected()) {
            graphView.draw(model.getPoint());
        } else {
            graphView.draw(model.getLine());
        }
    }

    private void up() {
        try {
            if(view.getPoint().isSelected())
                model.getPoint().moveUp();
            else
                model.getLine().moveUp();
            draw();
        } catch (NullPointerException e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл не прочитан!",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
    }

    private void down() {
        try {
            if(view.getPoint().isSelected())
                model.getPoint().moveDown();
            else
                model.getLine().moveDown();
            draw();
        } catch (NullPointerException e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл не прочитан!",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
    }

    private void left() {
        try {
            if(view.getPoint().isSelected())
                model.getPoint().moveLeft();
            else
                model.getLine().moveLeft();
            draw();
        } catch (NullPointerException e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл не прочитан!",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE));
        }

    }

    private void right() {
        try {
            if(view.getPoint().isSelected())
                model.getPoint().moveRight();
            else
                model.getLine().moveRight();
            draw();
        } catch (NullPointerException e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл не прочитан!",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE));
        }

    }

    private void inputFile() {
        try {
            Scanner reader = new Scanner(Path.of("input.txt"));
            int x = reader.nextInt();
            int y = reader.nextInt();
            model.setPoint(new Point(x, y));
            x = reader.nextInt();
            y = reader.nextInt();
            int x1 = reader.nextInt();
            int y1 = reader.nextInt();
            model.setLine(new Line(x, y, x1, y1));
            reader.close();
            draw();
        } catch (IOException e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл input.txt не существует",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } catch (InputMismatchException e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Формат данных неправильный!",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
    }

    private void outputFile() {
        try {
            PrintWriter out = new PrintWriter("output.txt", StandardCharsets.UTF_8);
            out.printf("%d %d\n", model.getPoint().getX(), model.getPoint().getY());
            out.printf("%d %d %d %d", model.getLine().getX(), model.getLine().getY(),
                    model.getLine().getX1(), model.getLine().getY1());
            out.close();
        } catch (NullPointerException e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл не прочитан!",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
    }
}
