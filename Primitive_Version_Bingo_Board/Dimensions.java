public class Dimensions
{
   private int rows;
   private int columns;
   
   public Dimensions(int rows, int cols)
   {
      if(rows < 1 || cols < 1)
         throw new IllegalArgumentException("Rows and columns must be positive");
      this.rows = rows;
      this.columns = cols;
   }
   public int getRows()
   {
      return this.rows;
   }
   public int getColumns()
   {
      return this.columns;
   }
}