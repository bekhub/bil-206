import view.MainView;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView("LSRLine"));
//        List<Double> x = List.of(2d, 3d, 5d, 7d, 9d);
//        List<Double> y = List.of(4d, 5d, 7d, 10d, 15d);
//        Model model = new Model(x, y);
//        System.out.printf("%.3f %.3f\n", model.intercept(), model.slope());
    }
}
