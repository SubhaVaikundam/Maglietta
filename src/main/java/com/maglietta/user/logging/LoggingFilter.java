package com.maglietta.user.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * 
 * @author Subha
 *
 */
public class LoggingFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    public void init(final FilterConfig filterConfig) throws ServletException { /**
    **/ }

    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {
        try {
            final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            MDC.put("transactionId", UUID.randomUUID().toString());
            logger.info("request Uri: " + httpServletRequest.getRequestURI()
                    + (httpServletRequest.getQueryString() != null ? "?" + httpServletRequest.getQueryString() : ""));
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.clear();
        }
    }

    public void destroy() {
    	//
    }

}
