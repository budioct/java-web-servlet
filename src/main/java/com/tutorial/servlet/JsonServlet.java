package com.tutorial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/json")
public class JsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = """
                {
                    "name" : "budhi",
                    "value" : "321"
                }
                """;

        resp.setHeader("Content-Type", "application/json"); // void setHeader(String var1, String var2) // set header untuk response
        resp.getWriter().println(json); // void setContentLengthLong(long var1) // mengembalikan teks ke client

        /**
         * result:
         * url = localhost:8080/json
         *
         * // header response
         * Content-Type : "application/json";charset=ISO-8859-1
         *
         * // body response
         * {
         *   "name": "budhi",
         *   "value": "321"
         * }
         */

    }


}
