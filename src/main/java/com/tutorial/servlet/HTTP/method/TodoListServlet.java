package com.tutorial.servlet.HTTP.method;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@WebServlet(urlPatterns = "/todolist")
public class TodoListServlet extends HttpServlet {

    /**
     * HTTP Method
     * ● Secara default, Servlet akan menangani semua jenis HTTP Request dengan Method apapun, seperti GET, POST, PUT, DELETE, dan lain-lain
     * ● Saat kita menggunakan HttpServlet, sebenarnya di dalam method service() sudah terdapat logic untuk memisahkan tiap HTTP Method
     * ● Jika kita hanya ingin membuat logic untuk jenis HTTP Method tertentu, kita bisa langsung override
     * method dengan prefix do dan diakhiri dengan nama HTTP Method nya, misal doGet(), doPost(), dan lain-lain
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/HttpServlet.html
     */

    private List<String> todos = new ArrayList<>();
    private Map<String, Object> res = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("get todo list: {}", res);
        resp.getWriter().println(res); //PrintWriter getWriter() // return response ke client url

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String todo = req.getParameter("todo"); // String getParameter(String var1) // retrieve data request client url

        log.info("todo: {}", todo);

        if (todo != null) {
            todos.add(todo); // boolean add(E e) // data data ke ArrayList<T>
            res.put("data", todos);
            resp.getWriter().println("Add Todo: " + todo); // PrintWriter getWriter() // mengembalikan teks ke client
        } else {
            resp.getWriter().println("Todo Parameter must exists"); // PrintWriter getWriter() // mengembalikan teks ke client
        }

    }

    /**
     * result:
     * url: localhost:8080/todolist?todo=belajar bahasa php
     * Add Todo: belajar bahasa php
     *
     * localhost:8080/todolist
     * {data=[belajar bahasa java, belajar bahasa kotlin, belajar bahasa flutter, belajar bahasa php]}
     *
     */


}
