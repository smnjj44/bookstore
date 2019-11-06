package com.springboot.bookstore.fiflter;

import com.springboot.bookstore.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Date;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            String requestHeader = httpServletRequest.getParameter(this.tokenHeader);
            if (requestHeader != null && requestHeader.startsWith(this.tokenHead)) {
                String authToken = requestHeader.substring(this.tokenHead.length());// The part after "Bearer "
                String token_bak = httpServletRequest.getSession().getAttribute("token_bak") == null ? null : httpServletRequest.getSession().getAttribute("token_bak").toString();
                if (token_bak!=null){
                    Date date =  jwtTokenUtil.getExpiredDateFromToken(authToken);
                    Date date1 =  jwtTokenUtil.getExpiredDateFromToken(token_bak);
                    if (date1.before(date)){
                        httpServletRequest.getSession().removeAttribute("token_bak");
                        httpServletResponse.sendRedirect("/");
                    }
                }
                String username = jwtTokenUtil.getUserNameFromToken(authToken);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                    if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (ExpiredJwtException e) {
            Cookie newCookie = new Cookie("token", null);
            newCookie.setMaxAge(0);
            newCookie.setPath("/");
            httpServletResponse.addCookie(newCookie);
            httpServletResponse.sendRedirect("/");
        }
    }
}
