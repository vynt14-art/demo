package uef.edu.vn.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthFilter implements Filter {

    @Override
    public void init(
            FilterConfig filterConfig
    ) throws ServletException {

    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest req
                = (HttpServletRequest) request;

        HttpServletResponse res
                = (HttpServletResponse) response;

        HttpSession session
                = req.getSession(false);

        boolean loggedIn
                = session != null
                && session.getAttribute("loggedUser") != null;

        String loginPath
                = req.getContextPath()
                + "/login";

        String uri
                = req.getRequestURI();

        boolean loginRequest
                = uri.endsWith("/")
                || uri.contains("/login")
                || uri.contains("/auth/access-denied");

        boolean resourceRequest
                = uri.contains("/resources/")
                || uri.contains(".css")
                || uri.contains(".js")
                || uri.contains(".png")
                || uri.contains(".jpg");

        if (loggedIn
                || loginRequest
                || resourceRequest) {

            chain.doFilter(
                    request,
                    response
            );

        } else {

            res.sendRedirect(loginPath);
        }
    }

    @Override
    public void destroy() {

    }

}
