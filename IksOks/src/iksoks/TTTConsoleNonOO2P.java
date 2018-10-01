package iksoks;
import java.util.Scanner;


public class TTTConsoleNonOO2P {
   // vrednosti za ko ima potez
   public static final int EMPTY = 0;
   public static final int CROSS = 1;
   public static final int NOUGHT = 2;
 
   // vrednosti za stanja (game state)
   public static final int PLAYING = 0;
   public static final int DRAW = 1;
   public static final int CROSS_WON = 2;
   public static final int NOUGHT_WON = 3;
 
   // Tabla
   public static final int ROWS = 3, COLS = 3; 
   public static int[][] board = new int[ROWS][COLS]; 
                                                     
   public static int currentState;  
   public static int currentPlayer; // ko igra
   public static int currentRow, currentCol; 
 
   public static Scanner in = new Scanner(System.in); // Scanner za input
 
   public static void main(String[] args) {
            initGame();
      
      do {
         playerMove(currentPlayer); // update red/vrsta
         updateGame(currentPlayer, currentRow, currentCol); // update stanje
         printBoard();
         //ako ima pobednika
         if (currentState == CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == DRAW) {
            System.out.println("It's a Draw! Bye!");
         }
         // promena igraca
         currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
      } while (currentState == PLAYING); // repeat if not game-over
   }
 
   //crtanje table
   public static void initGame() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            board[row][col] = EMPTY;  
         }
      }
      currentState = PLAYING;
      currentPlayer = CROSS;  
   }
 
   //igra ko ima seed
   public static void playerMove(int theSeed) {
      boolean validInput = false;  // provra jel legalan potez
      do {
         if (theSeed == CROSS) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
         }
         int row = in.nextInt() - 1;  // niz pocinje sa 0 a ne 1, ako se unese 1 crta se u element 0
         int col = in.nextInt() - 1;
         if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY) {
            currentRow = row;
            currentCol = col;
            board[currentRow][currentCol] = theSeed;  
            validInput = true;  // dobar input, ispadanje iz petlje
         } else {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput);  
   }
 
   // update nakon odigranog poteza
   public static void updateGame(int theSeed, int currentRow, int currentCol) {
      if (hasWon(theSeed, currentRow, currentCol)) {  // pobeda?
         currentState = (theSeed == CROSS) ? CROSS_WON : NOUGHT_WON;
      } else if (isDraw()) {  // nereseno
         currentState = DRAW;
      }
      
   }
 
   // true ako je nereseno tj sva polja popunjena bez pobednika
   public static boolean isDraw() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            if (board[row][col] == EMPTY) {
               return false;  
            }
         }
      }
      return true; 
   }
 
   //true ako je igrac sa seed pobedio
   public static boolean hasWon(int theSeed, int currentRow, int currentCol) {
      return (board[currentRow][0] == theSeed         // 3 u vrsti
                   && board[currentRow][1] == theSeed
                   && board[currentRow][2] == theSeed
              || board[0][currentCol] == theSeed      // 3 u koloni
                   && board[1][currentCol] == theSeed
                   && board[2][currentCol] == theSeed
              || currentRow == currentCol            // 3 dijagonala
                   && board[0][0] == theSeed
                   && board[1][1] == theSeed
                   && board[2][2] == theSeed
              || currentRow + currentCol == 2  // 3 druga dijagonala
                   && board[0][2] == theSeed
                   && board[1][1] == theSeed
                   && board[2][0] == theSeed);
   }
 
   // tabla
   public static void printBoard() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            printCell(board[row][col]);
            if (col != COLS - 1) {
               System.out.print("|");   // taraba
            }
         }
         System.out.println();
         if (row != ROWS - 1) {
            System.out.println("-----------"); 
         }
      }
      System.out.println();
   }
 
   //print polja sa x ili o
   public static void printCell(int content) {
      switch (content) {
         case EMPTY:  System.out.print("   "); break;
         case NOUGHT: System.out.print(" O "); break;
         case CROSS:  System.out.print(" X "); break;
      }
   }
}
