package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {
	
	private String filepath;
	private Properties prop;
	
	//���캯��
	public PropUtil(String filePath) throws IOException{
		this.filepath=filePath;
		this.prop=readProp();
	}
	//��ȡprop�ļ�
	public Properties readProp() throws IOException{
		Properties prop=new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(filepath);
			InputStream in=new BufferedInputStream(file);
			prop.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;	
	}
	//�õ�valueֵ
	public  String getProp(String key) throws IOException {
		String value=prop.getProperty(key);
		return value;
	}
}