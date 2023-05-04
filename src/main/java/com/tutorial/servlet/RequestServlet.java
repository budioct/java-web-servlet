package com.tutorial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/request")
public class RequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("HTTP Method: " + req.getMethod()); // http method
        resp.getWriter().println("Query String: " + req.getQueryString()); // get query post
        resp.getWriter().println("Request URI: " + req.getRequestURI()); // get URI
        resp.getWriter().println("Context Path: " + req.getContextPath()); // get folder project sebagai Context Path
        resp.getWriter().println("Servlet Path: " + req.getServletPath()); // get Servlet path

        /**
         * result :
         *
         * url: http://localhost:8080/request
         * HTTP Method: GET
         * Query String: null
         * Request URI: /request
         * Context Path:
         * Servlet Path: /request
         *
         * url: http://localhost:8080/request?name=budhi
         * HTTP Method: GET
         * Query String: name=budhi
         * Request URI: /request
         * Context Path:
         * Servlet Path: /request
         */

    }

}
