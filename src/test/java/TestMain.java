import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

    static ExecutorService es1 = Executors.newFixedThreadPool(10) ;
    static ExecutorService es2 = Executors.newCachedThreadPool() ;
    static ExecutorService es3 = Executors.newScheduledThreadPool(10) ;


    public static void main(String args[]) {
        ThreadLocal<String> threadLocal = new ThreadLocal() ;
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal() ;

        threadLocal.set("threadLocal TEST") ;
        inheritableThreadLocal.set("inheritableThreadLocal TEST") ;

        CompletableFuture.runAsync(() -> {

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

        }, es1).join() ;

    }
}
