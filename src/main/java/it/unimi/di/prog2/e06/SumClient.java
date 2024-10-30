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

/** Esercizio 4.3 di PDJ. */
public class SumClient {

  /** . */
  private SumClient() {}

  /**
   * Metodo che somma gli elementi in una lista.
   * 
   * @param a lista. se la lista non ha elementi solleva NullPointerException
   * @return la somma della lista
   */
  public static int sum(List<Integer> a) throws NullPointerException{
    int sum = 0;
    if (a == null) throw new NullPointerException("la lista è nulla");
    for (int i = 0; i < a.size(); i++) sum += a.get(i);
    return sum;
  }

  /**
   * Metodo principale.
   * 
   * @param args non utilizzato
   */
  public static void main(String[] args) {
    List<Integer> a = new ArrayList<>();
    try(Scanner sc = new Scanner(System.in)) {
      while (sc.hasNextInt()) {
        String [] array = sc.nextLine().split(" ");
        for (String string : array) a.add(Integer.parseInt(string));
      }
    }
    try {
      System.out.println(sum(a));
    } catch (NullPointerException e) {
      System.out.println(0);
    }
  }
}
