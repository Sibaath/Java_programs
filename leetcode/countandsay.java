package leetcode;

public class countandsay {
    public static String countAndSay(int n) {
        String res = "1";
        for(int i = 0 ;i<n-1;i++)
        {
            int count = 1;
            String val = "";
            for(int j = 0;j<res.length();j++)
            {
                char ch = res.charAt(j);
                int k = j+1,flag=0;
                while(k<res.length() && res.charAt(j)==res.charAt(k))
                {
                    count++;
                    k++;
                    flag = 1;
                }
                if(flag==1)
                j=k;
                val += Integer.toString(count)+ch;
            }
            res = val;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
