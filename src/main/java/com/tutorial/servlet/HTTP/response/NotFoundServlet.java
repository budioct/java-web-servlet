package com.tutorial.servlet.HTTP.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/not-found")
public class NotFoundServlet extends HttpServlet {

    /**
     * Response Status
     * ● Kita juga bisa mengubah Http Response Status menggunakan HttpServletResponse
     * ● Kita bisa menggunakan method setStatus(code) untuk mengubah status code dari Http Response
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setStatus(404); // void setStatus(int var1) // Menetapkan kode status untuk respons ini.
        resp.getWriter().println("404 Not Found"); // PrintWriter getWriter() // mengembalikan teks ke client

        // resp.setStatus(200); // void setStatus(int var1) // Menetapkan kode status untuk respons ini.
        // resp.getWriter().println("200 OK"); // PrintWriter getWriter() // mengembalikan teks ke client



        /**
         * result:
         * url: localhost:8080/not-found
         * body: 404 Not Found
         *
         * status code: 404 Not Found
         *
         */

    }
}
