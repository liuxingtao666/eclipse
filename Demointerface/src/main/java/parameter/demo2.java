package parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.reflect.generics.tree.VoidDescriptor;

/**
 * Created by L on 2018/7/21.
 */
public class demo2 {
    @Test(dataProvider = "para")
    public void test(String name,int age){
    System.out.println("name="+name+"age="+age);
}
    @DataProvider(name = "para")
    public Object[] [] data(){
        Object[] [] data=new Object[][]{
                {"zhangsan",18},
                {"lisi",19}
        };
        return data;
    }
}
