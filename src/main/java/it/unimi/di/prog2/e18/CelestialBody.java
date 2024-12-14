package it.unimi.di.prog2.e18;

import java.util.Objects;

/**
 * An abstract class that represents a celestial body.
 * 
 * A celestial body is represented by:
 * 
 * <ul>
 * <li>a <em>name</em> (not empty or composed of only spaces);
 * <li>a <em>position</em> and a <em>velocity</em> given by a {@link Point};
 * <li>an <em>energy</em> given by the product of the norm of the position and
 * the norm of the velocity.
 * </ul>
 */
public abstract class CelestialBody implements Comparable<CelestialBody> {

    /** the name of the celestial body */
    private final String name;

    /** the position of the celestial body */
    private Point position;

    /*-
     * AF(name, position): contained into fields of the same name.
     * 
     * RI: 
     *  - name must not be null and must not be empty or composed of only spaces;
    *    - position must not be null;
     */

    /**
     * Constructs a Celestial Body.
     * 
     * @param name the name of the celestial body.
     * @param x the x coordinate of the celestial body.
     * @param y the y coordinate of the celestial body.
     * @param z the z coordinate of the celestial body.
     * @throws IllegalArgumentException if the name is empty or filled with blank spaces.
     * @throws NullPointerException if name is {@code null}.
     */
    public CelestialBody(String name, int x, int y, int z) {
        if (Objects.requireNonNull(name).isBlank())
            throw new IllegalArgumentException();
        this.name = name;
        position = new Point(x, y, z);
    }

    /**
     * Returns the name of this celestial body.
     * 
     * @return the name.
     */
    public String name() {
        return name;
    }

    /**
     * Returns the position of this celestial body.
     * 
     * @return the position.
     */
    public Point position() {
        return position;
    }

    /**
     * Sets the position of this celestial body.
     *
     * @param position the new position.
     * @throws NullPointerException if the position is {@code null}.
     */
    protected void position(Point position) {
        this.position = Objects.requireNonNull(position);
    }

    /**
     * Returns the velocity of this celestial body.
     *
     * @return the velocity (not {@code null}}).
     */
    public abstract Point velocity();

    /**
     * Returns the energy of this celestial body.
     * 
     * The energy of a celestial body is calculated by multiplying the norm of its
     * position by the norm of its velocity.
     * 
     * @return the energy.
     */
    public int energy() {
        return position().norm() * velocity().norm();
    }

    /**
     * Updates the velocity of the celestial body.
     * 
     * <p>
     * The velocity is updated according to the position if the celestial body and
     * the one given by argument.
     * The velocity of the celestial body changes by +1 or -1 depending on whether
     * that coordinate is, respectively,
     * less than or greater than the one given by argument.
     * </p>
     * 
     * @param c the other celestial body.
     * @throws NullPointerException if c is {@code null}.
     */
    public abstract void updateVelocity(final CelestialBody c);

    /**
     * Updates the position of this celestial body (usually following a change in
     * its velocity).
     */
    public abstract void updatePosition();

    @Override
    public int compareTo(CelestialBody o) {
        return name().compareTo(o.name());
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CelestialBody)) return false;
        return name().equals(((CelestialBody) obj).name());
    }
}
