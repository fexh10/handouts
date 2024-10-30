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

public class NaveSpaziale {
  /** costruttore */
  private NaveSpaziale() {}

  /**
   * the main
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    int from = Integer.parseInt(args[0]);
    int to = Integer.parseInt(args[1]);

    if (to % 2 == 0 && to > from * 4) {
      while (from < to / 4) {
        from += 1;
        System.out.print("P");
      }
      from *= 4;
      System.out.print("S");
      for (int i = from; i < to; i++) {
        System.out.print("P");
      }
    } else {
      if (from * 4 > to) {
        for (int i = from; i < to; i++) {
          System.out.print("P");
        }
      } else {
        while (from * 4 < to) {
          System.out.print("S");
          from = from * 4;
        }
        for (int i = from; i < to; i++) {
          System.out.print("P");
        }
      }
    }
    System.out.println();
  }
}
