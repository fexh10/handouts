package it.unimi.di.prog2.e18;

/**
 * Class that represents a star.
 * 
 * <p>
 * A star is a {@link CelestialBody} with fixed position and velocity,
 * and energy equal to zero.
 * </p>
 */
public class Star extends CelestialBody {
    /*-
     * AF: the AF of the supertype.
     * 
     * RI: always true.
     */

    /**
     * Constructs a Star.
     * 
     * @param name the name of the celestial body.
     * @param x the x coordinate of the celestial body.
     * @param y the y coordinate of the celestial body.
     * @param z the z coordinate of the celestial body.
     * @throws IllegalArgumentException if the name is empty or filled with blank spaces.
     * @throws NullPointerException if name is {@code null}.
     */
    public Star(String name, int x, int y, int z) {
        super(name, x, y, z);
    }

    @Override
    public Point velocity() {
        return new  Point(0, 0, 0);
    }

    @Override
    public int energy() {
        return 0;
    }

    @Override
    public void updatePosition() {}

    @Override
    public void updateVelocity(CelestialBody c) {}

    @Override
    public String toString() {
      return String.format("Star, name: %s, pos: %s", name(), position());
    }
}
