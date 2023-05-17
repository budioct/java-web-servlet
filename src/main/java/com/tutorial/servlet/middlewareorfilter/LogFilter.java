package com.tutorial.servlet.middlewareorfilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebFilter(urlPatterns = "/*") // akan menangkap semua endpoint, apakah akan di teruskan ke url atau di tolak
public class LogFilter extends HttpFilter {

    /**
     * class ini akan menjadi log, ketiak ada rerquest yang masuk akan di print setiap url yang di request
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
     */

    private static final Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("Received request for URL: {}", request.getRequestURI()); // String getRequestURI() // mendapat request url setiap kali di akses
        chain.doFilter(request, response); // void doFilter(ServletRequest var1, ServletResponse var2) // Menyebabkan filter berikutnya dalam rantai dipanggil, atau jika filter pemanggil adalah filter terakhir dalam rantai, menyebabkan sumber daya di akhir rantai dipanggil.

    }
}
