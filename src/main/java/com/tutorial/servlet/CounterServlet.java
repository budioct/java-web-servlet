package com.tutorial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@WebServlet(urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {

    /**
     * object java.util.concurrent.atomic.AtomicLong
     * length value yang dapat di update secara atomic,digunkana dalam aplikasi untuk nomer urut yang bertambah secara atomic,
     * dan tidak dapat digunakan sebagai penganti
     * class ini memperluas Number untuk memungkinkan akses serangan oleh alat dan utilitas yang berhubungan dengan class basis numberik
     */

    private final AtomicLong atomicLong = new AtomicLong(0);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long total = atomicLong.incrementAndGet();
        String response = "Total Counter: " + total;
        resp.getWriter().println(response); // PrintWriter getWriter() // mengembalikan teks ke client

        log.info("counter {}", total);
        log.info("response {}", response);

    }
}
