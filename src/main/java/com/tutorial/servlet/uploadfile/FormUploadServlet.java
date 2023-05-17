package com.tutorial.servlet.uploadfile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@WebServlet(urlPatterns = "/form-upload")
@MultipartConfig // supaya mendukung upload file
public class FormUploadServlet extends HttpServlet {

    /**
     * Upload File
     * ● Salah satu hal yang biasa dilakukan saat membuat Web adalah, upload file
     * ● Servlet juga mendukung penanganan Upload File menggunakan HttpServletRequest
     * ● getPart(name) digunakan untuk mendapatkan file upload berdasarkan nama
     * ● getParts() digunakan untuk mendapatkan semua file upload
     * ● File upload direpresentasikan dalam interface Part
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/Part.html
     * ● Saat kita membuat Servlet yang akan menerima upload file, kita harus tambahkan annotation
     * @MultipartConfig sebagai penanda bahwa Servlet itu bisa menerima upload file
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/annotation/MultipartConfig.html
     *
     * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // akses resource windows
        // Class<?> getClass() // get detail class<?> Reflection
        // URL getResource(String name) // mendapat resource file
        // String getFile() // mendapat file url dari resource file
        // Path toPath() // Mengembalikan objek java.nio.file.Path yang dibuat dari jalur abstrak this.
        Path path = new File(getClass().getResource("/html/form-upload.html").getFile()).toPath(); // mengambil resource file
        String html = Files.readString(path); // mengambil file menjadi String html
        resp.getWriter().println(html); // return ke client

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name"); // String getParameter(String var1) // get type text data    request client url
        Part profile = req.getPart("profile"); // Part getPart(String var1) // get type file seperti gambar, music, vidio // bentuk byte

        // Path of(String first, String... more) // jalur simpan file
        // String getSubmittedFileName() // Mendapat nama file yang ditentukan oleh klien
        Path uploadLocation = Path.of("upload/" + UUID.randomUUID() + profile.getSubmittedFileName()); // harapanya file akan di simpan ke folder upload
        Files.copy(profile.getInputStream(), uploadLocation); // long copy(InputStream in, Path target, CopyOption... options) // Menyalin semua byte dari input stream ke file.

        //resp.getWriter().println("hello " + name + ", your profile saved in " + uploadLocation.toAbsolutePath()); // Path toAbsolutePath() // mendapat path absolute

        // String replace(CharSequence target, CharSequence replacement) // Mengganti setiap substring dari string ini yang cocok dengan urutan target literal dengan urutan penggantian literal yang ditentukan.
        // Path getFileName() // Mengembalikan nama file atau direktori yang ditunjukkan oleh jalur ini sebagai Path objek.
        String html = """
                <html>
                <body>
                Name : $name
                <br>
                Profile : <img width="400px" height="400px" src="/dwonload?file=$profile" />
                </body>
                <html>
                """
                .replace("$name", name)
                .replace("$profile", uploadLocation.getFileName().toString());

        resp.getWriter().println(html); // response ke user


    }

    /**
     * Result:
     * url/endpoint: http://localhost:8080/form-upload
     * set name and file photo, submit
     *
     * after upload
     * hello screenshoot, your profile saved in C:\Dev\2023\Java\NewLearning\_23_Java_Web_Servlet\\upload\d14c3c64-cd8f-4f5f-b916-b3b4f217d139Capture.JPG
     *
     * after refactor
     * Name : logo-sekolah-dasar
     * Profile : Img
     *
     */



}
