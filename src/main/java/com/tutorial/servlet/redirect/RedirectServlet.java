package com.tutorial.servlet.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {

    /**
     * ● Untuk melakukan redirect, sebenarnya kita sudah bahas di kelas HTTP, kita cukup menggunakan
     *   status code 302 dan menambahkan header Location yang menuju lokasi baru
     * ● Namun di Servlet, terdapat method yang bisa digunakan untuk mempermudah yaitu
     *   HttpServletResponse.sendRedirect(page)
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("/form"); // void sendRedirect(String var1) // untuk mengalihkan url yang sudah selesai untuk melanjutkan url yang akan di tuju
    }

    /**
     * Result:
     * url: http://localhost:8080/redirect
     *
     * yang akan di tuju adalah
     * url: http://localhost:8080/form
     *
     * kalau kita lihat di inspect element web browser pada kolom Network
     * maka akan ada 2 Name ... redirect dan form
     * di redirect kalau kita lihat di Headers dia menuju Location: http://localhost:8080/form
     *
     */



}
