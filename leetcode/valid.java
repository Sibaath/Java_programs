import java.util.Stack;

public class valid {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(stack.isEmpty())
            {
                if(ch=='(' || ch=='{' || ch=='[')
                stack.push(ch);
                else
                return false;
            }
            else if(ch=='(' || ch=='{' || ch=='[')
            {
                stack.push(ch);
            }
            else
            {
                if (ch== ')')
            {
                if(stack.peek()!='(')
                return false;
                
            }
            else if (ch=='}')
            {
                if(stack.peek()!='{')
                return false;

            }
            else if( ch==']')
            {
                if(stack.peek()!='[')
                return false;
            }
            stack.pop();
            }
        
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}
