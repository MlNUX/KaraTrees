package edu.kit.kastel.structure;

public class Point {
    private static final String ROW_COLUMN_SEPERATOR = ", ";
    private static final String CLOSE_BRACKET = ")";
    private static final String OPEN_BRACKET = "(";
    private final int x;
    private final int y;

    public Point(int row, int column) {
        this.x = row;
        this.y = column;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Point scaleVektor(Point vektor, Point point) {
        return new Point(point.getX() + vektor.getX(), point.getY() + vektor.getY());
    }

    @Override
    public String toString() {
        return OPEN_BRACKET + x + ROW_COLUMN_SEPERATOR + y + CLOSE_BRACKET;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point point)) return false;
        return x == point.x && y == point.y;
    }


}
