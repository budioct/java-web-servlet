package com.tutorial.servlet.HTTP.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/json")
public class JsonServlet extends HttpServlet {

    /**
     * Response Header
     * ● HttpServletResponse juga memiliki beberapa method yang bisa kita gunakan untuk mengubah Response Header
     * ● setHeader(name, value) untuk mengubah header
     * ● setIntHeader(name, int) untuk mengubah header dengan nilai int
     * ● setDateHeader(name, long) untuk mengubah header dengan nilai date (milis)
     *
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = """
                {
                    "name" : "budhi",
                    "value" : "321"
                }
                """;

        resp.setHeader("Content-Type", "application/json"); // void setHeader(String var1, String var2) // set header untuk response
        resp.setIntHeader("Number", 123123);
        resp.setDateHeader("Date", 1684122502);
        resp.getWriter().println(json); // PrintWriter getWriter() // mengembalikan teks ke client

        /**
         * result:
         * url = localhost:8080/json
         *
         * // header response
         * Content-Type : application/json";charset=ISO-8859-1
         * Number : 123123
         * Date : Tue, 20 Jan 1970 11:48:42 GMT
         *
         *
         * // response body
         * {
         *   "name": "budhi",
         *   "value": "321"
         * }
         */

    }


}
