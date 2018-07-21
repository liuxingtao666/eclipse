import org.testng.annotations.Test;

/**
 * Created by L on 2018/7/21.
 */
public class dependdemo {
    @Test
    public void test(){
        System.out.println("66666");
    }


    @Test(dependsOnMethods = {"test"})
    public void test2(){
        System.out.println("88888888");
    }
}
