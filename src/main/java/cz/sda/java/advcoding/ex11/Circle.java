package cz.sda.java.advcoding.ex11;

class Circle implements Resizable {
    private Point2D center;
    private Point2D point;

    public Circle(Point2D center, Point2D point) {
        this.center = center;
        this.point = point;
    }

    public Point2D getCenter() {
        return center;
    }

    public Point2D getPoint() {
        return point;
    }

    public double getRadius() {
        return Math.sqrt(Math.pow(center.getX() - point.getX(), 2) + Math.pow(center.getY() - point.getY(), 2));
    }

    public double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double getCircumference() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    public void resize(double resizeFactor) {
        double newRadius = getRadius() * resizeFactor;
        double x = center.getX() + newRadius;
        double y = center.getY();
        point = new Point2D(x, y);
    }
}
