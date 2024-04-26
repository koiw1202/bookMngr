import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

    static ExecutorService es = Executors.newFixedThreadPool(10) ;

    public static void main(String args[]) {
        ThreadLocal<String> threadLocal = new ThreadLocal() ;
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal() ;

        threadLocal.set("threadLocal TEST") ;
        inheritableThreadLocal.set("inheritableThreadLocal TEST") ;

        System.out.println("@@@@@@@@@@@@@@@@@") ;

        System.out.println(threadLocal.get());
        System.out.println(inheritableThreadLocal.get());

        CompletableFuture.runAsync(() -> {

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

        }, es).join();

        System.out.println("@@@@@@@@@@@@@@@@@") ;

    }
}
