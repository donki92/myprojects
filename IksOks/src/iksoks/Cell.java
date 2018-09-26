package iksoks;
/**
 * Predstavnja se jedno polje na tabli
 */
public class Cell {  
   // package access
   Seed content; // sadrzaj polja prema interfejsu Seed
                 // moguce vrednosti Seed.EMPTY, Seed.CROSS, or Seed.NOUGHT
   int row, col; 
 
   /** Konstruktor za polje*/
   public Cell(int row, int col) {
      this.row = row;
      this.col = col;
      clear();  // brisanje
   }
 
   /** Brisanje polja, postavljanje na Seed.EMPTY */
   public void clear() {
      content = Seed.EMPTY;
   }
 
   /** Crtanje u polju */
   public void paint() {
      switch (content) {
         case CROSS:  System.out.print(" X "); break;
         case NOUGHT: System.out.print(" O "); break;
         case EMPTY:  System.out.print("   "); break;
      }
   }
}
