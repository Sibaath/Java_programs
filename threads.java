public class threads{
    public static void main(String[] args) {
        conurrency t1 = new conurrency();
        t1.start();
        conurrency t2 = new conurrency();
        t2.start();
    }
}
class conurrency extends Thread
{
    public void run()
    {
        
    }
}
