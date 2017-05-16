package feiran.zg.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;



public class BeanUtilMap2Bean {

	private BeanUtilMap2Bean() {}

	public static <T>T Map2Bean(HttpServletRequest request,Class<T> clazz){
		T t = null;
		try {
			t = clazz.newInstance();
//			System.out.println(t);
//			System.out.println(request.getParameterMap().toString());
			BeanUtils.populate(t, request.getParameterMap());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return t;
	}
}
