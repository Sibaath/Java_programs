public class mul {
    public static String multiply(String num1, String num2) {
        int a = num1.length()-1;
        int b = num2.length()-1;
        int[] arr = new int[a+b+2];
        int carry = 0,j=0,i=0,end=0;
        for(i = a;i>=0;i--)
        {
            carry =0;
            int ch1 = num1.charAt(i)-'0';
            for(j = b;j>=0;j--)
            {
                int ch2 = num2.charAt(j)-'0';
                int sum = (arr[(a+b)-(i+j)]+(ch1*ch2)+carry);
                if((sum/10)!=0)
                {
                    sum = sum%10;
                    carry = (arr[(a+b)-(i+j)]+(ch1*ch2)+carry)/10;
                }
                else
                carry = 0;
                arr[(a+b)-(i+j)] = sum;
                end = (a+b)-(i+j);
            }
            if(carry!=0)
            {
                arr[(a+b)-(i+j)] = carry;
                end=(a+b)-(i+j);
            }
        }
        String res = "";
        for(int k = end;k>=0;k--)
        {
            res+=Integer.toString(arr[k]);
        }
        System.out.println();
        return res;
    }
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
