package com.hepta.funcionarios.filtro;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter({"/funcionarios/*", "/*", "/index.html/*"})
public class FiltroCors implements Filter {

    public FiltroCors() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods",
                "POST , GET , PUT,  DELETE , OPTIONS");
        
        ((HttpServletResponse) response).setContentType("application/json");
        Map<String, String[]> parameterMap = ((HttpServletRequest) request)
        		.getParameterMap();
        parameterMap.forEach((K, V) -> System.out.printf("%s %s\n", K, V[0]));
        chain.doFilter(request, response);
        String method = ((HttpServletRequest) request).getMethod();
        System.out.printf("%s\n", method);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}