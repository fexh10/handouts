package it.unimi.di.prog2.e18;

import java.lang.Math;
import java.util.Objects;

/**
 * Immutable point with three int coordinates.
 * 
 * @param x the x coordinate.
 * @param y the y coordinate.
 * @param z the z coordinate.
 */
public record Point(int x, int y, int z) {

    /**
     * Returns the norm of this point.
     * 
     * The norm is calculated by adding the absolute values of the three points.
     * 
     * @return the norm.
     */
    public int norm() {
        return Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    /**
     * Sum this Point to the one given by argument.
     * 
     * @param p the point to be sum by this.
     * @return the sum.
     * 
     * @throws NullPointerException if p is {@code null}.
     */
    public Point sum(final Point p) {
        Objects.requireNonNull(p);
        return new Point(x + p.x, y + p.y, z + p.z);
    }

    /**
     * Substract this Point to the one given by argument.
     * 
     * @param p the point to be subtructed by this.
     * @return the difference.
     * 
     * @throws NullPointerException if p is {@code null}.
     */
    public Point subtract(final Point p) {
        Objects.requireNonNull(p);
        return new Point(x - p.x, y - p.y, z - p.z);
    }

    /**
     * Returns a point with coordinates -1, 0, or 1 depending on the sign of the
     * coordinates of this
     * point.
     *
     * @return a point with coordinates representing the sign of this point's coordinates.
     */
    public Point signum() {
        return new Point((int) Math.signum(x), (int) Math.signum(y), (int) Math.signum(z));
    }

    @Override
    public final String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
