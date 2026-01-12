package fr.juliuselgringo.demojee.demojee.servlet;

import fr.juliuselgringo.demojee.demojee.model.User;
import jakarta.annotation.Resource;
import fr.juliuselgringo.demojee.demojee.DAO.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "accueil-servlet", value = "/accueil-servlet")
public class accueilServlet extends HttpServlet {

    private UserDAO userDAO;

    @Resource(name="jdbc/MyDataSource")
    private DataSource ds;

    @Override
    public void init() {
        try{
            userDAO = new UserDAO();
        }catch (SQLException sqle){
            System.out.println("Erreur classe UserDao servlet accueil: " + sqle.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = List.of();
        try (Connection connection = ds.getConnection()) {
            users = userDAO.findAll(connection);
        } catch (SQLException e) {
            System.out.println("Erreur connection UserDao servlet accueil: " + e.getMessage());
        }
        request.setAttribute("usersToDisplay", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}