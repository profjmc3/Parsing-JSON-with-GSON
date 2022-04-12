import java.util.Date;
import java.text.SimpleDateFormat;

public class Assignment 
{
   public String name;
   public long due;
   public double grade;

   public Assignment() { }
 
   public Assignment(String name, long due, double grade)
   {
      this.name = name;
      this.due = due;
      this.grade = grade;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public long getDue()
   {
      return this.due;
   }
   
   public double getGrade()
   {
      return this.grade;
   }
   
   public String getGradeLetter()
   {
      return gradeToLetter(this.grade);
   }
   
   public static String gradeToLetter(double grade)
   {
      String s = "";
      
      if(grade > 96.5)
         s = "A+";
      else if(grade > 91.5)
         s = "A";   
      else if(grade >= 90.0)
         s = "A-";
      else if(grade > 88.5)
         s = "B+";
      else if(grade > 81.5)
         s = "B";
      else if(grade > 80.0)
         s = "B-";
      else if(grade > 78.5)
         s = "C+";
      else if(grade > 70.0)
         s = "C";
      else if(grade > 60)
         s = "D";
      else 
         s = "F";
            
      return s;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setDue(long due)
   {
      this.due = due;
   }
  
   
   public void setGrade(double grade)
   {
      this.grade = Math.max(0, Math.min(100.0, grade));
   }
   
   public void setGrade(String grade)
   {
      this.grade = switch(grade)
      {
         case "A+" -> 100.0; 
         case "A"  -> 96.5; 
         case "A-" -> 91.5; 
         case "B+" -> 88.5; 
         case "B"  -> 85.0; 
         case "B-" -> 81.5; 
         case "C+" -> 78.5; 
         case "C"  -> 75.0; 
         case "D"  -> 65.0;          
         case "F"  -> 55.0;     
         default   -> 0.0; 
      };

   }
   
   public String toString()
   {
      SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yy hh:mm a");
      String formattedDate = fmt.format( new Date(this.due) );
      
      return "Assignment: " + this.name + "\n" +
             "Due: " + formattedDate + "\n" +
             "Grade: " + this.getGradeLetter() + " [" + String.format("%.2f%%",this.grade) + "]\n";
   }
   
   public static void main(String[] args)
   {
      Assignment a = new Assignment("WK1", 1671574189420L, 98.5);
      
      System.out.println( a );
   
   }

}