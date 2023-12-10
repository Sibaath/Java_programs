package leetcode;
public class leetcode_8 {
    public static int myAtoi(String s) {
        char ch = ' ';
        int val = 1,flag = 0,res =0;
        if(s.charAt(0)==0)
        flag = 1;
        for(int i =0;i<s.length();i++)
        {
            ch = s.charAt(i);

            if(Character.isDigit(ch))
            res=res*10+((int)ch - 48);

            else if(flag==1 && ch == '0')
            continue;    

            if(ch == '+')
            val = 1;

            else if (ch == '-')
            val = -1 ; 

            else 
            continue;         
        }
        return val*res;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));

    }
}
