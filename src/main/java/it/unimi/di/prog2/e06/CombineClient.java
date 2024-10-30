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

package it.unimi.di.prog2.e06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;


/** Esercizio 4.4 di PDJ. */
public class CombineClient {

  /** . */
  private CombineClient() {}

  /**
   * Decodifica una stringa contenente interi separati da spazi.
   *
   * @param string la stringa in ingresso, non può essere {@code null} e deve contenere interi
   *     separati da spazi.
   * @return gli interi contenuti nella stringa.
   */
  private static int[] parseInts(String string) {
    List<Integer> list = new ArrayList<>();
    try (Scanner sl = new Scanner(string)) {
      while (sl.hasNextInt()) list.add(sl.nextInt());
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
    return result;
  }

  /**
   * Metodo che combina due array.
   * 
   * Il metodo esegue la somma degli elementi di b, 
   *  e stampa il prodotto tra quel risultato e gli elementi in a.
   * 
   * @param a array di interi. se a è vuoto o nullo non fa nulla.
   * @param b array di interi. se b è vuoto o nullo non fa nulla.
   */
  static void combine (int[ ] a, int[ ] b) { 
    int sum = IntStream.of(b).sum();
    for (int n : a) {
      System.out.println(n * sum);
    }
  }
  
  /**
   * Metodo principale.
   * 
   * @param args non utilizzato
   */
  public static void main(String[] args) {
    int[] a, b;
    try (Scanner sc = new Scanner(System.in)) {
      a = parseInts(sc.nextLine());
      b = parseInts(sc.nextLine());
    }
    combine(a, b);
  }
}
