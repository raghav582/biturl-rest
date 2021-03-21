package com.biturl.urlcode;

import java.util.Arrays;
import java.util.List;

public class UrlCode {

	public final static List<String> URL_CODE = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
											"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
											"u", "v", "w", "x", "y", "z",
											"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
											"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
											"U", "V", "W", "X", "Y", "Z",
											"0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
	
	public static String idToCode(final Long id) throws Exception{
		String code = "";
		Integer entityId = id.intValue();
		for(int i=0; i<6; i++) {
			code = UrlCode.URL_CODE.get(entityId%62) + code;
			entityId = entityId/62;
		}
		
		return code;
	}
	
	public static Long codeToId(final String code) throws Exception{
		String id = "";
		for(int i=0; i<6; i++) {
			id = id + UrlCode.URL_CODE.indexOf(String.valueOf(code.charAt(i))) * (int)Math.pow(62, (5-i));
		}
		
		return Long.parseLong(id);
	}
}
