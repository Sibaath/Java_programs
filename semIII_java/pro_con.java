package semIII_java;
public class pro_con {
    public static void main(String[] args) {
        
        Buffer sharedBuffer = new Buffer(10);

        Thread producer = new Thread(new Producer(sharedBuffer));
        Thread consumer = new Thread(new Consumer(sharedBuffer));

        producer.start();
        consumer.start();
    }
    
}
class Buffer
{
    private final int capacity;
    private final int[] buffer;
    private int size;
    private int in;
    private int out;

    Buffer(int capacity)
    {
        this.capacity = capacity;
        this.size=0;
        this.in=0;
        this.out=0;
        this.buffer = new int[capacity];
    }

    public synchronized void produce(int item) throws Exception
    {
        if(size==capacity)
        {
            wait();
        }
        buffer[in] = item;
        in = (in+1)%capacity;
        size++;

        System.out.println("Produced : "+size);
        notify();
    }

    public synchronized void consume(int item) throws Exception
    {
        if(size==0)
        {
            wait();
        }
        buffer[out] = item;
        out = (out+1)%capacity;
        size--;

        System.out.println("Consumed : "+size);
        notify();
    }
}

class Producer implements Runnable
{
    private final Buffer buff;
    
    Producer(Buffer buff)
    {
        this.buff = buff;
    }

    public void run()
    {
        try{
            for(int i=0;i<10;i++)
        {
            buff.produce(i);
            Thread.sleep(100);
        }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}

class Consumer implements Runnable
{
    private final Buffer buff;

    Consumer(Buffer buff)
    {
        this.buff = buff;
    }

    public void run()
    {
         try{
            for(int i=0;i<10;i++)
        {
            buff.consume(i);
            Thread.sleep(150);
        }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

// class SharedBuffer {
//     private final int capacity;
//     private final int[] buffer;
//     private int size;
//     private int in; // Index to insert (producer)
//     private int out; // Index to remove (consumer)

//     public SharedBuffer(int capacity) {
//         this.capacity = capacity;
//         this.buffer = new int[capacity];
//         this.size = 0;
//         this.in = 0;
//         this.out = 0;
//     }

//     public synchronized void produce(int item) throws InterruptedException {
//         while (size == capacity) {
//             wait();
//         }

//         buffer[in] = item;
//         in = (in + 1) % capacity;
//         size++;

//         System.out.println("Produced: " + size);

//         notify(); // Notify the consumer that an item is produced
//     }

//     public synchronized void consume() throws InterruptedException {
//         while (size == 0) {
//             wait();
//         }

//         int item = buffer[out];
//         out = (out + 1) % capacity;
//         size--;

//         System.out.println("Consumed: " + size);

//         notify(); // Notify the producer that an item is consume
//     }
// }

// class producer implements Runnable {
//     private final SharedBuffer buffer;

//     public producer(SharedBuffer buffer) {
//         this.buffer = buffer;
//     }

//     @Override
//     public void run() {
//         try {
//             for (int i = 0; i < 10; i++) {
//                 buffer.produce(i);
//                 Thread.sleep(100); // Simulate some processing time
//             }
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
// }

// class consumer implements Runnable {
//     private final SharedBuffer buffer;

//     public consumer(SharedBuffer buffer) {
//         this.buffer = buffer;
//     }

//     @Override
//     public void run() {
//         try {
//             for (int i = 0; i < 10; i++) {
//                 buffer.consume();
//                 Thread.sleep(150); // Simulate some processing time
//             }
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
// }

// public class pro_con {
//     public static void main(String[] args) {
//         SharedBuffer buffer = new SharedBuffer(5);

//         Thread producerThread = new Thread(new producer(buffer));
//         Thread consumerThread = new Thread(new consumer(buffer));

//         producerThread.start();
//         consumerThread.start();
//     }
// }
