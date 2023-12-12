package cat_questions;

import java.util.ArrayList;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("c");
        list.add("d");
        System.out.println(""+list.remove(3)+":"+list);
    }
}
