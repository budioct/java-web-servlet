package com.tutorial.servlet;

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

    private List<String> todos = new ArrayList<>();
    private Map<String, Object> res = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println(res); //PrintWriter getWriter() // return response ke client url

        /**
         * result:
         * url: localhost:8080/todolist
         * {data=[belajar bahasa java, belajar bahasa inggris, belajar bahasa php, belajar bahasa golang, belajar bahasa flutter]}
         */

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String todo = req.getParameter("todo"); // String getParameter(String var1) // retrieve data request client url

        log.info("todo: {}", todo);

        if (todo != null) {
            todos.add(todo); // boolean add(E e) // data data ke ArrayList<T>
            res.put("data", todos);
            resp.getWriter().println("Add Todo: " + todo);
        } else {
            resp.getWriter().println("Todo Parameter must exists");
        }

        /**
         * result:
         * url: localhost:8080/todolist?todo=belajar bahasa flutter
         */

    }


}
