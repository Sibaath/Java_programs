public class thread1 implements Runnable{
    public static void main(String[] args) {
        Thread obj = new Thread(new Runnable() {
            public void run()
            {
                  for(int i =0;i<5;i++){
                    Thread.currentThread().setName(Integer.toString(5+i+1));
                    Thread.currentThread().setPriority(5-i+1);
                    System.out.println(Thread.currentThread().getName());
                }
     } });
        Runnable obj2 = new Runnable() {
            public void run()
            {
                for(int i =0;i<5;i++)
                {
                    Thread.currentThread().setName(Integer.toString(i+1));
                    Thread.currentThread().setPriority(5-i+1);
                    System.out.println(Thread.currentThread().getName());
                }
                
            }
        };
        obj.start();
      Thread obj1 = new Thread(obj2);
      obj1.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
