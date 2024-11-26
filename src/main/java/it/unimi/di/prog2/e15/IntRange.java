package it.unimi.di.prog2.e15;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** a class that represents an IntRange */
public class IntRange implements Iterable<Integer> {
    /** The starting value of the integer range. */
    private int from;
    /** The ending value of the integer range. */
    private int to;
    /** The step of the integer range. */
    private int step;

    /*-
     * AF(from, to, step) = the set of integers from "from" to "to" with step "step"
     * 
     * RI:
     *  - from <= to
     *  - step >= 1
     *  - from >= {@link Integer#MIN_VALUE}
     *  - to <= {@link Integer#MAX_VALUE}
     */

    /**
     * Creates a new integer range with default values.
     * 
     * from = {@link Integer#MIN_VALUE}, to = {@link Integer#MAX_VALUE}, step = 1
     * 
     */
    public IntRange() {
        from = Integer.MIN_VALUE;
        to = Integer.MAX_VALUE;
        step = 1;
    }

    /**
     * Sets the starting value of the integer range.
     * 
     * @param from the starting value of the integer range
     */
    public void setFrom(int from) {
        this.from = from;
    }

    /**
     * Sets the ending value of the integer range.
     * 
     * @param to the ending value of the integer range
     */
    public void setTo(int to) {
        this.to = to;
    }

    /**
     * Sets the step of the integer range.
     * 
     * @param step the step of the integer range
     */
    public void setStep(int step) {
        this.step = step;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int current = from;
            private boolean hasOverflowed = false;

            @Override
            public boolean hasNext() {
                if (hasOverflowed)
                    return false;
                if (step > 0 && (current >= to || (current + step <= current))) {
                    hasOverflowed = true;
                    return false;
                }
                if (step < 0 && (current <= to || (current + step >= current))) {
                    hasOverflowed = true;
                    return false;
                }
                return true;
            }

            @Override
            public Integer next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                int result = current;
                current += step;
                return result;
            }
        };
    }

}
