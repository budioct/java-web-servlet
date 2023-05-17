package com.tutorial.servlet.HTTP.request.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    /**
     * Form Request
     * ● Jika user mengirim POST Form Request, kita juga bisa menggunakan method getParameter seperti
     * pada Query Parameter untuk mendapatkan informasi data yang dikirim pada Form Request tersebut
     * ● Artinya getParameter itu secara otomatis akan mengambil data baik itu dari Form Post ataupun Query Param
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * handle response form request, menampilkan form html
         * absolute path: /Dev/2023/Java/NewLearning/_23_Java_Web_Servlet/src/main/resources/html/form.html
         */

        // akses resource linux/IOS
        //Path path = Path.of(FormServlet.class.getResource("/html/form.html").getPath()); // mengambil resource di dalam resource nyaa

        // akses resource windows
        // Class<?> getClass() // get detail class<?> Reflection
        // URL getResource(String name) // mendapat resource file
        // String getFile() // mendapat file url dari resource file
        // Path toPath() // Mengembalikan objek java.nio.file.Path yang dibuat dari jalur abstrak this.
        Path path = new java.io.File(getClass().getResource("/html/form.html").getFile()).toPath(); // mengambil resource di dalam resource nyaa
        String read = Files.readString(path); // mengambil file menjadi String html
        resp.getWriter().println(read);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * handle form request, menerima submit input dari html
         */

        String firstname = req.getParameter("firstname"); // String getParameter(String var1) // retrieve data request client url // menerima input firstname
        String lastname = req.getParameter("lastname"); // String getParameter(String var1) // retrieve data request client url // menerima input lastname
        String fullname = firstname + " " + lastname;
        String response = "hello " + fullname;

        log.info("getParameter(firstname): {}", firstname);
        log.info("getParameter(lastname): {}", lastname);
        log.info("full name: {}", fullname);
        log.info("Response: {}", response);

        resp.getWriter().println(response); // // PrintWriter getWriter() // mengembalikan teks ke client

    }
}
