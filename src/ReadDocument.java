import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Copyright (c) 2015 
 * 广州米所思信息科技有限公司(Guangzhou Misuosi Information technology co., LTD) 
 * All rights reserved.
 */
/**
 * Description		: 
 * <p/>
 * <br><br>Time		: 2015-11-6 下午7:46:33
 *
 * @author ZXL
 * @version 1.0
 * @since 1.0
 */
public class ReadDocument {
	static String photoUrl = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadDocument.getWebPage();
		ReadDocument.getDocument();
	}

	/**
	 * 读取文件内容
	 * @param args
	 */
	public static void getDocument(){
		String fileName = "src/hello.txt";
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line=br.readLine())!=null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取网页源代码
	 * @param args
	 */
	public static void getWebPage(){
		boolean flag = false;
		int i = 0;
		try {
			String line = null;
			URL url = new URL("http://www.lofter.com/activity?act=qbview_20130930_03");
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = br.readLine())!=null){
				//System.out.println(line);
				flag = getUrl(line);
				if (flag == true){
					System.out.println("photoUrl="+photoUrl);
					url = new URL(photoUrl);
					//若能取得图片url,则保存图片
					ReadImage.saveImage(url,i+"");
					i++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean getUrl(String line){
		//if (line.equals("			                        				<img src="http://imglf2.ph.126.net/1JxtV-ggC_LfOdkawU87Cw==/6608583852423022334.jpg" />"))
		String regEx = "<img.*src=\"(.*.jpg)\".*/>";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(line);
		boolean rs = mat.find();
		System.out.println(rs);
		if (rs==true){
			System.out.println(mat.groupCount());
			for(int i=1;i<=mat.groupCount();i++){
				System.out.println(mat.group(i));
				photoUrl = mat.group(1);
			}
		}
		return rs;
	}
}
