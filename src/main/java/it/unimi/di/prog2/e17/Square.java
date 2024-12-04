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

/** A mutable class representing a square with integer valued base. */
public class Square extends Rectangle {

  /**
   * AF(base) = a square with base and height equal to base().
   * 
   * IR: is the same as the one of {@link Rectangle}.
   */

  /**
   * Creates a rectangle of given base and height.
   *
   * @param base the base of the rectangle.
   */
  public Square(final int base) {
    super(base, base);
  }

  /**
   * Sets the base of the square.
   * 
   * @param base the base of the square.
   * 
   * @throws IllegalArgumentExeception if the base is <= 0
   */
  public void base(int base) {
    if (base <= 0)
      throw new IllegalArgumentException("base must be non-negative");
    super.base(base);
    super.height(base);
  }

  /**
   * Sets the height (and the base) of the square.
   * 
   * @param height the height of the square
   * 
   * @throws IllegalArgumentException if the height is <= 0
   */
  public void height(int height) {
    if (height <= 0)
      throw new IllegalArgumentException("Height must be non-negative");
    super.base(height);
    super.height(height);
  }

  @Override
  public String toString() {
      return "Square{ base: " + super.base() + ", height: " + super.height() + "}";  
  }
}
