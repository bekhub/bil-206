package mvc.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphPoints {
    private final List<Float> xPoints;
    private final List<Float> yPoints;

    public GraphPoints() {
        xPoints = new ArrayList<>();
        yPoints = new ArrayList<>();
    }

    private GraphPoints(List<Float> xPoints, List<Float> yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    public void addXY(Float x, Float y) {
        xPoints.add(x);
        yPoints.add(y);
    }

    public float getX(int i) {
        return xPoints.get(i);
    }

    public float getY(int i) {
        return yPoints.get(i);
    }

    public float minX() {
        return Collections.min(xPoints);
    }

    public float maxX() {
        return Collections.max(xPoints);
    }

    public float minY() {
        return Collections.min(yPoints);
    }

    public float maxY() {
        return Collections.max(yPoints);
    }

    public int size() {
        return xPoints.size();
    }

    public void clear() {
        xPoints.clear();
        yPoints.clear();
    }

    public static GraphPoints copyOf(GraphPoints points) {
        List<Float> xp = List.copyOf(points.xPoints);
        List<Float> yp = List.copyOf(points.yPoints);
        return new GraphPoints(xp, yp);
    }

    public boolean isEmpty() {
        return xPoints.isEmpty() || yPoints.isEmpty();
    }
}