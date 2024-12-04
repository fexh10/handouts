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

/** A mutable class representing a rectangle with integer valued base and height. */
public class Rectangle {
  /** the base of the rectangle */
  private int base;
  /** the height of the rectangle */
  private int height;

  /*-
   * AF(base, height) = a rectangle with base base and height height.
   * 
   * IR:
   *  - base >= 0
   *  - height >= 0
   */

  /**
   * Creates a rectangle of given base and height.
   *
   * @param base the base of the rectangle.
   * @param height height of the rectangle.
   * 
   * @throws IllegalArgumentException if the base or the height of the rectangle is <= 0.
   */
  public Rectangle(int base, int height) {
    if(base <= 0 || height <= 0) 
      throw new IllegalArgumentException("Base and height must be non-negative");
    this.base = base;
    this.height = height;
  }

  /**
   * Returns the base of the rectangle.
   *
   * @return the base of the rectangle.
   */
  public int base() {
    return base;
  }

  /**
   * Sets the base of the rectangle.
   *
   * @param base the new base of the rectangle.
   * @throws IllegalArgumentException if the base is <= 0.
   */
  public void base(int base) {
    if(base <= 0) 
      throw new IllegalArgumentException("Base must be non-negative");
    this.base = base;
  }

  /**
   * Returns the height of the rectangle.
   *
   * @return the height of the rectangle.
   */
  public int height() {
    return height;
  }

  /**
   * Sets the height of the rectangle.
   *
   * @param height the new height of the rectangle.
   * 
   *  @throws IllegalArgumentException if the the height is  <= 0.
   */
  public void height(int height) {
    if (height <= 0) 
      throw new IllegalArgumentException("Height must be non-negative");
    this.height = height;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Rectangle{base=").append(base).append(", height=").append(height).append("}");
    return sb.toString();
  }
}
