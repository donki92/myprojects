package evenodd;
import javax.swing.JOptionPane;

public class EvenOdd
{
   public static void main (String[] args)
   {
      String numStr, result;
      int num, again;
      do 
      {
         numStr = JOptionPane.showInputDialog ("Enter an integer: ");
         num = Integer.parseInt(numStr);
         result = "That number is " + ((num%2 == 0) ? "even" : "odd");
         System.out.println(num%2 == 0);
         JOptionPane.showMessageDialog (null, result);
         again = JOptionPane.showConfirmDialog (null, "Do Another?");
      }
      while (again == JOptionPane.YES_OPTION);
   }
}

