package filter;

import controller.AuthController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    private AuthController authCtrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthFilter init!");
    }

    AuthController createCtrl() {
        return authCtrl = new AuthController();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String path = req.getPathInfo();

        if (path.indexOf("auth")>=0) {
            createCtrl()
                    .setHttpServletRequest(req)
                    .setHttpServletResponse(res)
                    .route();
            //}
        } else {
            // Разрешить request продвигаться дальше. (Перейти данный Filter).
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("AuthFilter destroy!");
    }
}
