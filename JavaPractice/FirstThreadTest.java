package JavaPractice;
  
public class FirstThreadTest extends Thread{  
    int i = 0;  
    //重写run方法，run方法的方法体就是现场执行体  
    @Override
    public synchronized void run()  
    {  
        for(;i<10;i++){  
        System.out.println(getName()+"  "+i);  
            
        }  
    }  
    public static void main(String[] args)  
    {  
        for(int i = 0;i< 10;i++)  
        {  
            System.out.println(Thread.currentThread().getName()+"  : "+i);  
            if(i==5)  
            {  
                new FirstThreadTest().start();  
                new FirstThreadTest().start();  
            }  
        }  
    }  
}