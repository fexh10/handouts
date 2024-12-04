/*

Copyright 2024 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.e17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A class to handle a list of rectangles and organize them as in histogram.
 *
 * <p>The rectangles are organized in decreasing height order, more specifically the iterator
 * returns the rectangles in this order.
 */
public class Histogram implements Iterable<Rectangle> {

  /** the list of rectangles */
  private List<Rectangle> rectangles;

  /** Creates an empty histogram. */
  public Histogram() {
    rectangles = new ArrayList<>();
  }

  /**
   * Adds a {@link Rectangle} to this histogram.
   *
   * @param rectangle the rectangle to add.
   */
  public void add(Rectangle rectangle) {
    int i;
    for (i = 0; i < rectangles.size();i++) {
      if (rectangle.height() > rectangles.get(i).height())
        break;
    }
    rectangles.add(i, rectangle);
  }

  /**
   * Changes the base of the given rectangle
   *
   * @param rectangle the rectangle.
   * @param newBase the new base.
   * @throws IllegalArgumentException if the new base is <= 0.
   * @throws NoSuchElementException if the rectangle is not in the histogram.
   */
  public void changeBase(Rectangle rectangle, int newBase) {
    if (newBase <= 0) throw new IllegalArgumentException("base must be non-negative");
    int i = rectangles.indexOf(rectangle);
    if (i == -1) throw new NoSuchElementException();
    rectangles.get(i).base(newBase);
  }

  /**
   * Returns an iterator that produces the rectangles in this histogram in decreasing height order.
   *
   * @return the iterator over the rectangles in this histogram.
   */
  @Override
  public Iterator<Rectangle> iterator() {
    return Collections.unmodifiableList(rectangles).iterator();
  }
}
