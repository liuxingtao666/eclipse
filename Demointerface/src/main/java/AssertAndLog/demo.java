package AssertAndLog;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by L on 2018/7/21.
 */
public class demo {
    @Test
    public void test(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2() throws RuntimeException {
        Reporter.log("my log");
        throw new RuntimeException();
    }
}
