package leetcode;

public class leetcode_125 {
    public static boolean isPalindrome(String s) {
        if(s.length()==1)
        return true;
        char ch_left = ' ',ch_right = ' ';
        int left = 0,right = s.length()-1;
        while(left!=right && left+1!=right)
        {
            ch_left = s.charAt(left);
            ch_right = s.charAt(right);

            if(Character.isLetter(ch_left) && Character.isLetter(ch_right))
            {
                if(Character.toLowerCase(ch_left)==Character.toLowerCase(ch_right))
                {
                    left++;
                    right--;
                    continue;
                }
                else
                    break;
            }

            if(!(Character.isLetter(ch_left)))
            left++;

            else if(!(Character.isLetter(ch_right)))
            right--;

            else 
            continue;
        }
        if(Character.toLowerCase(s.charAt(right))==Character.toLowerCase(s.charAt(left)))
        return true;
        else
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("ab"));
    }
}
