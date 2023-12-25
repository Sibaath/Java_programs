// package prg_java;

// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.io.Serializable;

// public class objser implements Serializable  {
//     public static void main(String[] args) {
//         Employee obj = new Employee("sibaath", "Developer", 3600000.0f);
//         try{
//         FileOutputStream  fout = new FileOutputStream("op.ser");
//         ObjectOutputStream obout = new ObjectOutputStream(fout);
//         obout.writeObject(obj);
//         obout.close();
//         System.out.println("Object serailized");
//         }
//         catch(Exception e)
//         {
//             System.out.println("hi"+e);
//         }
//         try{
//             FileInputStream fin = new FileInputStream("prg_java//objser.java");
//             ObjectInputStream obin = new ObjectInputStream(fin);
//             Employee emp = (Employee)obin.readObject();
//             System.out.println("After searilization : "+emp.name+emp.position+emp.salary);
//             obin.close();
//         }
//         catch(Exception e)
    
//         {
//             System.out.println("Bye"+e);
//         }

//     }
// }
// class Employee
// {
//     String position, name ;
//     float salary;
//     Employee(String name ,String position,float salary)
//     {
//         this.name = name;
//         this.position = position;
//         this.salary = salary;
//     }
// }


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class objser implements Serializable {
    public static void main(String[] args) {
        Employee obj = new Employee("sibaath", "Developer", 3600000.0f);
        try {
            FileOutputStream fout = new FileOutputStream("op.ser");
            ObjectOutputStream obout = new ObjectOutputStream(fout);
            obout.writeObject(obj);
            obout.close();
            System.out.println("Object serialized");
        } catch (IOException e) {
            System.out.println("hi" + e);
        }

        try {
            FileInputStream fin = new FileInputStream("op.ser");
            ObjectInputStream obin = new ObjectInputStream(fin);
            Employee emp = (Employee) obin.readObject();
            System.out.println("After serialization: " + emp.name + emp.position + emp.salary);
            obin.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Bye" + e);
        }
    }
}

class Employee implements Serializable {
    String position, name;
    float salary;

    Employee(String name, String position, float salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}
