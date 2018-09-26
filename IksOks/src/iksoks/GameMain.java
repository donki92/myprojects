package iksoks;
import java.util.Scanner;
/**
 * Main za igru, bez GUI, logika igre
 * 
 */
public class GameMain {
   private Table board;            // tabla za igru
   private GameState currentState; // trenutno stanje igre (pobeda x, pobeda o, nereseno, u toku) iz enum GameState)
   private Seed currentPlayer;     // trenutni igrac
 
   private static Scanner in = new Scanner(System.in);  // input za konzolnu verziju
 
   /**Konstruktor za pocetak igre*/
   public GameMain() {
      board = new Table();  // crtanje table
 
      // status igre
      initGame();
      
      do {
         playerMove(currentPlayer); // igrac postavlja x ili o
         board.paint();             // ponovno crtanje table sa novim vrednostima
         updateGame(currentPlayer); // provera ima li pobednika
         // Ako ima pobednika
         if (currentState == GameState.CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == GameState.NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == GameState.DRAW) {
            System.out.println("It's a Draw! Bye!");
         }
         // menjanje igraca(ternarni operator)
         currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
      } while (currentState == GameState.PLAYING);  // ponavlja se dok nema pobednika ili je nereseno
   }
 
   /** inicijalizacija table */
   public void initGame() {
      board.init();  // brisanje table
      currentPlayer = Seed.CROSS;       // o ide prvi
      currentState = GameState.PLAYING; // spremno za igru
   }
 
   /** igrac sa theSeed je na potezu
       upis u polje */
   public void playerMove(Seed theSeed) {
      boolean validInput = false;  // validacija unosa
      do {
         if (theSeed == Seed.CROSS) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
         }
         int row = in.nextInt() - 1;
         int col = in.nextInt() - 1;
         if (row >= 0 && row < Table.ROWS && col >= 0 && col < Table.COLS
               && board.cells[row][col].content == Seed.EMPTY) {
            board.cells[row][col].content = theSeed;
            board.currentRow = row;
            board.currentCol = col;
            validInput = true; // ako je input dobar iskacemo iz petlje
         } else {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");  //ako je unesen pogresan potez
         }
      } while (!validInput);   // ponavljamo dok ne dobijemo dobar input
   }
 
   /** update stanja igre nako sto je igrac sa theSeed napravio potez*/
   public void updateGame(Seed theSeed) {
      if (board.hasWon(theSeed)) {  // ima li pobednika?
         currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
      } else if (board.isDraw()) {  // jel nereseno?
         currentState = GameState.DRAW;
      }
      // igra u toku? (still GameState.PLAYING).
   }
 
   public static void main(String[] args) {
      new GameMain();  // poziv konstruktora
   }
}