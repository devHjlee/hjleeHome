package com.hjlee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionTest {
	public static void main(String[] args) {
	      Pattern nonValidPattern = Pattern.compile("[a-zA-Z]");

	      String str = "1234 @#$@#$@#abc123123ZZZZZZZZ1231312313";
	      Matcher matcher = nonValidPattern.matcher(str);
	      String result = ""; 
	        
	      while (matcher.find()) {
	          result += matcher.group(); 
	      }

	       
	                 System.out.println(result);



	}
}
