package cat_questions;

public class reference {
    int[] i ={0};
    public static void main(String[] args) {
        int[] i ={1};
        change(i);
        System.out.println(i[0]);
    }
    public static void change(int i[])
    {
        // int[] j ={2};
        // i[0] =2;
    }
}
