package parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by L on 2018/7/21.
 */
public class demo1 {

    @Test
    @Parameters({"name","age"})
    public void test(String name,int age){
        System.out.println("name="+name+"age="+age);
    }
}
