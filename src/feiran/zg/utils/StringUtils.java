package feiran.zg.utils;

public class StringUtils {
	private StringUtils(){}
	public static Boolean hasLength(String value){
		return value!=null&&(value.trim().length()>0);
	}
}
