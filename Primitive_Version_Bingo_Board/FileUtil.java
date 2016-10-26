import java.io.*;
import java.util.*;

public class FileUtil
{
   public static File inputFileName(Scanner kb)
   {
      if(kb == null)
         kb = new Scanner(System.in);
      String fileName = "psych";
      File inFile = new File(fileName);
      while(!inFile.exists())
      {
         System.out.println("Enter the filename:");
         fileName = kb.nextLine();
         inFile = new File(fileName);
         if(!inFile.exists())
            System.out.println("File does not exist.");
      }
      return inFile;
   }
   public static Scanner openInFile(File inFile) throws FileNotFoundException
   {
      return new Scanner(inFile);
   }
   public static int getSize(Scanner fin)
   {
      int count = 0;
      while(fin.hasNext())
      {
         fin.nextLine();
         count++;
      }
      return count;
   }
   public static ArrayList<String> fill(Scanner fin, int size)
   {
      ArrayList<String> array = new ArrayList<>(size);
      boolean x = true;
      while(fin.hasNext())
         x = array.add(fin.nextLine());
      array.trimToSize();
      return array;
   }
}