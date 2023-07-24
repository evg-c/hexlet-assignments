package exercise;

// BEGIN
public final class Segment {
    private Point begin;
    private Point end;
    public Segment(Point beginPoint, Point endPoint) {
        this.begin = beginPoint;
        this.end = endPoint;
    }

    public Segment() {
    }

    public Point getBeginPoint() {
        return begin;
    }

    public Point getEndPoint() {
        return end;
    }

    public void setBeginPoint(Point beginPoint) {
        this.begin = beginPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.end = endPoint;
    }
    public Point getMidPoint() {
        Point beginPoint = getBeginPoint();
        int xBegin = beginPoint.getX();
        int yBegin = beginPoint.getY();
        Point endPoint = getEndPoint();
        int xEnd = endPoint.getX();
        int yEnd = endPoint.getY();
        int xMid = (xBegin + xEnd) / 2;
        int yMid = (yBegin + yEnd) / 2;
        return new Point(xMid, yMid);
    }
}
// END
