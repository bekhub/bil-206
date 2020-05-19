package arasinav;

import javax.swing.*;
import arasinav.view.MainView;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView("Ara Sinav"));
    }
}
