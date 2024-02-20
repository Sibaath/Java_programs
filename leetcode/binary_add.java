public class binary_add
{
    public static String binary(String a ,String b)
    {
            char carry = '0';
            String res = "";
            int i , j;
            for(i = a.length()-1,j=b.length()-1 ; i>=0 && j>=0 ;)
            {
                char num1 = a.charAt(i);
                char num2 = b.charAt(j);
                
                if(num1=='1' && num2=='1') 
                {
                    if(carry=='1')
                        res+='1';
                    else
                        res+='0';
                    carry = '1';
                }
                else if(num1=='1' || num2=='1')
                {
                    if(carry == '1')
                    res+='0';
                    else
                    {
                        res+='1';
                        carry = '0';
                    }
                }
                else
                {
                    if(carry=='1')
                    {
                        carry = '0';
                        res+='1';
                    }
                    else
                        res+='0';
                }
                i--;
                j--;
            }
            while(i>=0)
                {
                    char num1 = a.charAt(i);
                    if(num1=='1' && carry=='1')
                    {
                        res+='0';
                        carry = '1';
                    }
                    else if(num1=='1' || carry=='1')
                    {
                        res+='1';
                        carry = '0';
                    }
                    else
                        res+='0';
                    i--;
                }
                while(j>=0)
                {
                    char num1 = b.charAt(j);
                    if(num1=='1' && carry=='1')
                    {
                        res+='0';
                        carry = '1';
                    }
                    else if(num1=='1' || carry=='1')
                    {
                        res+='1';
                        carry = '0';
                    }
                    else
                        res+='0';
                    j--;
                }
            if(carry == '1')
            res+='1';
            return new StringBuilder(res).reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(binary("1010","1011"));
    }
}