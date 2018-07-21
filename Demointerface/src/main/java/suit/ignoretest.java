package suit;

import org.testng.annotations.Test;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by L on 218/7/21.
 */
public class ignoretest {
    @Test
    public  void  test1(){
        System.out.println("test1");
    }

    @Test(enabled = false)
    public  void  test2(){
        System.out.println("test2");
    }
}
