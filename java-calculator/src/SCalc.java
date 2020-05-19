import java.util.List;

/**
 * SCalc
 * @author Bekjan Bubakanov
 */
public class SCalc {

    private static float A11;
    private static float A12;
    private static float A21;
    private static float A22;
    private static float B1;
    private static float B2;
    private static float xs;
    private static float xe;
    private static float sX;
    private static float sY;
    private static int W;
    private static int H;

    static void init(SGraph sGraph) {
        A11 = sGraph.A11;
        A12 = sGraph.A12;
        A21 = sGraph.A21;
        A22 = sGraph.A22;
        B1 = sGraph.B1;
        B2= sGraph.B2;
        xs = sGraph.xs;
        xe = sGraph.xe;
        W = sGraph.getWidth();
        H = sGraph.getHeight();
        setScales();
        sGraph.sX = sX;
        sGraph.sY = sY;
    }

    static void setScales() {

    }
}
