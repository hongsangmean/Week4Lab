package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
        }else{
             if (request.getParameter("logout").equals("Log Out")) {
                session.invalidate();
                session = request.getSession();

                request.setAttribute("message", "You have Successfully logged out");
                
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountService accountService = new AccountService();

        if (password.isEmpty() || username.isEmpty()) {

            accountService.login(username, password);
            request.setAttribute("message", "Should fill in both password and username");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } else if (username != null && password != null) {

            if (accountService.login(username, password) == null) {
                request.setAttribute("message", "Invalid username or password");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }

            session.setAttribute("username", username);
            response.sendRedirect("home");

        }

    }

}
