package com.libis.filter;

import com.libis.controller.LoginController;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    private static final String LOGIN_PATH = "/login";
    private static final String[] STATIC_PREFIXES = {"/css/", "/js/", "/images/"};

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String path = request.getRequestURI().substring(request.getContextPath().length());

        if (isPublic(path)) {
            chain.doFilter(req, res);
            return;
        }

        HttpSession session = request.getSession(false);
        boolean signedIn = session != null
                && session.getAttribute(LoginController.SESSION_MEMBER) != null;

        if (signedIn) {
            response.setHeader("Cache-Control", "no-store");
            chain.doFilter(req, res);
        } else {
            response.sendRedirect(request.getContextPath() + LOGIN_PATH);
        }
    }

    private boolean isPublic(String path) {
        if (path.equals(LOGIN_PATH)) {
            return true;
        }
        for (String prefix : STATIC_PREFIXES) {
            if (path.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}