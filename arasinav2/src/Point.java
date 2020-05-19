public class Point {

    int x;
    int y;

    public Point() {}

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void moveUp() {
        y++;
    }

    void moveDown() {
        y--;
    }

    void moveLeft() {
        x--;
    }

    void moveRight() {
        x++;
    }
}
