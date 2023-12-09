 package prg_java;

import java.io.*;


public class file_handling
{
    public static void main(String[] args) {
        try{
        BufferedWriter out = new BufferedWriter(new FileWriter("op.txt"));                                                                                                                                                                                                                                            
        out.write("Hello the content is added to the file");
        out.write("\nthis is sibaath");
        out.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
            BufferedReader in  = new BufferedReader(new FileReader("op.txt"));     
            String line = in.readLine();
            System.out.println(line);
  
            in.close();
        }
        catch (Exception e)
        {
            System.out.println(e);

        }
    }
}
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;

// public class file_handling {
//     public static void main(String[] args) {
//         // Specify the file path
//         String filePath = "student_records.csv";

//         // Student ID to modify (change this to the desired student ID)
//         int studentIDToModify = 102;

//         // New grade value
//         String newGrade = "A+";

//         // Read the content of the file and modify the specified student's grade
//         StringBuilder modifiedContent = new StringBuilder();
//         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 String[] fields = line.split(",");

//                 // Check if the line contains the desired student ID
//                 int currentStudentID = Integer.parseInt(fields[0]);
//                 if (currentStudentID == studentIDToModify) {
//                     // Modify the grade field
//                     fields[2] = newGrade;
//                 }

//                 // Reconstruct the line with modified or original fields
//                 modifiedContent.append(String.join(",", fields)).append("\n");
//             }
//         } catch (IOException e) {
//             System.out.println("Error reading the file: " + e.getMessage());
//             return;
//         }

//         // Write the modified content back to the file
//         try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
//             bw.write(modifiedContent.toString());
//             System.out.println("File modified successfully.");
//         } catch (IOException e) {
//             System.out.println("Error writing to the file: " + e.getMessage());
//         }
//     }
// }
