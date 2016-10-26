import java.util.*;

public class Display
{
   public static void toScreen(ArrayList<String> values, Dimensions dim)
   {
      int placeCount = 0;
      System.out.print("| ");
      for(String s: values)
      {
         System.out.print(s + " | ");
         placeCount++;
         if(placeCount == dim.getColumns())
         {
            System.out.print("\r\n| ");
            placeCount = 0;
         }
      }
   }
   public static void toFX(ArrayList<String> values, Dimensions dim)
   {
      System.out.println("Under construction");
   }
}