package test;

import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		String path=System.getProperty("user.dir");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		/*long t=System.currentTimeMillis();
		String time= String.valueOf(t);*/
		String time=sdf.format(System.currentTimeMillis());
		String p=time+".png";
		System.out.println(path+"/"+p);
				 
	}

}
