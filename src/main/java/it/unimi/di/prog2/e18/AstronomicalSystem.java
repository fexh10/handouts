package it.unimi.di.prog2.e18;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A class that represents an Astronomical System.
 */
public class AstronomicalSystem {
    
    /** A set containing all the celestial bodies */
    private SortedSet<CelestialBody> celestialBodies;

    /*-
     * AF(celestialBodies): all the celestial bodies.
     * 
     * RI:
     *  - celestialBodies must no be or contain null.
     */

    /**
     * Creates an empty astronomical system.
     */
    public AstronomicalSystem() {
      celestialBodies = new TreeSet<>();  
    }

    /**
     * Adds a celestial body to the system.
     * @param c the celestial body to add.
     * @return {@code true} if the celestial body was added, {@code false} otherwise.
     */
    public boolean add(CelestialBody c) {
        Objects.requireNonNull(c);
        return celestialBodies.add(c);
    }

    /**
     * Performs a simulation step.
     */
    private void step() {
        for (CelestialBody p : celestialBodies) {
            for (CelestialBody c : celestialBodies) {
                if (p == c) 
                    continue;
                p.updateVelocity(c);
            }
        }
        for (CelestialBody c : celestialBodies)
            c.updatePosition();
    }

    /**
     * Simulates the evolution of the system for a given number of steps.
     * @param num the number of steps to simulate.
     * @throws IllegalArgumentException if num is not positive.
     */
    public void simulateSteps(int num) {
        if (num <= 0)
            throw new IllegalArgumentException();
        for (int i = 0; i < num; i++)
            step();
    }

    /**
     * Returns the total energy of the system.
     * @return the total energy.
     */
    public int totalEnergy() {
        return (int) celestialBodies.stream().mapToDouble(CelestialBody::energy).sum();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (CelestialBody c : celestialBodies) sb.append(c.toString()).append("\n");
        return sb.toString();
    }
}
