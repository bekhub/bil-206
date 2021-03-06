package model; /******************************************************************************
 *  Compilation:  javac model.Model.java
 *  Execution:    java  model.Model
 *  Dependencies: none
 *
 *  Compute least squares solution to y = beta * x + alpha.
 *  Simple linear regression.
 *
 ******************************************************************************/


import util.Point;

import java.util.ArrayList;
import java.util.List;

/**
 *  The {@code model.Model} class performs a simple linear regression
 *  on an set of <em>n</em> data points (<em>y<sub>i</sub></em>, <em>x<sub>i</sub></em>).
 *  That is, it fits a straight line <em>y</em> = &alpha; + &beta; <em>x</em>,
 *  (where <em>y</em> is the response variable, <em>x</em> is the predictor variable,
 *  &alpha; is the <em>y-intercept</em>, and &beta; is the <em>slope</em>)
 *  that minimizes the sum of squared residuals of the linear regression model.
 *  It also computes associated statistics, including the coefficient of
 *  determination <em>R</em><sup>2</sup> and the standard deviation of the
 *  estimates for the slope and <em>y</em>-intercept.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Model {
    private double intercept, slope;
    private double r2;
    private double svar0, svar1;
    private List<Point> points;

    public void setXY(List<Double> x, List<Double> y) {
        if (x.size() != y.size()) {
            throw new IllegalArgumentException("array sizes are not equal");
        }
        List<Point> points = new ArrayList<>();
        for(int i=0; i<x.size(); i++) {
            points.add(new Point(x.get(i), y.get(i)));
        }
        setPoints(points);
        calculate();
    }

    public void setPoints(List<Point> points) {
        this.points = points;
        calculate();
    }

    private void calculate() {
        int n = points.size();

        // first pass
        double sumx = 0.0, sumy = 0.0;
        for (int i = 0; i < n; i++) {
            sumx  += points.get(i).getX();
            sumy  += points.get(i).getY();
        }
        double xbar = sumx / n;
        double ybar = sumy / n;

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (var p: points) {
            xxbar += (p.getX() - xbar) * (p.getX() - xbar);
            yybar += (p.getY() - ybar) * (p.getY() - ybar);
            xybar += (p.getX() - xbar) * (p.getY() - ybar);
        }
        slope  = xybar / xxbar;
        intercept = ybar - slope * xbar;

        // more statistical analysis
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (var p: points) {
            double fit = slope*p.getX() + intercept;
            rss += (fit - p.getY()) * (fit - p.getY());
            ssr += (fit - ybar) * (fit - ybar);
        }

        int degreesOfFreedom = n-2;
        r2    = ssr / yybar;
        double svar  = rss / degreesOfFreedom;
        svar1 = svar / xxbar;
        svar0 = svar/n + xbar*xbar*svar1;
    }

    /**
     * Returns the <em>y</em>-intercept &alpha; of the best of the best-fit line <em>y</em> = &alpha; + &beta; <em>x</em>.
     *
     * @return the <em>y</em>-intercept &alpha; of the best-fit line <em>y = &alpha; + &beta; x</em>
     */
    public double intercept() {
        return intercept;
    }

    /**
     * Returns the slope &beta; of the best of the best-fit line <em>y</em> = &alpha; + &beta; <em>x</em>.
     *
     * @return the slope &beta; of the best-fit line <em>y</em> = &alpha; + &beta; <em>x</em>
     */
    public double slope() {
        return slope;
    }

    /**
     * Returns the coefficient of determination <em>R</em><sup>2</sup>.
     *
     * @return the coefficient of determination <em>R</em><sup>2</sup>,
     *         which is a real number between 0 and 1
     */
    public double R2() {
        return r2;
    }

    /**
     * Returns the standard error of the estimate for the intercept.
     *
     * @return the standard error of the estimate for the intercept
     */
    public double interceptStdErr() {
        return Math.sqrt(svar0);
    }

    /**
     * Returns the standard error of the estimate for the slope.
     *
     * @return the standard error of the estimate for the slope
     */
    public double slopeStdErr() {
        return Math.sqrt(svar1);
    }

    /**
     * Returns the expected response {@code y} given the value of the predictor
     * variable {@code x}.
     *
     * @param  x the value of the predictor variable
     * @return the expected response {@code y} given the value of the predictor
     *         variable {@code x}
     */
    public double predict(double x) {
        return slope*x + intercept;
    }

    /**
     * Returns a string representation of the simple linear regression model.
     *
     * @return a string representation of the simple linear regression model,
     *         including the best-fit line and the coefficient of determination
     *         <em>R</em><sup>2</sup>
     */
    public String toString() {
        return String.format("%.2f n + %.2f", slope(), intercept()) +
                "  (R^2 = " + String.format("%.3f", R2()) + ")";
    }
}