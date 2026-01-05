package fr.juliuselgringo.demojee.demojee;

import java.io.*;

import fr.juliuselgringo.demojee.demojee.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Je vous ai compris!!!!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String lastName = request.getParameter("last-name");
        String firstName = request.getParameter("first-name");
        Integer age = Integer.parseInt(request.getParameter("age"));;
        User newUser = new User(lastName, firstName, age);

        request.setAttribute("message", message);
        request.setAttribute("newUser", newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/page2.jsp");
        dispatcher.forward(request,response);
    }

    public void destroy() {
    }
}