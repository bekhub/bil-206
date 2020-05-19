package util;

import javax.swing.*;

public class Message {
    public final static int NO_FILE = 0;
    public final static int ERROR = 1;
    public final static int FILE_UNREAD = 2;
    public final static int DATA_FORMAT = 3;
    public final static int FILE_NOT_EXIST = 4;
    public final static int FILE_IS_EMPTY = 5;

    public static void show(int error, Exception e) {
        if (error == NO_FILE) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл не выбран",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } else if(error == ERROR) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            e.getMessage().isEmpty() ?
                                    "Непредвиденная ошибка!" : e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE));
        } else if(error == FILE_UNREAD) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл не прочитан!",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } else if(error == DATA_FORMAT) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Формат данных неправильный!",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } else if(error == FILE_NOT_EXIST) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл не существует",
                            "Error", JOptionPane.ERROR_MESSAGE));
        } else if(error == FILE_IS_EMPTY) {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Файл пуст",
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
    }
}
