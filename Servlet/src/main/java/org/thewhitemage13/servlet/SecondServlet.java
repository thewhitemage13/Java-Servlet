package org.thewhitemage13.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String parameter = req.getParameter("param1");

        var writer = resp.getWriter();

        writer.println("<h1>" + parameter + "</h1>");

        Map<String, String[]> parameterMap = req.getParameterMap();

        parameterMap.entrySet()
                .forEach(e -> writer.println(e.getKey() + " = " + Arrays.toString(e.getValue())));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        var writer = resp.getWriter();
        writer.println("<h1>Second</h1>");
        writer.println("<a href=\"firstpost.html\">Hello Servlet</a>");
    }
}
