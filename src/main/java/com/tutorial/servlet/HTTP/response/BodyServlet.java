package com.tutorial.servlet.HTTP.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/body")
public class BodyServlet extends HttpServlet {

    /**
     * HTTP Response
     * ● Pada method service() di Servlet terdapat parameter kedua yaitu ServletResponse
     * ● Atau di HttpServlet menggunakan class HttpServletResponse
     * ● Ini adalah representasi dari HTTP Response
     * ● Untuk mengirim response, kita bisa gunakan object HttpServletResponse tersebut
     *
     * Response Body
     * ● Untuk mengirim response body pada HttpServletResponse, kita bisa menggunakan PrintWriter pada method getWriter()
     * ● Method ini digunakan untuk menulis data apapun ke Response Body pada HTTP Response
     *
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String html = """
                <html>
                <body>
                <h1><u>Belajar Java Servlet<u></h1>
                </body>
                </html>
                """;

        resp.getWriter().println(html);  // PrintWriter getWriter() // mengembalikan teks ke client

    }

}
