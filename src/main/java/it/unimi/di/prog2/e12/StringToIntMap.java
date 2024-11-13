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

package it.unimi.di.prog2.e12;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A map from {@link String} to {@link Integer}.
 *
 * <p>A <em>map</em> is a collection that associates keys to values. In this case, the keys are
 * strings and the values are integers. The map cannot contain duplicate keys, which means that each
 * key can be associated to at most one value.
 */
public class StringToIntMap {

  // EXERCISE: provide a representation, together with its AF and RI
  // Note: do not use the Map in Java Collections, the point is to implement it from scratch!

  
  /** list containing the keys*/
  private List<String> keys;
  /** list containing the values*/
  private List<Integer> values;

  /*-
   * AF(keys, values) = a map where keys.get(i) is associated to values.get(i) for each i in [0, keys.size()).
   * 
   * RI:
   *  - keys.size() == values.size()
   *  - for each i in [0, keys.size()), keys.get(i) != null
   *  - for each i in [0, keys.size()), values.get(i) != null
   */

  /** Creates a new empty map. */
  public StringToIntMap() {
    keys = new ArrayList<>();
    values = new ArrayList<>();
  }

  /**
   * Returns the size of this map.
   *
   * @return the number of key-value mappings in this map.
   */
  public int size() {
    return keys.size();
  }

  /**
   * Returns if this map is empty.
   *
   * @return {@code true} iff this map contains no key-value mappings.
   */
  public boolean isEmpty() {
    return keys.isEmpty();
  }

  /**
   * Performs a binary search on the given list of elements to find the given element.
   * 
   * <p>The list must be sorted in lexicographic order. If the element is found, the method returns the first index where the element is found;
   *  otherwise it returns the negative index -1 where the element should be inserted to keep the list sorted.
   * 
   * @param elements the list of elements to search in.
   * @param toFind the element to search for.
   * @return the index of the element in the list, or the negative index -1 where the element should be inserted.
   */
  private static int binarySearch(List<String> elements, String toFind) {
    int sx = 0, dx = elements.size() - 1;
    while (sx <= dx) {
        int m = (sx + dx) / 2;
        int order = toFind.compareTo(elements.get(m));
        if (order == 0) return m;
        else if (order < 0) dx = m - 1;
        else sx = m + 1;
    }
    return -sx - 1;
}

  /**
   * Returns if this map contains the specified key.
   *
   * @param key the key to search for.
   * @return {@code true} iff this map contains a key-value mappings with the given {@code key}.
   */
  public boolean containsKey(String key) {
    return binarySearch(keys, key) >= 0;
  }

  /**
   * Returns if this map contains the specified value.
   *
   * @param value the value to search for.
   * @return {@code true} iff this map contains a key-value mappings with the given {@code value}.
   */
  public boolean containsValue(int value) {
    return values.indexOf(value) != 1;
  }

  /**
   * Returns the value to which the specified key is mapped.
   *
   * @param key the key whose associated value is to be returned.
   * @return the value to which the specified key is mapped.
   * @throws NoSuchElementException if this map contains no mapping for the key.
   */
  public int get(String key) throws NoSuchElementException {
    int pos = binarySearch(keys, key);
    if (pos < 0) throw new NoSuchElementException("No such key in the map");
    return values.get(pos);
  }

  /**
   * Associates the specified value with the specified key in this map.
   *
   * @param key the key with which the specified value is to be associated.
   * @param value the value to be associated with the specified key.
   * @return {@code true} iff this map did not already contain a mapping for the key, and hence is
   *     modified by this operation.
   */
  public boolean put(String key, int value) {
    int pos = binarySearch(keys, key);
    if (pos >= 0) {
      values.set(pos, value);
      return false;      
    }
    keys.add(-pos - 1, key);
    values.add(-pos - 1, value);
    return true;
  }

  /**
   * Removes the mapping for a key from this map if it is present.
   *
   * @param key the key whose mapping is to be removed from the map.
   * @return {@code true} iff this map contained a mapping for the specified key, and hence is
   *     modified by this operation.
   */
  public boolean remove(String key) {
    int pos = binarySearch(keys, key);
    if (pos < 0) return false;
    keys.remove(pos);
    values.remove(pos);
    return true;
  }

  /** Removes all of the mappings from this map. */
  public void clear() {
    keys.clear();
    values.clear();
  }
}
