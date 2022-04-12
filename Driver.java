import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Driver 
{

   public static void main(String[] args) throws Exception
   {
      // Get student info   
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter student name: ");
      String tempName = keyboard.nextLine();
      System.out.print("Enter student ID: ");
      String tempID = keyboard.nextLine();

      // Get random assignment data
      System.out.println("\n--> Retrieving data from remote server, please be patient.\n");

      URL url = new URL("https://roan-equinox-chauffeur.glitch.me/grades/json");
      // This totally blocks, cool for discussion point
      Scanner s = new Scanner(url.openStream());
      String rawData = s.nextLine();
      
      // Print raw data for debugging purposes
      System.out.println();
      System.out.println(rawData);
      System.out.println();
      
      // Now create a student instance
      Student student = new Student(tempName,tempID);

      // Using Original Assignment Class
      // Because GregorianCalendar is not a standard JSON type we have to build
      //    a custom deserializer to get the objects to build properly
      // To see this you need to rename Assignment_GCDate.jav to Assignment.java
      // Then uncommont this code and comment out the code below.
      //
      // Requires a custom deserializer for GregorianCalendar
//       Gson gson = new GsonBuilder()
//                       .registerTypeAdapter(GregorianCalendar.class, new CustomGregorianCalendarDeserializer())
//                       .create();
//       Assignments a = gson.fromJson(rawData, Assignments.class);    

      // Using Modified Assignment Class
      // The GregorianCalendar class was removed and replaced with a long to hold the date
      // If we remove GregorianCalendar and store the time as a long
      //    we don't need any modifications due the data being all primitives
      //      
      Gson gson = new Gson();
      Assignments a = gson.fromJson(rawData, Assignments.class);   
            
      student.addAssignments(a.getAssignments());       
      
      System.out.println(student);
      
      
   }

}