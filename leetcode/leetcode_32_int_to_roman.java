package leetcode;

import java.util.HashMap;

public class leetcode_32_int_to_roman {
     public static String intToRoman(int num) {
        HashMap<Integer,String> list = new HashMap<>();
        list.put(0,"I");
        list.put(5,"V");
        list.put(1,"X");
        list.put(6,"L");
        list.put(2,"C");
        list.put(7,"D");
        list.put(3,"M");
        String result = "",sNum=Integer.toString(num);
        int temp = 0,len=sNum.length()-1;
        int pow = len;
        for(int i =0;i<=len;i++)
        {
            temp = sNum.charAt(i)-'0';
            if(pow==3)
            {
                for(int j =0;j<temp;j++)
                result+=list.get(pow);
                pow--;
                continue;
            }

            else if(temp<=4 && temp>=1)
            {
                if(temp>=1 && temp<=3)
                {
                    for(int j = 0;j<temp;j++)
                        result+=list.get(pow);
                }
                else
                    result += list.get(pow)+list.get(pow+5);
                pow--;
                continue;
            }

            else if(temp==5)
            {
                if(pow<=2)
                result+= list.get(pow+temp);
                pow--;
                continue;
            }

            else if(temp>5 && temp<9)
            {
                result+=list.get(pow+5);
                for(int j =0;j<temp-5;j++)
                result+=list.get(pow);
                pow--;
                continue;
            }

            else if(temp==9)
            {
                result+=list.get(pow)+list.get(pow+1);
                pow--;
                continue;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(100));
    }
}
