package com.tutorial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/hello", "/world"})
public class HelloServlet extends HttpServlet {

    /**
     * @WebServlet sebagai proses registrasikan jika kita mau class ini di jadikan servlate yang nantinya akan di ekpose dalam URL "/hello", "/world".. dan endpoint nya di panggil maka
     * dia akan panggil method servlate service(HttpServletRequest req, HttpServletResponse resp)
     */

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("hello world"); // PrintWriter getWriter() // mengembalikan teks ke client

        /**
         * result:
         * url: - http://localhost:8080/hello
         *      - http://localhost:8080/world
         *
         * hello world
         */

    }
}
