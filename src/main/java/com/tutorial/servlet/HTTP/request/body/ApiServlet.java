package com.tutorial.servlet.HTTP.request.body;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/api/mahasiswa")
public class ApiServlet extends HttpServlet {

    /**
     * Request Body
     * ● Saat membuat Web, kadang kita tidak hanya membuat jenis Website biasa
     * ● Kadang kita membuat RESTful API yang akhirnya mengharuskan kita membaca data request dari user dalam bentuk format selain Form Post, misal JSON atau XML
     * ● Untuk membaca isi dari Request Body, kita bisa menggunakan method di HttpServletRequest
     * ● getInputStream() untuk mendapatkan Body dalam bentuk Input Stream
     * ● getBufferedReader() untuk mendapatka Body dalam bentuk Buffered Reader
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Mahasiswa mahasiswa = JsonUtil.getObjectMapper().readValue(req.getReader(), Mahasiswa.class); // <T> T readValue(Reader src, Class<T> valueType) // konversi JSON menjadi object java
        String sayHello = "Hello " + mahasiswa.getNama() + " " + mahasiswa.getNim();

        Map<String, String> response = Map.of(
          "data", sayHello
        );

        String jsonResponse = JsonUtil.getObjectMapper().writeValueAsString(response); // String writeValueAsString(Object value) // konversi menjadi JSON

        resp.setHeader("Content-Type", "application/json"); // set header
        resp.getWriter().println(jsonResponse); // return json

        /**
         * result:
         * url: localhost:8080/api/mahasiswa
         *
         * header:
         * Content-Type = application/json;charset=ISO-8859-1
         *
         * request body:
         * {
         *   "nim" : "1511510099",
         *   "nama" : "budhi"
         * }
         *
         * response body:
         * {
         *   "data": "Hello budhi 1511510099"
         * }
         *
         */

    }
}
