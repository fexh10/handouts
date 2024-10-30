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
 * Vedi <a href=
 * "https://github.com/mapio/labprog/blob/master/esercizi/somma_strana/Testo.md">testo</a>, ma
 * leggendo gli addendi dal flusso di ingresso.
 */
public class SommaStrana {
  /** costruttore */
  private SommaStrana() {}

  /**
   * the main
   *
   * @param args, the command line arguments
   */
  public static void main(String[] args) {
    String[] numeri = new String[2];

    try (Scanner sc = new Scanner(System.in)) {
      int i = 0;
      while (sc.hasNext() && i < 2) {
        numeri[i] = sc.next();
        i++;
      }
    }

    String n1 = numeri[0];
    String n2 = numeri[1];

    if (n1.length() > n2.length()) {
      n2 = "0".repeat(n1.length() - n2.length()) + n2;
    } else if (n1.length() < n2.length()) {
      n1 = "0".repeat(n2.length() - n1.length()) + n1;
    }

    String risultato = "";
    int riporto = 0;
    for (int i = n1.length() - 1; i >= 0; i--) {
      int somma =
          Integer.parseInt(String.valueOf(n1.charAt(i)))
              + Integer.parseInt(String.valueOf(n2.charAt(i)))
              + riporto;
      if (somma > 9) {
        riporto = 1;
        int strana = 9 - somma % 10;
        if (n1.length() == 1 && n2.length() == 1) {
          risultato = "1" + Integer.toString(strana) + risultato;
        } else {
          risultato = Integer.toString(strana) + risultato;
        }
      } else {
        riporto = 0;
        risultato = Integer.toString(somma) + risultato;
      }
    }
    System.out.println(risultato);
  }
}
