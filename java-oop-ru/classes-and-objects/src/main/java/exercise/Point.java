package exercise;

// BEGIN
public final class Point {
    private int x;
    private int y;
    public Point(int xAbs, int yOrd) {
        this.x = xAbs;
        this.y = yOrd;
    }

    public Point() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int xAbs) {
        this.x = xAbs;
    }

    public void setY(int yOrd) {
        this.y = yOrd;
    }
}
// END
