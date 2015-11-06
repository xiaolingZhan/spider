import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadDocument.getDocument();
	}

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
}
