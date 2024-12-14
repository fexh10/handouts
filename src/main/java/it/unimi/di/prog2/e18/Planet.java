package it.unimi.di.prog2.e18;

import java.util.Objects;

/**
 * A class that representes a Planet.
 * 
 * A Planet is a {@link CelestialBody} with variaible position and velocity.
 */
public class Planet extends CelestialBody {

    /** The velocity of the planet */
    private Point velocity;

    /*-
     * AF(velocity): a planet with velocity "velocity", the rest of AF is equal to the supertype.
     * 
     * RI:
     *  - velocity must be not null;
     *  - the attributes of the superclass are private so they do not concern this RI;
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
    public Planet(String name, int x, int y, int z) {
        super(name, x, y, z);
        velocity = new Point(0, 0, 0);
    }

    @Override
    public Point velocity() {
        return velocity;
    }

    @Override
    public void updatePosition() {
        position(position().sum(velocity()));
    }

    @Override
    public void updateVelocity(CelestialBody c) {
        Objects.requireNonNull(c);
        final Point dv = c.position().subtract(position()).signum();
        velocity = velocity.sum(dv);
    }

    @Override
    public String toString() {
        return "Planet, name: " + name() + ", pos: " + position() + ", vel: " + velocity();
    }
}
