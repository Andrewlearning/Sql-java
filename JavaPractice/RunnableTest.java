package JavaPractice;
  
public class RunnableTest implements Runnable {

    private int i;

    @Override
    public synchronized void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(final String[] args)  
    {  
        for(int i = 0;i < 10;i++)  
        {  
            System.out.println(Thread.currentThread().getName()+" "+i);  
            if(i == 5)  
            {  
                final RunnableTest rtt = new RunnableTest();  
                new Thread(rtt,"线程1").start();  
                new Thread(rtt,"新线程2").start();  
            }  
        }  
  
    }
} 