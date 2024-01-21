package semIII_java;


import java.util.ArrayList;
import java.util.Iterator;


public class agg
{
    public static void main(String[] args) {
        Author obj1 = new Author("Kahleel", "The day in my life");
        Author obj2 = new Author("Ibrahim", "Monsoon nigths");
        Author obj3 = new Author("Sibaath", "The life long");
        Author obj4 = new Author("Salamath", "My merits");

        System.out.println("Authors added");

        ArrayList<Author> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);

        
        
        Book obj5 = new Book("Peace", list);
        Book obj6 = new Book("Horror",list);

        obj5.print_Book();
        obj6.print_Book();

        ArrayList<Book> list2 = new ArrayList<>();
        list2.add(obj5);
        list2.add(obj6);

      //  Library obj7 = new Library(list2);

    }
}

class Author 
{
    String name ,bkname;

    Author (String name,String bkname)
    {
        this.name =name;
        this.bkname = bkname;
    }
}

class Book
{
    String name;
    ArrayList<Author> list ;
     
    Book(String name,ArrayList<Author> list)
    {
        this.name = name;
        this.list = list;
    }

    void print_Book()
    {
        Iterator<Author> it = list.iterator();
        while(it.hasNext())
        {
            Author au = it.next();
            System.out.println("Name : "+au.name+"Book name : "+au.bkname);
        }
    }
}

class Library
{
    ArrayList<Book> list;

    Library(ArrayList<Book> list)
    {
        this.list = list;
    }
}