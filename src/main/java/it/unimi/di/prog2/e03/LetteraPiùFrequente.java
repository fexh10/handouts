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
package it.unimi.di.prog2.e03;

import java.util.Scanner;

// import java.util.HashMap;
// import java.util.Map;

/**
 * Vedi <a href=
 * "https://github.com/mapio/labprog/blob/master/esercizi/lettera_piu_frequente/Testo.md">testo</a>,
 */
public class LetteraPiùFrequente {

  // versione con array
  public static void main(String[] args) {
    int[] array = new int['z' - 'a' + 1];

    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        final String parola = s.nextLine();

        for (char letter : parola.toCharArray()) {
          if (letter != ' ') {
            array['z' - letter] += 1;
          }
        }
      }
    }
    int max = 0;
    for (int i : array) {
      if (i > max) {
        max = i;
      }
    }
    System.out.println(max);
  }

  // versione con le HashMap
  /*public static void main(String[] args) {
    Map<Character, Integer> mappa = new HashMap<>();
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        final String parola = s.nextLine();

        for (int i = 0; i < parola.length(); i++) {
          if (parola.charAt(i) != ' ') {
            mappa.put(parola.charAt(i), mappa.getOrDefault(parola.charAt(i), 0) + 1);
          }
        }
      }
    }

    int massimo = 0;
    for (int values : mappa.values()) {
      if (values > massimo) {
        massimo = values;
      }
    }
    System.out.println(massimo);
  }*/
}
