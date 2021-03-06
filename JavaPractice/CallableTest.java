package JavaPractice;
 
import java.util.concurrent.Callable;  
import java.util.concurrent.ExecutionException;  
import java.util.concurrent.FutureTask;  
  
public class CallableTest implements Callable<Integer> {

    public static void main(final String[] args) {
        final CallableTest ctt = new CallableTest();
        
        //我们可以使用 FutureTask来获得ctt的返回值
        final FutureTask<Integer> ft = new FutureTask<Integer>(ctt);  

        for(int i = 0;i < 10;i++)  
        {  
            System.out.println(Thread.currentThread().getName()+ "的循环变量i的值"+i);  
            if(i == 5)  
            {  
                new Thread(ft,"有返回值的线程").start();  
            }  
        }

        
        try  
        {  
            System.out.println("子线程的返回值："+ ft.get());  
        } catch (final InterruptedException e)  
        {  
            e.printStackTrace();  
        } catch (final ExecutionException e)  
        {  
            e.printStackTrace();  
        }  
    }  
  
    @Override  
    public Integer call() throws Exception  
    {  
        int i = 0;  
        for(;i<10;i++)  
        {  
            System.out.println(Thread.currentThread().getName()+" "+i);  
        }  
        return i;  
    }  
  
}  