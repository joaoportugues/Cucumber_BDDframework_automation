package utils;

import java.util.Date;

public class CommonUtils {
	
	//method to generate email each time by timestamp
		public static String EmailGeneratorByTimeStamp() {
			Date date = new Date();
			return "venagr"+ date.toString().replace(" ", "_").replace(":", "_")+ "@gmail.com";
		}

}
