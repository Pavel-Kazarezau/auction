package by.kazarezov;

import by.kazarezov.bean.User;
import by.kazarezov.dao.UserDAO;
import by.kazarezov.dao.config.DAOConfigurationException;
import by.kazarezov.dao.config.DAOException;
import by.kazarezov.dao.config.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean remember = Boolean.parseBoolean(req.getParameter("remember"));

        DAOFactory daoFactory = null;
        User user = null;
        try {
            daoFactory = DAOFactory.getInstance("javabase.jdbc");
            System.out.println("DAOFactory successfully obtained: " + daoFactory);
            UserDAO userDAO = daoFactory.getUserDAO();
            System.out.println("UserDAO successfully obtained: " + userDAO);
            user = userDAO.find(username, password);
        } catch (DAOConfigurationException | DAOException e) {
            e.printStackTrace();
        }

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("remember", remember);
            resp.sendRedirect("welcome.jsp");
        } else {
            PrintWriter printWriter = resp.getWriter();
            printWriter.println(user);
            //resp.sendRedirect("login.html");
        }
    }
}
