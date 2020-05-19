package arasinav.util;

public class Line extends Point {

    private int x1, y1;

    public Line() {}

    public Line(int x, int y, int x1, int y1) {
        super(x, y);
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void moveUp() {
        super.moveUp();
        y1++;
    }

    @Override
    public void moveDown() {
        super.moveDown();
        y1--;
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        x1--;
    }

    @Override
    public void moveRight() {
        super.moveRight();
        x1++;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }
}
