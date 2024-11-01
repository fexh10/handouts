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

package it.unimi.di.prog2.e09;

import it.unimi.di.prog2.h08.impl.NegativeExponentException;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

/**
 * {@code SparsePoly}s are immutable polynomials with integer coefficients such
 * that the number of
 * nonzero coefficient is small with respect to the degree.
 *
 * <p>
 * A typical {@code Poly} is \( p = c_0 + c_1 x + c_2 x^2 + \cdots + c_n x^n \).
 */
public class SparsePoly {

  /**
   * A record holding a term of the polynomial.
   *
   * @param coeff  the coefficient.
   * @param degree the degree.
   */
  public record Term(int coeff, int degree) {
    /**
     * Builds a term.
     *
     * @throws NegativeExponentException if if {@code degree} &lt; 0.
     */
    public Term { // using the compact constructor
      if (degree < 0)
        throw new NegativeExponentException("A term cannot have a negative exponent.");
    }
  }

  /** The array of terms (in increasing non-zero degree). */
  private final List<Term> terms;

  /** Initializes this to be the zero polynomial, that is \( p = 0 \). */
  public SparsePoly() {
    terms = Collections.emptyList();
  }

  /**
   * Initializes this to be the polynomial \(p = cx^n\).
   *
   * @param c the coefficient.
   * @param n the degree.
   * @throws NegativeExponentException if {@code n} &lt; 0.
   */
  public SparsePoly(int c, int n) throws NegativeExponentException {
    if (n < 0)
      throw new NegativeExponentException("Esponente negativo");
    terms = List.of(new Term(c, n));
  }

  /**
   * Initializes this to be the polynomial with the given terms.
   * 
   * @param lista the list of terms.
   */
  private SparsePoly(final List<Term> lista) {
    terms = Collections.unmodifiableList(lista);
  }

  /**
   * Returns the coefficient of the term of given exponent.
   *
   * @param d the exponent of the term to consider.
   * @return the coefficient of the considered term.
   */
  public int coeff(int d) {
    for (Term term : terms) 
      if (term.degree() == d) return term.coeff();
    return 0;
  }

  /**
   * Returns the degree of this polynomial.
   *
   * @return the largest exponent with a non-zero coefficient; returns 0 if this
   *         is the zero {@code
   *     Poly}.
   */
  public int degree() {
    return terms.isEmpty() ? 0 : terms.get(terms.size() - 1).degree;
  }

  /**
   * Performs polynomial addition.
   *
   * <p>
   * If \( p \) is this polynomial, returns \( p + q \).
   *
   * @param q the polynomial to add to this one.
   * @return the sum among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  public SparsePoly add(SparsePoly q) throws NullPointerException {
    if (q == null) throw new NullPointerException("Il polinomio q è null");
    List<Term> result = new ArrayList<>();

    int i = 0, j = 0;
    while (i < terms.size() || j < q.terms.size()) {
      Term t1 = (i < terms.size()) ? terms.get(i) : null;
      Term t2 = (j < q.terms.size()) ? q.terms.get(j) : null;
      if (t1 != null && (t2 == null || t1.degree() < t2.degree())) {
        result.add(t1);
        i += 1;
      } else if (t2 != null && (t1 == null || t2.degree() < t1.degree())) {
        result.add(t2);
        j += 1;
      } else {
        result.add(new Term(t1.coeff() + t2.coeff(), t1.degree()));
        i += 1;
        j += 1;
      }
    }
    return new SparsePoly(result);
  }

  /**
   * Performs polynomial multiplication.
   *
   * <p>
   * If \( p \) is this polynomial, returns \( p q \).
   *
   * @param q the polynomial to multiply by this one.
   * @return the product among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  public SparsePoly mul(SparsePoly q) throws NullPointerException {
    if (q == null) throw new NullPointerException("Il polinomio q è null");
    List<Term> result = new ArrayList<>();
    for (Term term1 : terms) 
      for (Term term2 : q.terms) result.add(new Term(term1.coeff() * term2.coeff(), term1.degree() + term2.degree()));
    return new SparsePoly(result);
  }

  /**
   * Performs polynomial subtraction.
   *
   * <p>
   * If \( p \) is this polynomial, returns \( p - q \).
   *
   * @param q the polynomial to subtract from this one.
   * @return the subtraction among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  public SparsePoly sub(SparsePoly q) throws NullPointerException {
    return add(q.minus());
  }

  /**
   * Returns the negate polynomial.
   *
   * <p>
   * If \( p \) is this polynomial, returns \( -p \).
   *
   * @return this polynomial multiplied by \( -1 \).
   */
  public SparsePoly minus() {
    List<Term> result = new ArrayList<>();
    for (Term term : terms) result.add(new Term(-term.coeff(), term.degree()));
    return new SparsePoly(result);
  }
}
