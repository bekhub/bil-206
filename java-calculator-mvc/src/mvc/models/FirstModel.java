package mvc.models;

import mvc.utils.Function;
import mvc.utils.GraphPoints;

import static java.lang.Math.pow;

public class FirstModel extends Model {
    private float startX;
    private float endX;
    private float A;
    private float B;
    private float C;
    private float step;
    private int index;

    public FirstModel() {
        points = new GraphPoints();
    }

    public void setUp() {
        points.clear();
        for (float i = startX; i <= endX; i += step) {
            points.addXY(i, getFunction().fun(i));
        }
        notifyObserver();
    }

    @Override
    public GraphPoints getPoints() {
        return points;
    }

    @Override
    public Function getFunction() {
        return x -> {
            double res = 0;
            switch (index) {
                case 0: res = (A * x + B + C); break;
                case 1: res = (A * pow(x, 2) + B * x + C); break;
                case 2: res = (A * pow(x, 3) + B * pow(x, 2) + C * x); break;
                default: break;
            }
            return Double.valueOf(res).floatValue();
        };
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public void setEndX(float endX) {
        this.endX = endX;
    }

    public void setA(float a) {
        A = a;
    }

    public void setB(float b) {
        B = b;
    }

    public void setC(float c) {
        C = c;
    }

    public void setStep(float step) {
        this.step = step;
    }

    public void setE(float e) {
        E = e;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
