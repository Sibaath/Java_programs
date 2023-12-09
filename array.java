import java.util.ArrayList;
import java.util.Arrays;

public class array {
   public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);
    a.add(1);
    a.add(2);
    a.retainAll(Arrays.asList(1));
   // a.removeAll(Arrays.asList(1,2));
    System.out.println(a);
   // a.remove(a.indexOf(1));
    // System.out.println(Arrays.asList(1,2,3));
   } 
}
