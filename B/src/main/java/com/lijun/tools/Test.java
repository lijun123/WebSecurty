package com.lijun.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		
		
		String name=java.net.URLEncoder.encode("测试", "UTF-8");
        System.out.println(name);
        name=java.net.URLEncoder.encode(name,"UTF-8");
        System.out.println(name);
        name=java.net.URLDecoder.decode(name, "UTF-8");
        System.out.println(name);
        System.out.println(java.net.URLDecoder.decode(name, "UTF-8"));
        String test="";
        test=java.net.URLDecoder.decode(test, "UTF-8");
        
        
       


	}

}
