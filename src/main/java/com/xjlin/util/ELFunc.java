package com.xjlin.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ELFunc {
	public static String myEncode(String str,String encode){
		try {
			return URLEncoder.encode(str, encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
