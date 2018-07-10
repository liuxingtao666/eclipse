package util;


import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import demo.BaseDriver;
import demo.TakePicture;

public class TestngListener extends TestListenerAdapter{

 
@Override
public void onTestFailure(ITestResult arg0) {
	
	System.out.println("≤‚ ‘ ß∞‹ø™ ºΩÿÕº");
	try {
		this.dotake(arg0);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	super.onTestFailure(arg0);
}

private void dotake(ITestResult tr) throws Exception {
	
	BaseDriver tp=(TakePicture)tr.getInstance();
	tp.dotake();
	
}



	
}
