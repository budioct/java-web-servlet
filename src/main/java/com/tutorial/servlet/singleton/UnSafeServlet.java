package com.tutorial.servlet.singleton;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/unsafe")
public class UnSafeServlet extends HttpServlet {

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

    private String response = ""; // deklarasi variable seperti ini tidak thread safe untuk Java Servlet, karena Single tone dalam mengakses ednpoint/url

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name"); // String getParameter(String var1) // menerima request dari client yang masuk dari url dengan keyword name
        Long sleep = Long.parseLong(req.getParameter("sleep")); // String getParameter(String var1) // menerima request yang masuk dari url dengan keyword name // casting to long untuk waktu delay

        log.info("name {}", name);
        log.info("sleep {}", sleep);

        response = "hello " + name;

        try{
            Thread.sleep(sleep); // native void sleep(long millis) // akan menunda code sampai waktu yang di tentukan selesai
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        resp.getWriter().println(response); // PrintWriter getWriter() // mengembalikan teks ke client

        /**
         * result:
         * url: http://localhost:8080/unsafe?name=malik&sleep=7000
         * hello sendi
         *
         * url: http://localhost:8080/unsafe?name=sendi&sleep=2000
         * hello sendi
         *
         * hasil endpoint di atas hasilnya sama karena terjadi race condition!! dimana endpoint pertama terlalu lama yang hasilnya di timpa oleh endpoint kedua..
         * ini terjadi karena hirarki Servlet adalah singletone. jadi kita tidak boleh menaruh deklarasi variable di luar method servlet, kalau mau di dalam method servlet!!
         * supaya thread sava dalam mengakses endpoint/url
         *
         */

    }



}
