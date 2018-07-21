package groups;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by L on 2018/7/21.
 */
public class groupsmethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("test1");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("test2");
    }
    @Test(groups = "client")
    public void test11(){
        System.out.println("test3");
    }
    @Test(groups = "client")
    public void test12(){
        System.out.println("test4");
    }
    @BeforeGroups("server")
    public void beforegroupserver(){
        System.out.println("beforegroupserver");
    }

    @BeforeGroups("server")
    public void aftergroupserver(){
        System.out.println("aftergroupserver");
    }

    @BeforeGroups("client")
    public void beforegroupsclient(){
        System.out.println("beforegroupsclient");
    }

    @BeforeGroups("client")
    public void aftergroupsclient(){
        System.out.println("aftergroupsclient");
    }
}
