package filter;

import entity.user;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "indexFilter",urlPatterns="/Index/*")
public class indexFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("用户验证");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("用户验证处理....");
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String uri = request.getRequestURI();
        if(uri.endsWith("index.html") || uri.endsWith("web/IndexServlet")) {
            chain.doFilter(req, resp);
            return ;
        }
        user User = (user)request.getSession().getAttribute("User") ;
        if(User!=null) {
            chain.doFilter(req, resp);
            return ;
        }
        response.sendRedirect("index.html");
    }

    @Override
    public void destroy() {

    }
}
