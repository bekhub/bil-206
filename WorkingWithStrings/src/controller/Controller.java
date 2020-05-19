package controller;

import model.Model;
import util.Message;
import view.ChartView;
import view.ControlView;
import view.TableDialog;
import view.TextDialog;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    private final Model model;
    private final ControlView controlView;
    private final ChartView chartView;
    private JFrame frame;
    private TextDialog textDialog;

    public Controller(Model model, ControlView controlView, ChartView chartView) {
        this.model = model;
        this.controlView = controlView;
        this.chartView = chartView;
        initController();
    }

    private void initController() {
        this.textDialog = new TextDialog(frame);
        controlView.getReadFromFile().addActionListener(actionEvent -> inputFile());
        controlView.getDraw().addActionListener(actionEvent -> showChart());
        controlView.getWriteToFile().addActionListener(actionEvent -> outputFile());
        controlView.getEnterText().addActionListener(actionEvent -> textDialog.setVisible(true));
        controlView.getShowTable().addActionListener(actionEvent -> showTable());
        textDialog.getEnter().addActionListener(actionEvent -> enterText());
    }

    private void inputFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            try {
                Scanner reader = new Scanner(fileChooser.getSelectedFile(), StandardCharsets.UTF_8);
                StringBuilder builder = new StringBuilder();
                while (reader.hasNextLine()) {
                    builder.append(reader.nextLine()).append(" ");
                }
                model.setText(builder.toString());
                reader.close();
            } catch (IOException e) {
                Message.show(Message.FILE_NOT_EXIST, e);
            } catch (InputMismatchException e) {
                Message.show(Message.DATA_FORMAT, e);
            } catch (Exception e) {
                Message.show(Message.ERROR, e);
            }
        }
    }

    private void showTable() {
        try {
            TableDialog tableDialog = new TableDialog(frame);
            var words = model.getWords();
            if (words.isEmpty()) throw new IllegalArgumentException();
            var list = words.sortedList();
            Object[][] cells = new Object[words.size()][2];
            for (int i = 0; i < words.size(); i++) {
                var word = list.get(i);
                cells[i][0] = word;
                cells[i][1] = words.get(word);
            }
            tableDialog.init(cells);
            tableDialog.setVisible(true);
        } catch (NullPointerException | NoSuchElementException e) {
            Message.show(Message.NO_FILE, e);
        } catch (IllegalArgumentException e) {
            Message.show(Message.FILE_IS_EMPTY, e);
        } catch (Exception e) {
            Message.show(Message.ERROR, e);
        }
    }

    private void enterText() {
        try {
            textDialog.setVisible(false);
            model.setText(textDialog.getArea().getText());
        } catch (NullPointerException e) {
          Message.show(Message.NO_FILE, e);
        } catch (Exception e) {
            Message.show(Message.ERROR, e);
        }
    }

    private void outputFile() {
        try(
                PrintWriter out = new PrintWriter("output.txt", StandardCharsets.UTF_8)
        ) {
            var words = model.getWords();
            if(words.isEmpty()) throw new IllegalArgumentException();
            for (var word: words) {
                out.println(word + " " + words.get(word));
            }
        } catch (NullPointerException e) {
            Message.show(Message.FILE_UNREAD, e);
        } catch (IllegalArgumentException e) {
            Message.show(Message.FILE_IS_EMPTY, e);
        } catch (Exception e) {
            Message.show(Message.ERROR, e);
        }
    }
    private void showChart() {
        try {
            if(!model.getWords().isEmpty())
                chartView.setWords(model.getWords());
            else throw new IllegalArgumentException();
        } catch (NullPointerException | NoSuchElementException e) {
            Message.show(Message.NO_FILE, e);
        } catch (IllegalArgumentException e) {
            Message.show(Message.FILE_IS_EMPTY, e);
        } catch (Exception e) {
            Message.show(Message.ERROR, e);
        }
    }

    public void registerFrame(JFrame frame) {
        this.frame = frame;
    }
}
