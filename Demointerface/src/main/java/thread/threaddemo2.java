package thread;

import org.testng.annotations.Test;

/**
 * Created by L on 2018/7/21.
 */
public class threaddemo2 {
    @Test(threadPoolSize = 3 ,invocationCount = 10,timeOut =10000)
    public void test(){
        System.out.println("thread id"+Thread.currentThread().getId());
    }
    @Test(singleThreaded = true)
    public void test1(){
        System.out.println("thread id"+Thread.currentThread().getId());
    }
}
