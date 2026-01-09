package fr.juliuselgringo.demojee.demojee.servlet;

import java.io.*;

import fr.juliuselgringo.demojee.demojee.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet", description= "resultat")
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
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String ageParam = request.getParameter("age");
        Integer age = null;
        if (ageParam != null && !ageParam.trim().isEmpty()) {
            try{
                age = Integer.valueOf(ageParam);
            }catch(NumberFormatException nfe){
                age = 0;
            }
        }
        // User constructor expects (firstName, lastName, int)
        User newUser = new User(firstName, lastName, age == null ? 0 : age);

        request.setAttribute("message", message);
        request.setAttribute("newUser", newUser);
        this.getServletContext().getRequestDispatcher("/WEB-INF/page2.jsp").forward(request,response);
    }

    public void destroy() {
    }
}