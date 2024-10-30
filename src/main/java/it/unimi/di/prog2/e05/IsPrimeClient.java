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
package it.unimi.di.prog2.e05;

public class IsPrimeClient {

  /** . */
  private IsPrimeClient() {}

  /**
   * REQUIRES: intero n > 0 EFFECTS: restituisce true se n è primo, false altrimenti
   *
   * @param n .
   * @return .
   */
  public static boolean isPrime(int n) {
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * REQUIRES: argomento da linea di comando, numero intero EFFECTS: stampa true se il numero
   * inserito è primo, altrimenti niente
   *
   * @param args .
   */
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    if (isPrime(n)) System.out.println("true");
  }
}
