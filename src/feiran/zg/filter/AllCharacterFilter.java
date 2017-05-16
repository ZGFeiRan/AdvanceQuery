package feiran.zg.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class AllCharacterFilter implements Filter {
	private FilterConfig config;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 设置请求参数的编码
		String encoding = config.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "UTF-8";
		}
		request.setCharacterEncoding(encoding);

		// 设置POST请求方式的中文请求参数的编码（注意：下边设置的编码进队POST请求有效）
		response.setCharacterEncoding(encoding);// 字节流输出时通知客户端的解码码表
		response.setContentType("text/html;charset=" + encoding);// 字节流输出时通知客户端的解码码表；字符流：字符流输出时使用的码表及通知客户端解码用的码表

		MyHttpServletRequest mrequest = new MyHttpServletRequest(request);
		
		// 放行
		chain.doFilter(mrequest, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}

// HttpServletRequestWrapper内部的代码与连接池原理中那个默认适配器一样
class MyHttpServletRequest extends HttpServletRequestWrapper {

	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		String method = super.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			try {
				value = new String(value.getBytes("ISO-8859-1"), super.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		return value;
	}

}