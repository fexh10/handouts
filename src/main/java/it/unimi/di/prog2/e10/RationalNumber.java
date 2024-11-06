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

package it.unimi.di.prog2.e10;

/**
 * A rational number is an immutable number that can be expressed as the quotient or fraction \( p/q
 * \) of two {@code int}s, a numerator \( p \) and a non-zero denominator \( q \).
 */
public class RationalNumber {

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification.

  private int num, den;

  /**
   * Creates a new rational number.
   *
   * @param numerator the numerator.
   * @param denominator the denominator.
   * @throws IllegalArgumentException if {@code denominator} is zero.
   */
  public RationalNumber(int numerator, int denominator) {
    if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero");
    num = numerator;
    den = denominator;
  }

  /**
   * Returns the gcd of two numbers using the Euclidean algorithm.
   * @param a the first number.
   * @param b the second number.
   * @return the greatest common divisor of {@code a} and {@code b}.
   */
  public static int euclideanAlgorithm(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  /**
   * Returns the greatest common divisor of this denominator rational number and another one using the Euclidean algorithm.
   * @return the greatest common divisor of the denominator between this rational number and {@code other}.
   */
  public int gcd(RationalNumber other) {
    return euclideanAlgorithm(den, other.den);
  }

  /**
   * Returns the least common multiple of this rational number and another one.
   * @param other the other rational number.
   * @return the least common multiple .
   */
  public int lcm(RationalNumber other) {
    return den * other.den / gcd(other);
  }

  /**
   * Calculates the simplified form of a rational number using the Euclidean algorithm,
   *  dividing the numerator and denominator by their greatest common divisor.
   * @return the simplified form of the rational number.
   */
  public RationalNumber simplify() {
    int a = euclideanAlgorithm(num, den);
    return new RationalNumber(num / a, den / a);
  }

  /**
   * Returns the sum of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the sum of this rational number and {@code other}.
   */
  public RationalNumber add(RationalNumber other) {
    int denominator = lcm(other);
    int numerator = (denominator / den) * num + (denominator / other.den) * other.num;
    return new RationalNumber(numerator, denominator).simplify();
  }

  /**
   * Returns the product of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the product of this rational number and {@code other}.
   */
  public RationalNumber mul(RationalNumber other) {
    return new RationalNumber(num * other.num, den * other.den).simplify();
  }

  @Override
  public String toString() {
    return num + "/" + den;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof RationalNumber other)) return false;
    return simplify().num == other.simplify().num && simplify().den == other.simplify().den;
  }
}
