package thread;

import org.testng.annotations.Test;

/**
 * Created by L on 2018/7/21.
 */
public class threaddemo {
    @Test
    public void test1(){
        System.out.println("thread id"+"    "+Thread.currentThread().getId());
    }


    @Test
    public void test2(){
        System.out.println("thread id"+"    "+Thread.currentThread().getId());
    }



    @Test
    public void test3(){
        System.out.println("thread id"+"    "+Thread.currentThread().getId());
    }


    @Test
    public void test4(){
        System.out.println("thread id"+"    "+Thread.currentThread().getId());
    }
}
