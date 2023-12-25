import java.util.Scanner;

public class palin {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true)
    {
    int x = sc.nextInt();
    StringBuffer str = new StringBuffer(Integer.toString(x));
    StringBuffer str1 = new StringBuffer(str).reverse();
    if(x>0 && (str1.toString().equals(str.toString())))
System.out.println("true");
    else
System.out.println("False");
 sc.close();
    }
   
   }
    
}
