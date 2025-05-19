package web.handler;

import web.service.LoginService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        String dob  = req.getParameter("dob");
        boolean ok = LoginService.login(user, pass, dob);

        resp.setContentType("text/html");
        resp.getWriter()
            .println("<html><head><title>" + (ok ? "success" : "fail") + "</title></head>"
                  + "<body><h1>Login " + (ok ? "Successful" : "Failed") + "</h1></body></html>");
    }
}
