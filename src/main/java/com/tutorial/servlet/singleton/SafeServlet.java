package com.tutorial.servlet.singleton;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/safebro")
public class SafeServlet extends HttpServlet {

    /**
     * Singleton (Satu object di akses semua request)
     * ● Saat Java Web dijalankan, Servlet hanya akan dibuat satu kali, alias singleton
     * ● Oleh karena itu, HTTP Request yang masuk akan selalu menggunakan Servlet yang sama
     * ● Hal ini perlu diperhatikan, karena jika kode yang kita buat tidak Thread Safe, maka data antar HTTP Request bisa tertukar
     * ● Oleh karena itu, pastikan kode yang kita buat harus Thread Safe
     *
     * ini contoh develop servlet method tidak Thread Safe karena singleton
     * jadi setiap user yang mengkases url/endpoint yang di request, hasil dari response tidak konsisten, karena selalu di tiban oleh request yang baru
     * maka hasil response tidak sesuai
     *
     * HttpServletRequest // object yang menangani request url / endpoint
     * HttpServletResponse // object yang menangani response url / endpoint
     */

    // private String response = ""; // tidak thread safe

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name"); // String getParameter(String var1) // menerima request dari client yang masuk dari url dengan keyword name
        Long sleep = Long.parseLong(req.getParameter("sleep")); // String getParameter(String var1) // menerima request yang masuk dari url dengan keyword name // conver to long untuk waktu delay

        log.info("name {}", name);
        log.info("sleep {}", sleep);

        String response = "hello " + name;

        try{
            Thread.sleep(sleep); // native void sleep(long millis) // akan menunda code sampai waktu yang di tentukan selesai
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        resp.getWriter().println(response); // PrintWriter getWriter() // mengembalikan teks ke client

        /**
         * result:
         * url: http://localhost:8080/safebro?name=sendi&sleep=7000
         * hello sendi
         *
         * url: http://localhost:8080/safebro?name=adam&sleep=2000
         * hello adam
         */

    }


}
