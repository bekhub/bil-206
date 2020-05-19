import javax.swing.*;
import java.util.List;
import static java.lang.Math.*;

class FCalc {

    private static float A;
    private static float B;
    private static float C;
    private static float step;
    private static float E;
    private static float xs;
    private static float xe;
    private static int index;
    private static float sX;
    private static float sY;
    private static int W;
    private static int H;

    static void init(FGraph fGraph) {
        A = fGraph.A;
        B = fGraph.B;
        C = fGraph.C;
        step = fGraph.step;
        E = fGraph.E;
        xs = fGraph.xs;
        xe = fGraph.xe;
        index = fGraph.index;
        W = fGraph.getWidth();
        H = fGraph.getHeight();
        setScales();
        fGraph.sX = sX;
        fGraph.sY = sY;
    }

    static double bisection(float a, float b) {
        if (fun(a) * fun(b) >= 0)
        {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Can not find a root in the given interval",
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
        float c = a;
        int n=0;
        while ((b-a) > E)
        {
            n++;
            c = (a+b)/2;
            if (fun(c) == 0.0)
                break;
            else if (fun(c)*fun(a) < 0)
                b = c;
            else
                a = c;
        }
        System.out.println("Root of the" +
                " given equation=" + c);

        System.out.println("No. of "
                + "iterations = " + n);
        return c;
    }

    static double secant(float a, float b) {

        float xm, x0, c;
        if (fun(a) * fun(b) >= 0)
        {
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "Can not find a root in the given interval",
                            "Error", JOptionPane.ERROR_MESSAGE));
        }
        do {
            x0 = (a * fun(b) - b * fun(a)) / (fun(b) - fun(a));
            c = fun(a) * fun(x0);
            a = b;
            b = x0;
            if (c == 0)
                break;
            xm = (a * fun(b) - b * fun(a))
                    / (fun(b) - fun(a));

        } while (abs(xm - x0) >= E);
        return x0;
    }

    static void setScales() {
        double rX, rY, minY, maxY, temp;
        minY = maxY = fun(xs);
        rX = xe - xs + 2;
        for (float i = xs + step; i <= xe; i += step) {
            temp = fun(i);
            if(temp < minY) minY = temp;
            if(temp > maxY) maxY = temp;
        }
        rY = maxY - minY + 2;
        sX = (float)(W/rX);
        sY = (float)(H/rY);
    }

    static void setArrays(List<Float> arrX, List<Float> arrY) {
        arrX.clear();
        arrY.clear();
        for(float i = xs*sX; i <= xe*sX; i+=step) {
            arrX.add(i);
            arrY.add(fun(i / sX) * sY);
        }
    }

    private static float fun(float x) {
        double res = 0;
        switch (index) {
            case 0: res = (A * x + B + C); break;
            case 1: res = (A * pow(x, 2) + B * x + C); break;
            case 2: res = (A * pow(x, 3) + B * pow(x, 2) + C * x); break;
            default: break;
        }
        return Double.valueOf(res).floatValue();
    }
}
