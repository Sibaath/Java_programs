import java.util.Arrays;
import java.util.Collections;

public class rev {
    public static void main(String[] args) {
        String s = "a good   example";
        String[] arr = s.trim().split(" ");
        int j = 0;
        for(int i =0;i<arr.length;i++)
        {
            j=i;
            while(arr[j++].equals(" "));
            arr[i++]= arr[j];
        }
        Collections.reverse(Arrays.asList(arr));
        String res ="";
        for(int i = 0 ;i<arr.length;i++)
        res+=arr[i]+" ";
        res=res.trim();
        System.out.println(res.trim());
    }
}
