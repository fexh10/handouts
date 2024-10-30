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

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/** Esercizio 4.2 di PDJ. */
public class SearchClient {

  /** . */
  private SearchClient() {}

  /**
   * Metodo che controlla se l'elemento x è prensente in a.
   * 
   * @param a array di interi in ordine cresente. se a è null, sollevo {@code NullPointerException}
   * @param x numero da trovare nell'array. Se non è presente sollevo {@code NotFoundException}
   * @return l'indice dell'elemento trovato
   * @throws NullPointerException .
   * @throws NotFoundException .
   */
  public static int search (int[ ] a, int x) throws NullPointerException, NotFoundException {
    if (a == null) throw new NullPointerException("L'array è vuoto");
    for (int i = 0; i < a.length; i++) 
      if (a[i] == x) return i;
    throw new NotFoundException("elemento non trovato");
  }

  /**
   * Metodo pricipale
   * 
   * @param args che contiene un numero da ricercare nell'array inserito.
   */
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    List<Integer> a = new ArrayList<>();
    try (Scanner sc = new Scanner(System.in)) {      
        String [] array = sc.nextLine().split(" ");
        for (String string : array) {
          a.add(Integer.parseInt(string));
        }
    }
    int[] result = new int[a.size()];
    for (int i = 0; i < a.size(); i++) result[i] = a.get(i);
    try {
      System.out.println(search(result, n));
    } catch (NotFoundException e) {
      System.out.println(-1);
    }
  }
}
