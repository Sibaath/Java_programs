package semIII_java;


import java.io.*;
import java.util.*;
public class abc{
    
    public static void main(String[] args) {
    Scanner name= new Scanner(System.in);
        System.out.println("enter the file name");
        String filename=name.nextLine();
        // try {
        //     File fin = new File(filename+".txt");
        //    Scanner fout=new Scanner(fin);
        //     while(fout.hasNextLine())
        //     {
        //         System.out.println(fout.nextLine());
        //     }
        
        //     } catch (FileNotFoundException e) {
        //         System.out.println("file not found");
        // }

        try {
            File fin = new File(filename+".txt");
            FileWriter fout=new FileWriter(fin);
            fout.write("cdghec dejvd edgyd hgedg");
            fout.close();
        } catch (IOException e) {
            System.out.println("error occured");
        }
        name.close();
       
    }
}
