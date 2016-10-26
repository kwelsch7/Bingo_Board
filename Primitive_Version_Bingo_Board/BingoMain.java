import java.util.*;

public class BingoMain
{
   public static void main(String[] args) throws Exception
   {
      Scanner keyboard = new Scanner(System.in);
      int choice;
      ArrayList<String> values = new ArrayList<>();
      String name = "";
      Dimensions dim = null;
      
      name = BingoMethods.boardName(keyboard);
      choice = BingoMethods.menu(keyboard);
      switch(choice)
      {
         case 1:  System.out.println("Under construction.");
                  break;
         case 2:  values = BingoMethods.fromFile(keyboard);
                  break;
         case 3:  values = BingoMethods.manualEntry(keyboard);
                  break;
         default: System.out.println("Goodbye");
                  System.exit(0);
      }
      dim = BingoMethods.getDimensions(values.size(), keyboard);
      values = BingoMethods.random(values);
      // Allow user to choose style of print?
      System.out.println(name);
      Display.toScreen(values, dim);
   }
}
