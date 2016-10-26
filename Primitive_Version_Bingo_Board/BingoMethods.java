import java.util.*;
import java.io.*;

public class BingoMethods
{
   public static ArrayList<String> random(ArrayList<String> array)
   {
      Random index = new Random();
      ArrayList<String> newArray = new ArrayList<>();
      return random(array, newArray, index);
   }
   public static ArrayList<String> random(ArrayList<String> original, ArrayList<String> newArray, Random index)
   {
      if(original.size() > 1)
      {
         newArray.add(original.remove(index.nextInt(original.size())));
         return random(original, newArray, index);
      }
      
      newArray.add(original.remove(0));
      newArray.trimToSize();
      return newArray;
   }
   public static String boardName(Scanner kb)
   {
      if(kb == null)
         kb = new Scanner(System.in);
      String name = "";
      String verify = "";
      
      System.out.println("Welcome to Bingo!");
      while(!(verify.equalsIgnoreCase("yes") || verify.equalsIgnoreCase("y") || verify.equalsIgnoreCase("yea")))
      {
         verify = "q";
         System.out.println("Please enter the name of your board:");
         name = kb.nextLine();
         while(name.isEmpty())
         {
            System.out.println("Nothing entered. Please give a name:");
            name = kb.nextLine();
         }
         System.out.println("Is \"" + name + "\" the name you would like?");
         while(!(verify.equalsIgnoreCase("no") || verify.equalsIgnoreCase("n") || verify.equalsIgnoreCase("nay") || verify.equalsIgnoreCase("yes") || verify.equalsIgnoreCase("y") || verify.equalsIgnoreCase("yea")))
         {
            System.out.println("Please enter y/n:");
            verify = kb.nextLine();
         }
      }
      System.out.println("Board name will be \"" + name + "\".");
      return name;
   }
   public static int menu(Scanner kb)
   {
      if(kb == null)
         kb = new Scanner(System.in);
      int choice = 0;
      System.out.println("Please choose a source for Bingo Square values:");
      System.out.println("1) From a Database");
      System.out.println("2) From a .txt file");
      System.out.println("3) Entered in manually");
      System.out.println("4) Exit the program");
      
      while(choice < 1 || choice > 4)
      {
         try
         {
            System.out.println("Please enter a number 1-4:");
            choice = kb.nextInt();
            if(choice < 1 || choice > 4)
               System.out.println("Choice out of range.");
         }
         catch(InputMismatchException e)
         {
            System.out.println("Enter an integer 1, 2, 3, or 4:");
         }
         finally
         {
            kb.nextLine();
         }
      }
      return choice;
   }
   public static ArrayList<String> fromFile(Scanner kb) throws FileNotFoundException
   {
      File inFile = FileUtil.inputFileName(kb);
      Scanner fin = FileUtil.openInFile(inFile);
      int size = FileUtil.getSize(fin);
      fin.close();
      fin = new Scanner(inFile);
      ArrayList<String> contents = FileUtil.fill(fin, size);
      fin.close();
      return contents;
   }
   public static ArrayList<String> manualEntry(Scanner kb)
   {
      if(kb == null)
         kb = new Scanner(System.in);
      System.out.println("Enter the number of values");
      // What if they don't know?  How would I quit?
      return null;
   }
   public static Dimensions getDimensions(int size, Scanner kb)
   {
      if(kb == null)
         kb = new Scanner(System.in);
      int choice = 0;
      int upAndDown;
      int rows = 0, cols = 0;
      System.out.println("Please choose an option for the board dimensions:");
      System.out.println("1) Automatically create a board from the next square number down from the total values given");
      System.out.println("2) Create a rectangular board using every or most values entered");
      System.out.println("3) Enter the desired dimensions");
      System.out.println("4) Exit the program");
      
      while(choice < 1 || choice > 4)
      {
         try
         {
            System.out.println("Please enter a number 1-4:");
            choice = kb.nextInt();
            if(choice < 1 || choice > 4)
               System.out.println("Choice out of range.");
         }
         catch(InputMismatchException e)
         {
            System.out.println("Enter an integer 1, 2, 3, or 4:");
         }
         finally
         {
            kb.nextLine();
         }
      }
      switch(choice)
      {
         case 1:  if((int)(Math.pow((int)(Math.sqrt(size)), 2)) == size)
                     return new Dimensions((int)(Math.sqrt(size) - 1), (int)(Math.sqrt(size) - 1));
                  else return new Dimensions((int)(Math.sqrt(size)), (int)(Math.sqrt(size)));
         case 2:  upAndDown = (int)(Math.sqrt(size));
                  return new Dimensions(upAndDown, upAndDown + 1);
         case 3:  while(rows < 1)
                  {
                     try
                     {
                        System.out.println("Please enter the number of rows:");
                        rows = kb.nextInt();
                        if(rows < 1)
                           System.out.println("Rows must be greater than zero.");
                     }
                     catch(InputMismatchException e)
                     {
                        System.out.println("Please enter a positive integer:");
                        kb.nextLine();
                     }
                     finally
                     {
                        kb.nextLine();
                     }
                  }
                  while(cols < 1)
                  {
                     try
                     {
                        System.out.println("Please enter the number of columns:");
                        cols = kb.nextInt();
                        if(cols < 1)
                           System.out.println("Columns must be greater than zero.");
                     }
                     catch(InputMismatchException e)
                     {
                        System.out.println("Please enter a positive integer:");
                        kb.nextLine();
                     }
                     finally
                     {
                        kb.nextLine();
                     }
                  }
                  return new Dimensions(rows, cols);
         default: System.out.println("Goodbye.");
                  System.exit(0);
      }
      return new Dimensions(-1, -1);
      // Find the appropriate place where to ask the user if they want the center of the square to be a free space (probably in the display code)
   }
}
