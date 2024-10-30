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

public class GeneraQuadratoMagico {

  static void printMatrice(int matrice[][]) {
    for (int i = 0; i < matrice.length; i++) {
      for (int j = 0; j < matrice.length; j++) {
        System.out.print(matrice[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    final int N = Integer.parseInt(args[0]);
    int[][] matrice = new int[N][N];
    int row = 0, column = N / 2;

    for (int i = 1; i <= N * N; i++) {
      matrice[row][column] = i;
      int newRow = row - 1, newCol = column + 1;

      if (newRow < 0) newRow = N - 1;
      if (newCol == N) newCol = 0;

      if (matrice[newRow][newCol] == 0) {
        row = newRow;
        column = newCol;
      } else {
        row += 1;
        if (row == N) row = 0;
      }
    }
    printMatrice(matrice);
  }
}
