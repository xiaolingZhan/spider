import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * Copyright (c) 2015 
 * 广州米所思信息科技有限公司(Guangzhou Misuosi Information technology co., LTD) 
 * All rights reserved.
 */
/**
 * Description		: 
 * <p/>
 * <br><br>Time		: 2015-11-6 下午9:41:50
 *
 * @author ZXL
 * @version 1.0
 * @since 1.0
 */
public class ReadImage {
	static URL url = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			url = new URL("http://imglf1.ph.126.net/BmbipYn7_35DQLNiIm928A==/56294995359914950.jpg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveImage(url,"fortunate");
	}
	
	public static InputStream getInputStream(URL url){
		InputStream inputStream = null;
		try {
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.setRequestMethod("GET");
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode==200){
				inputStream = httpURLConnection.getInputStream();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputStream;
	}
	
	public static void saveImage(URL url,String photoName){
		byte[] data = new byte[1024*1024*10];
		FileOutputStream fileOutputStream = null;
		InputStream inputStream = getInputStream(url);
		try {
			int len = 0;
			fileOutputStream = new FileOutputStream("E:/Lofter/"+photoName+".jpg");
			if ((len = inputStream.read(data))!=-1){
				fileOutputStream.write(data,0,len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
