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
package it.unimi.di.prog2.e04;


import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/saltapicchio/Testo.md">testo</a>, ma
 * senza il vincolo sul valore massimo per `N`.
 */
public class Saltapicchio {
  /** costruttore */
  private Saltapicchio() {}

  /**
   * the main
   *
   * @param args, the command line arguments
   */
  public static void main(String[] args) {
    final int n = Integer.parseInt(args[0]);
    int[] array = new int[n];
    // inizializzo array da scanner
    try (Scanner sc = new Scanner(System.in)) {
      while (sc.hasNextInt()) {
        for (int i = 0; i < array.length; i++) {
          array[i] = sc.nextInt();
        }
      }
    }

    int[] array2 = new int[n - 1];
    for (int i = 0; i < array2.length; i++) {
      array2[i] = Math.abs(array[i] - array[i + 1]);
    }

    boolean flag = false;
    for (int i = 1; i < n; i++) {
      flag = false;
      for (int j = 0; j < array2.length; j++) {
        if (array2[j] == i) {
          flag = true;
          break;
        }
      }
      if (!flag) break;
    }

    if (flag) System.out.println("saltapicchio");
  }
}
