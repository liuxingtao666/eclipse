package groups;

import org.testng.annotations.Test;

/**
 * Created by L on 2018/7/21.
 */
public class exceptiondemo {

    @Test(expectedExceptions = RuntimeException.class)
    public void test1(){
        System.out.println("66666666");
    }


    @Test(expectedExceptions = RuntimeException.class)
    public void test2(){
        System.out.println("77777777777");
        throw new RuntimeException();
    }
}
