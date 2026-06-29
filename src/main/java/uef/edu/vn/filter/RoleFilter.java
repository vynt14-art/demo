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

public class RoleFilter implements Filter {

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

        if (session == null
                || session.getAttribute("role") == null) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/login"
            );

            return;
        }

        String role
                = session.getAttribute("role")
                        .toString();

        String uri
                = req.getRequestURI();

        // ===== ADMIN =====
        if (uri.contains("/admin")
                && !role.equals("ADMIN")) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/auth/access-denied"
            );

            return;
        }

        // ===== STAFF =====
        if (uri.contains("/staff")
                && !role.equals("STAFF")) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/auth/access-denied"
            );

            return;
        }

        // ===== KITCHEN =====
        if (uri.contains("/kitchen")
                && !role.equals("KITCHEN")) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/auth/access-denied"
            );

            return;
        }

        chain.doFilter(
                request,
                response
        );
    }

    @Override
    public void destroy() {

    }

}
