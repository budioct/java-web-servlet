package com.tutorial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/not-found")
public class NotFoundServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setStatus(404); // void setStatus(int var1) //
        resp.getWriter().println("404 Not Found"); // void setContentLengthLong(long var1) // mengembalikan teks ke client

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
