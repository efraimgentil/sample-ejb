package me.efraimgentil.sampleejbconsumer.ws.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Allow-Headers", "x-requested-with , authorization, accept, Content-Type");
	    response.setHeader("Access-Control-Max-Age", "3600");
		if( !"OPTIONS".equalsIgnoreCase( request.getMethod() ) ){
			chain.doFilter( sRequest , sResponse );
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
