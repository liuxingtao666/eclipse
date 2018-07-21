package parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by L on 2018/7/21.
 */
public class demo3 {
    @Test(dataProvider = "para")
    public void test(String name,int age){
        System.out.println("name="+name+"age="+age);
    }

    @Test(dataProvider = "para")
    public void test2(String name,int age){
        System.out.println("name="+name+"age="+age);
    }
    @DataProvider(name = "para")
    public Object[] [] data(Method method){
        Object[] [] data=null;
        if (method.getName().equals("test")){
                data=new Object[][]{
                        {"zhangsan",18},
                        {"wangwu",20}
                };
        }else if (method.getName().equals("test2")){
            data=new Object[][]{
                    {"zhaoliu",55},
                    {"xiongjiu",66}
            };
        }
        return data;
    }
}
