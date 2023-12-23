import java.util.Scanner;

public class pc{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size : ");
    int n = sc.nextInt();
    shared_buffer buff = new shared_buffer(n);

    Thread producer = new Thread(new Runnable() {
        public void run()
        {
            for(int i =0;i<5;i++)
            {
                try{
                    buff.produce();
                Thread.sleep(100);}
                catch(InterruptedException e)
                {
                    System.out.println(e);
                }
            }
        }
    });

    Thread consumer = new Thread(new Runnable() {
        public void run()
        {
            for(int i =0;i<5;i++)
            {
                try{buff.consume();
                Thread.sleep(200);}
                catch(InterruptedException e)
                {
                    System.out.println(e);
                }
            }
        }
    });
    producer.start();
    consumer.start();
}

}

class shared_buffer
{
    private int buff[];
    private int size,empty,full,count;

    shared_buffer(int n)
    {
        size = n;
        full = 0;
        empty = 0;
        count = 0;
        buff = new int[n];
    }

    public synchronized void consume() throws InterruptedException
    {
        while(count==0)
        {
            wait();
        }
        
        int item = buff[empty];
        empty = (empty+1)%size;
        count--;

        System.out.println("Producer consume : "+count+Thread.currentThread().getName());

        notify();

    }

    public synchronized void produce() throws InterruptedException
    {
        if(count==size)
        {
            wait();
        }

        buff[full] = 1;
        full = (full+1)%size;
        count++;

        System.out.println("Producer produced : "+count+Thread.currentThread().getName());

        notify();
    }
}