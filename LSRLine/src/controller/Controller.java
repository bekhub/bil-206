package controller;

import model.Model;
import util.Point;
import view.ControlView;
import view.GraphView;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Controller {

    private final Model model;
    private final ControlView controlView;
    private final GraphView graphView;
    private final List<Point> points;

    public Controller(Model model, ControlView controlView, GraphView graphView) {
        this.model = model;
        this.controlView = controlView;
        this.graphView = graphView;
        points = new ArrayList<>();
        initController();
    }

    private void initController() {
        controlView.getReadFromFile().addActionListener(actionEvent -> inputFile());
        controlView.getDraw().addActionListener(actionEvent -> drawLine());
    }

    private void inputFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            try {
                Scanner reader = new Scanner(fileChooser.getSelectedFile());
                points.clear();
                while (reader.hasNext()) {
                    points.add(new Point(reader.nextDouble(), reader.nextDouble()));
                }
                if (points.isEmpty()) {
                    throw new InputMismatchException();
                }
                reader.close();
                model.setPoints(points);
                graphView.draw(points);
            } catch (IOException e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null,
                                "Файл не существует",
                                "Error", JOptionPane.ERROR_MESSAGE));
            } catch (InputMismatchException e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null,
                                "Формат данных неправильный!",
                                "Error", JOptionPane.ERROR_MESSAGE));
            } catch (Exception e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null,
                                e.getMessage().isEmpty() ?
                                "Произошла непредвиденная ошибка!" : e.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE));
            }
        }
    }

    private void drawLine() {
        try {
            controlView.getEquation()
                    .setText(String.format("y = %.3fx + %.3f\n", model.slope(), model.intercept()));
            controlView.getR2().setText(String.format("r2 = %.2f", model.R2()));

            Point min = Collections.min(points).clone();
            Point max = Collections.max(points).clone();
            min.setY(min.getX() * model.slope() + model.intercept());
            max.setY(max.getX() * model.slope() + model.intercept());
            graphView.draw(min, max);
        } catch (NoSuchElementException e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл не выбран",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            e.getMessage().isEmpty() ?
                                    "Произошла непредвиденная ошибка!" : e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
    }
}
