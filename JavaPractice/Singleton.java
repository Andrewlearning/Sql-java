

//懒汉式， 要用的时候才创建。线程不安全
public class SingletonLazy{

    private static SingletonLazy instance;

    private SingletonLazy getInstance(){
        if(instance == null){
            instance = new SingletonLazy();    
        }
        return instance;
    }

    private SingletonLazy(){}
    

}

//饿汉式， 没用的时候就开始创建了,线程不安全
public class  SingletonHunger{

    private static SingletonHunger instance = new SingletonHunger();

    public static SingletonHunger getInstance(){
        return instance;
    }

    private SingletonHunger(){}

}


//双重验证加锁
public class SingletonDouble{

    private static volatile SingletonDouble instance;

    private SingletonDouble(){}

    public static SingletonDouble getInstantce(){

        if (instance == null){
            
            synchronized(SingletonDouble.class){
                if (instance == null){
                    instance = new SingletonDouble();
                }
            }
        }

        return instance;
    }

}