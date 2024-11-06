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
 * A <em>queue</em> is a mutable data structure that provides access to its elements in
 * first-in/first-out order.
 *
 * <p>A <em>bounded</em> queue has an upper bound, established when a queue is created, on the
 * number of elements that can be stored in the queue.
 */
public class BoundedIntQueue {

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification.

  // Given the boundedness constraint, it is not allowed to use any Java
  // Collection Framework class. An array can be used to store the elements in a
  // circular buffer (see https://www.wikiwand.com/en/articles/Circular_buffer).

  private int[] queue;

  /**
   * Creates a new bounded queue with the given capacity.
   *
   * @param capacity the capacity of the queue.
   * @throws IllegalArgumentException if {@code capacity} is negative.
   */
  public BoundedIntQueue(int capacity) {
    if (capacity < 0) throw new IllegalArgumentException("La capacità non può essere negativa");
    queue = new int[capacity];
  }

  /**
   * Restituisce la capacità della coda
   * @return la capacità della coda
   */
  public int getCapacity() {
    return queue.length;
  }

  /**
   * Calcola la lunghezza effettiva della coda
   * @return la lunghezza della coda
   */
  public int length() {
    int length = 0;
    for (int i = 0; i < getCapacity(); i++) {
      if (queue[i] != 0) {
        length++;
      }
    }
    return length;
  }

  /**
   * Controlla che un coda sia piena
   * 
   *@return true se la coda è piena, false altrimenti
   */
  public boolean isFull() {
    if (length() == queue.length) return true;
    return false;
  }

   /**
    * Controlla che la coda sia vuota o meno.
    *
    * @return true se la coda è vuota, false altrimenti.
    */
  public boolean isEmpty() {
    if (length() == 0) return true;
    return false;
  }

   /**
   * Adds an element to the queue.
   *
   * @param x the element to add.
   * @throws IllegalStateException if the queue is full.
   */
  public void enqueue(int x) {
    if (isFull()) throw new IllegalStateException("La coda è piena");
    queue[length()] = x;
  }

  /**
   * Removes the element at the head of the queue.
   *
   * @return the element at the head of the queue.
   * @throws IllegalStateException if the queue is empty.
   */
  public int dequeue() {
    if (isEmpty()) throw new IllegalArgumentException("La coda è vuota");
    int head = queue[0];
    for (int i = 0; i < length() - 1; i++) {
      queue[i] = queue[i + 1];
    }
    queue[length() - 1] = 0;
    return head;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof BoundedIntQueue other)) return false;
    if (length() != other.length()) return false;
    for (int i = 0; i < length(); i++) {
      if (queue[i] != other.queue[i]) return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("BoundedIntQueue: [");
    for (int i = 0; i < length(); i++) {
      sb.append(queue[i]);
      if (i < length() - 1) sb.append(", ");
    }
    sb.append("]");
    return sb.toString();
  }
}
