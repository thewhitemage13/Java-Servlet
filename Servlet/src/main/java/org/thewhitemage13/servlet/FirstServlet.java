package org.thewhitemage13.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

// Чтоб наш класс стал Servlet - его нужно отнаследовать от HttpServlet
@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("INIT");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        resp.setHeader("MY_HEADER", "HIIII");


        writer.println("<h1>Mukhammed Lolo</h1>");

        String header = req.getHeader("user-agent");
        writer.println("<h1>" + header + "</h1>");

        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            writer.println("<h3>" + headerName + ":" + req.getHeader(headerName) + "</h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp");

        /*resp.setContentType("text/html");
        var writer = resp.getWriter();

        writer.println("<h1>" + req.getParameter("login") + "</h1>");
        writer.println("<h1>" + req.getParameter("pwd") + "</h1>");

        writer.println("<form action=\"second\" method=\"POST\">");
        writer.println("<p>КУРС:</p> <input type=\"text\" name=\" name\"> <br/>");

        writer.println("<p>УСПЕВАЕМОСТЬ:</p> <input type=\"text\" name=\"name\"> <br/>");

        writer.println("<input type=\"submit\" value=\"ОТПРАВИТЬ\">");

        writer.println("</from></body></html>");*/


    }

    @Override
    public void destroy() {
        System.out.println("DESTROY");
    }
}
