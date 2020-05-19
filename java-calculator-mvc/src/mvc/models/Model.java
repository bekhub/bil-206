package mvc.models;

import mvc.utils.Function;
import mvc.utils.GraphObserver;
import mvc.utils.GraphPoints;

public abstract class Model {

    protected GraphPoints points;
    protected GraphObserver observer;
    protected Function function;
    protected float E;

    public void setPoints(GraphPoints points) {
        this.points = points;
    }

    public GraphPoints getPoints() {
        return points;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public void registerObserver(GraphObserver observer) {
        this.observer = observer;
    }

    public float getE() {
        return E;
    }

    protected void notifyObserver() {
        observer.updateGraph();
    }

    public abstract void setUp();
}
