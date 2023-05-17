package com.tutorial.servlet.middlewareorfilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginFilter extends HttpFilter {

    /**
     * class ini akan menjadi tempat untuk filter/middleware supaya orang yang tidak punya izin tidak sebarang mendapat akses untuk request ke servlet
     *
     * Filter
     * ● Filter adalah fitur yang terdapat di Servlet yang digunakan sebagai component yang bisa kita tempatkan di depan sebelum object Servlet diakses
     * ● Di bahasa pemrograman lain, biasanya dinamakan Middleware
     * ● Kita bisa membuat Filter mirip seperti Servlet, dimana kita bisa registrasikan ke URL Patterns tertentu
     * ● Nanti secara otomatis setiap kita mengakses URL nya, Filter akan dijalankan, dan kita bisa menentukan apakah Request akan dilanjutkan ke Servlet atau tidak
     * ● Filter juga bisa berlapis, artinya kita bisa membuat lebih dari satu Filter untuk URL Patterns yang sama
     *
     * HttpFilter
     * ● Filter direpresentasikan oleh interface bernama Filter
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/Filter.html
     * ● Sama seperti Servlet, Filter juga punya implementasi class, dan yang biasa digunakan adalah HttpFilter
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/HttpFilter.html
     * ● Untuk membuat Filter, kita harus tambahkan annotation WebFilter pada class nya
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/annotation/WebFilter.html
     *
     *
     */

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        // jika user belum login. maka semua request dia akan di tolak oleh filter/middleware
        // jadi yang pertama di cari oleh filter adalah url /session/login jika
        // jika sudah login  maka akan di teruskan ke servlat
        if (request.getRequestURI().equals("/session/login")){
            chain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession(true); // HttpSession getSession(boolean var1) //  untuk membuat session otomatis
            String username = (String) session.getAttribute("username"); // Object getAttribute(String var1) // get data dari session dengan mengambil keyword yang telah di set untuk mendapat session

            // jika username null maka unautorization, sebaliknya jika tidak null maka akan di teruskan ke servlet
            if (username == null){
                response.setStatus(401);
                response.getWriter().println("You need to login first");
            } else {
                chain.doFilter(request, response);
            }

        }

        /**
         * result:
         * url:
         * http://localhost:8080/hello
         * http://localhost:8080/world
         * http://localhost:8080/form
         * http://localhost:8080/form-upload
         *
         * response, karna semua url sudah di beri filter/middlware. jadi wajib login jika ingin mengakses semua url yang di atas
         * You need to login first
         *
         *
         * http://localhost:8080/session/login?username=budhi
         * Login Success: budhi
         *
         * http://localhost:8080/session/get
         * Hello budhi
         *
         * http://localhost:8080/hello
         * hello world
         *
         * http://localhost:8080/form
         * html form input
         *
         * http://localhost:8080/session/logout
         * Success Logout
         *
         * http://localhost:8080/session/get
         * You need to login first
         *
         *
         *
         */


    }
}
