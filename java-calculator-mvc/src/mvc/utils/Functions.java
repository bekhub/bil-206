package mvc.utils;

import javax.swing.*;

import static java.lang.Math.abs;

public class Functions {

    public static double bisection(float a, float b, float E, Function model) {
        if (model.fun(a) * model.fun(b) >= 0)
        {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Can not find a root in the given interval",
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
        float c = a;
        while ((b-a) > E)
        {
            c = (a+b)/2;
            if (model.fun(c) == 0.0)
                break;
            else if (model.fun(c)*model.fun(a) < 0)
                b = c;
            else
                a = c;
        }
        return c;
    }

    public static double secant(float a, float b, float E, Function model) {

        float xm, x0, c;
        if (model.fun(a) * model.fun(b) >= 0)
        {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Can not find a root in the given interval",
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
        do {
            x0 = (a * model.fun(b) - b * model.fun(a)) / (model.fun(b) - model.fun(a));
            c = model.fun(a) * model.fun(x0);
            a = b;
            b = x0;
            if (c == 0)
                break;
            xm = (a * model.fun(b) - b * model.fun(a))
                    / (model.fun(b) - model.fun(a));

        } while (abs(xm - x0) >= E);
        return x0;
    }
}
