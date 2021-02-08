package uk.co.redsoft.springboot;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        MDC.clear();
        String id = httpServletRequest.getHeader("X-Correlation_ID");
        if (id != null) {
            MDC.put("correlationId", id);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
