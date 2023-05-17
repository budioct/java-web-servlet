package com.tutorial.servlet.urlPattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/patterns/*")
public class PatternServlet extends HttpServlet {

    /**
     * URL Patterns
     * ● Saat membuat Servlet URL, sebenarnya kita bisa menggunakan patterns atau pola
     * ● Namun patterns yang didukung oleh Servlet sangatlah sederhana, hanya bisa menggunakan patterns * (star)
     *
     * Contoh Patterns
     * URL Patterns         Contoh URL
     * /products/*          /products
     *                      /products/create
     *                      /products/1234
     *                      /products/eko
     *                      /products/1/categories/2
     *
     * /api/*.json          /api/products.json
     *                      /api/products/hello.json
     *                      /api/category/1.json
     *                      /api/products/1/categories/2.json
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println(req.getRequestURI()); //String getRequestURI() // Mengembalikan bagian URL permintaan ini dari nama protokol hingga string kueri di baris pertama permintaan HTTP.

        /**
         * result:
         * url: http://localhost:8080/patterns/1/2/3/nasipadang/saustomat
         *
         * akan return parameter pada URI browser
         * /patterns/1/2/3/nasipadang/saustomat
         *
         */

    }

}
