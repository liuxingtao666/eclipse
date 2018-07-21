package suit;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by L on 2018/7/21.
 */

public class suitconfig {
    @BeforeSuite
    public void befroesuit(){
        System.out.println("@beforesuite");
    }

    @AfterSuite
    public void aftersuit(){
        System.out.println("@aftersuite");
    }
}
