package com.possistemaecommerc.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;


public class JWTAuthenticationFilter extends GenericFilterBean {

    public static final String SECRET= "minhachavesecretaparaautenticacaojwt";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        final String authHeader = httpServletRequest.getHeader("authorization");
        if ("OPTIONS".equals(httpServletRequest.getMethod())){
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else {
            if(authHeader==null || !authHeader.startsWith("Bearer")){
                throw  new ServletException("An exception occured");
            }
        }
        final String jwtToken=authHeader.substring(7);
        Claims claims= Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
        httpServletRequest.setAttribute("claims",claims);
        httpServletRequest.setAttribute("blog", servletRequest.getParameter("id"));
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
