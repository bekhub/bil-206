package mvc.controllers;

import mvc.models.Model;
import mvc.utils.Action;
import mvc.utils.GraphPoints;
import mvc.views.GraphPanel;
import mvc.views.ThirdView;

import javax.swing.*;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThirdController implements Controller {

    private final Model model;
    private final ThirdView view;
    private final GraphPanel panel;
    private final JFileChooser fileChooser;
    private final GraphPoints points;

    public ThirdController(Model model, ThirdView view, GraphPanel panel) {
        this.model = model;
        this.view = view;
        this.panel = panel;
        fileChooser = new JFileChooser();
        points = new GraphPoints();
    }

    private void initModel() {
        try {
            if(points.isEmpty()) throw new Exception();
            model.setPoints(points);
        } catch (Exception e) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Выберите файл!",
                            "Error", JOptionPane.ERROR_MESSAGE));
        }

    }

    @Override
    public void initController() {
        view.getButtonDraw().addActionListener(actionEvent -> draw());
        view.getButtonFile().addActionListener(actionEvent -> fileResponse());
        view.getButtonReset().addActionListener(actionEvent -> reset());
    }

    private void draw() {
        initModel();
        panel.setPreparePoints(() -> {
            panel.setScales();
            float scaleX = panel.getScaleX();
            float scaleY = panel.getScaleY();
            GraphPoints points = panel.getPoints();
            GraphPoints modelPoints = model.getPoints();
            points.clear();
            for(int i = 0; i < modelPoints.size(); i++) {
                points.addXY(modelPoints.getX(i) * scaleX, modelPoints.getY(i) * scaleY);
            }
        });
        panel.setModel(model);
        panel.setAction(Action.DRAW);
        model.setUp();
    }

    private void reset() {
        panel.setAction(Action.RESET);
        panel.setModel(model);
        model.setUp();
    }

    private void fileResponse() {
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            try {
                points.clear();
                Scanner reader = new Scanner(fileChooser.getSelectedFile());
                while (reader.hasNext()) {
                    float x = reader.nextFloat();
                    float y = reader.nextFloat();
                    points.addXY(x, y);
                }
                if(points.isEmpty()) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null,
                                "Неправильный формат данных!",
                                "Error", JOptionPane.ERROR_MESSAGE));
            } catch (Exception e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null,
                                e.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE));
            }
        }
    }
}
