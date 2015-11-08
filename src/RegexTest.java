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
 * <br><br>Time		: 2015-11-7 下午5:04:04
 *
 * @author ZXL
 * @version 1.0
 * @since 1.0
 */
public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regEx = "<img.*src='(.*)'.*/>";
		//String s = "<img src='http://imglf2.ph.126.net/HY4NqyHUGmrO7HLufU7wNg==/2813623867217212430.jpg' />";
		String s = "                         <img src='http://imglf0.nosdn.127.net/img/cHdUb0U0R0FIaHhMY2VKY2hDWlB4VnFtQlpJYW1GSGhIYUdub0p2K3AybTRRVW1ROWhoNkdnPT0.jpg?imageView&amp;thumbnail=164y164&amp;enlarge=1&amp;quality=90&amp;type=jpg' />                  ";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(s);
		boolean rs = mat.find();
		System.out.println(mat.groupCount());
		for(int i=1;i<=mat.groupCount();i++){
			System.out.println(mat.group(i));
		}
	}

}
