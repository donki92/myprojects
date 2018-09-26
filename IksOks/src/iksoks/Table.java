/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iksoks;
/**
 * Model table za igru
 */
public class Table {  
   // konstantne dimenzije 3x3
   public static final int ROWS = 3;
   public static final int COLS = 3;
 
   // package access
   Cell[][] cells;  //tabla je sacinjena od instanci klase Cell
   int currentRow, currentCol;  // trenutni red/vrsta theSeed
 
   /** Inicijalizacija table */
   public Table() {
      cells = new Cell[ROWS][COLS];
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cells[row][col] = new Cell(row, col); // element niza table
         }
      }
   }
 
   /** Inicijalizacija ili reinicijalizacija sadrzaja table*/
   public void init() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cells[row][col].clear();  // brisanje polja
         }
      }
   }
 
   /** true ako je nereseno */
   public boolean isDraw() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            if (cells[row][col].content == Seed.EMPTY) {
               return false; // i dalje moze da se igra, neko ima theSeed
            }
         }
      }
      return true; // nema praznog polja, gotovo
   }
 
   /** true ako je igrac sa theSeed postavio poslednji potez na
       (currentRow, currentCol) */
   public boolean hasWon(Seed theSeed) {
      return (cells[currentRow][0].content == theSeed         // 3 po vrsti
                   && cells[currentRow][1].content == theSeed
                   && cells[currentRow][2].content == theSeed
              || cells[0][currentCol].content == theSeed      // 3 po koloni
                   && cells[1][currentCol].content == theSeed
                   && cells[2][currentCol].content == theSeed
              || currentRow == currentCol            // 3 po dijagonali
                   && cells[0][0].content == theSeed
                   && cells[1][1].content == theSeed
                   && cells[2][2].content == theSeed
              || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                   && cells[0][2].content == theSeed
                   && cells[1][1].content == theSeed
                   && cells[2][0].content == theSeed);
   }
 
   /** Paint itself */
   public void paint() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cells[row][col].paint();   // svako polje se samo crta
            if (col < COLS - 1) System.out.print("|");
         }
         System.out.println();
         if (row < ROWS - 1) {
            System.out.println("-----------");
         }
      }
   }
}
